package br.com.agendaTelefonica.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.agendaTelefonica.modelo.Pessoa; // precisa ter login e senha

@ManagedBean
@SessionScoped
public class UsuarioWeb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	
	public void loga(Pessoa pessoa){
		this.pessoa = pessoa;	
	}
	
	public Pessoa getUsuario(){
		
		return pessoa;
	}
	
	public boolean isLogado(){
		
		return this.pessoa != null;
		
	}
	
	public void desloga(){
		
		this.pessoa = null;
	}
}
