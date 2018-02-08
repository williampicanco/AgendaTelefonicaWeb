package br.com.agendaTelefonica.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.agendaTelefonica.dao.PessoaDao;
import br.com.agendaTelefonica.modelo.Pessoa;
import br.com.agendaTelefonica.util.FacesUtils;


@ManagedBean
public class PessoaBean {
	
	//Lista coleção de Pessoas
	private List<Pessoa> pessoas;
	public List<Pessoa> getPessoas() {

		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	private Pessoa pessoa = new Pessoa();
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	//adiciona as Pessoas
	public void adiciona(){
		PessoaDao dao = new PessoaDao();
		dao.adiciona(this.pessoa);
		this.pessoa = new Pessoa(); //limpa os campos
	}
	//lista as pessoas
	public void lista(){		
		PessoaDao dao = new PessoaDao();
		this.pessoas = dao.lista();
	}
	//remove as pessoas
	public void remove(Pessoa pessoa){
		
		PessoaDao dao = new PessoaDao();
		dao.remove(pessoa);
		this.pessoas = dao.lista();
		new FacesUtils().adicionaMensagemDeSucesso("Pessoa removido com sucesso!");
	}
	//altera as pessoas
	public void altera(){
		
		PessoaDao dao = new PessoaDao();
		dao.atualiza(pessoa);
		new FacesUtils().adicionaMensagemDeSucesso("Pessoa alterado com sucesso!");
	}
}
