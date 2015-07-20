package br.com.actions;

import java.util.List;

import br.com.model.Usuario;
import br.com.model.UsuarioRepository;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UsuarioAction extends ActionSupport{
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	public String adicionaOuAltera() {
		UsuarioRepository userRepository = new UsuarioRepository();
		if(this.usuario.getId() == null) {
			userRepository.adiciona(this.usuario);
		} else {
			userRepository.altera(this.usuario);
		}
		this.usuario = new Usuario();
		return UsuarioAction.SUCCESS;
	}
	
	public String remove() {
		UsuarioRepository userRepository = new UsuarioRepository();
		userRepository.remove(this.usuario.getId());
		this.usuario = new Usuario();
		return UsuarioAction.SUCCESS;
	}
	
	public String preparaAlteracao() {
		UsuarioRepository userRepository = new UsuarioRepository ();
		this.usuario = userRepository.buscaId(this.usuario.getId());
		return UsuarioAction.SUCCESS;
	}
	
	public String lista() {
		UsuarioRepository userRepository = new UsuarioRepository ();
		this.usuarios = userRepository.lista();
		return UsuarioAction.SUCCESS;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}