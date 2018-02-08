package br.com.agendaTelefonica.service;

import br.com.agendaTelefonica.modelo.Pessoa;

public interface Autenticador {

	public Pessoa autentica(String login, String senha);
	
}