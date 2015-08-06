package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@NamedQuery(name = "Param.getAll", query = "select p from Param p")
@Entity
@Table(name = "tb_param")
public class Param extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253799901809779594L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@NotNull(message = "O campo CHAVE não pode ser nulo")
	@Length(min = 3 , max = 255 , message = "O campo CHAVE deve ter entre 3 e 255 caracteres")
	@Column(name = "ds_chave", unique = true, nullable = false , length = 255)
	private String chave;

	@NotNull(message = "O campo VALOR não pode ser nulo")
	@Length(min = 3 , max = 255 , message = "O campo VALOR deve ter entre 3 e 255 caracteres")
	@Column(name = "ds_valor", unique = true, nullable = false , length = 255)
	private String valor;

	@NotNull(message = "O campo DESCRIÇÃO não pode ser nulo")
	@Length(min = 3 , max = 255 , message = "O campo DESCRIÇÃO deve ter entre 3 e 255 caracteres")
	@Column(name = "ds_descricao", unique = true, nullable = false , length = 255)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
