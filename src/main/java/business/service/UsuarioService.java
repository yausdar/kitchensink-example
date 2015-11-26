package business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;

import util.Hash;
import util.exception.BusinessRuleException;
import util.security.Role;
import util.security.RolesAllowed;
import model.dao.UsuarioDao;
import model.entity.Usuario;

@Stateless
public class UsuarioService {

	@EJB
	private UsuarioDao usuarioDao;

	@EJB
	private SessaoService sessaoService;
	
	@EJB
	private Hash hashUtil;
	
	public void save(@Valid Usuario user) {
		if (!user.getSenha().equals(user.getConfirmacaoSenha())) {
			throw new BusinessRuleException("Senha não confere!");
		}
		
		if(usuarioDao.findByEmail(user.getEmail()) != null){
			throw new BusinessRuleException("Já existe um usuário cadastrado com esse email!");
		}
		
		user.setSenha(hashUtil.md5(user.getSenha()));
		user.getListaPapel().clear();
		
		if(sessaoService.isAdmin()){
			saveAdmin(user);
			return;
		}

		user.getListaPapel().add(Role.USER);
		usuarioDao.save(user);
	}
	
	
	@RolesAllowed(Role.ADMIN)
	public void saveAdmin(@Valid Usuario user){
		user.getListaPapel().add(Role.ADMIN);
		usuarioDao.save(user);
	}

	@RolesAllowed(Role.ADMIN)
	public List<Usuario> getAll() {
		return usuarioDao.getAll();
	}

}
