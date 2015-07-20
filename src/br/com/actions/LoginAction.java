package br.com.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport  {
	private static Map<String, String> mapa = new HashMap<String, String>();
	
	private String usuario;
	private String senha;
	private String mensagem;
	
	static {
		LoginAction.mapa.put("jhol", "123");
		LoginAction.mapa.put("cristian", "456");
		LoginAction.mapa.put("user", "789");
		LoginAction.mapa.put("usuario", "012");
	}
	
	public String execute() throws Exception {
		if(LoginAction.mapa.containsKey(this.usuario)
				&& LoginAction.mapa.get(this.usuario).equals(this.senha)){
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("usuario", this.usuario);
			
			this.mensagem = "Autenticação realizada com Sucesso.";
			return LoginAction.SUCCESS;
			
		} else {
			this.mensagem = "Usuário e/ou senha incorretos.";
			return LoginAction.INPUT;
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
