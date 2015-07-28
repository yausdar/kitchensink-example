package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

import auth.Role;

@XmlRootElement
@Entity
@Table(name = "tb_usuario")
@NamedQueries({
		@NamedQuery(name = "Usuario.getAll", query = "select u from Usuario u left join fetch u.listaPapel"),
		@NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u where u.email = :email"),
		@NamedQuery(name = "Usuario.login", query = "select u from Usuario u left join fetch u.listaPapel where u.email = :email and u.senha = :senha") })
public class Usuario extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3649336154364860073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Size(min = 10, max = 255, message = "O campo NOME COMPLETO deve ter entre 10 e 255 caracteres")
	@NotNull(message = "O campo NOME COMPLETO é obrigatório")
	@Column(name = "ds_nome", length = 255, nullable = false, insertable = true, updatable = true)
	private String nome;

	@Email(message = "O campo EMAIL não possui um formato válido")
	@NotNull(message = "O campo EMAIl é obrigatório")
	@Column(name = "ds_email", length = 255, nullable = false, insertable = true, updatable = true)
	private String email;

	@NotNull(message = "O campo SENHA é obrigatório")
	@Size(min = 8, max = 40, message = "O campo SENHA deve ter entre 8 e 40 caracteres")
	@Column(name = "ds_senha", length = 40, nullable = false, insertable = true, updatable = true)
	private String senha;

	@Transient
	private String confirmacaoSenha;

	@ElementCollection
	@CollectionTable(name = "tb_usuario_papel", joinColumns = @JoinColumn(name = "cd_usuario", referencedColumnName = "id"))
	@Column(name = "ds_papel")
	@Enumerated(EnumType.STRING)
	private List<Role> listaPapel = new ArrayList<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public List<Role> getListaPapel() {
		return listaPapel;
	}

	public void setListaPapel(List<Role> listaPapel) {
		this.listaPapel = listaPapel;
	}

}
