package br.com.agendaTelefonica.service;

import br.com.agendaTelefonica.dao.PessoaDao;
import br.com.agendaTelefonica.modelo.Pessoa;

public class AutenticadorImpl implements Autenticador {

	@Override
	public Pessoa autentica(String login, String senha) {
		PessoaDao dao = new PessoaDao();
		Pessoa pessoa = dao.buscaPor(login, senha);
		return pessoa;
	}

}