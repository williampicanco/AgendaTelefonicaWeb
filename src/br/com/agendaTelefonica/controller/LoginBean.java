package br.com.agendaTelefonica.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.agendaTelefonica.modelo.Pessoa;
import br.com.agendaTelefonica.service.Autenticador;
import br.com.agendaTelefonica.service.AutenticadorImpl;
import br.com.agendaTelefonica.util.FacesUtils;

@ManagedBean
@RequestScoped
public class LoginBean {
	
	private String login;
	private String senha;
	
	@ManagedProperty("#{usuarioWeb}")
	private UsuarioWeb usuarioWeb;
	
	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public String logar(){	
		Autenticador autenticador = new AutenticadorImpl();
		Pessoa pessoa = autenticador.autentica(login, senha);
		if (pessoa != null){
			usuarioWeb.loga(pessoa);//preenche a pessoa na sessão
			return "/pages/pessoa/lista?faces-redirect=true";
			
		}
		new FacesUtils().adicionaMensagemDeErro("Login ou senha são inválidos!");
		return null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String sair(){
		
		usuarioWeb.desloga();
		return "/login?faces-redirect=true";
	}
}
