package br.com.agendaTelefonica.controller;

import javax.faces.bean.ManagedBean;

import br.com.agendaTelefonica.dao.TelefoneDao;
import br.com.agendaTelefonica.modelo.Telefone;

@ManagedBean
public class TelefoneBean {
	
private Telefone telefone = new Telefone();
	
	public Telefone getTelefone() {
		return this.telefone;
	}
	
	//adiciona os Telefones
	public void adiciona(){
		TelefoneDao dao = new TelefoneDao();
		dao.adiciona(this.telefone);
		this.telefone = new Telefone(); //limpa os campos
	}
}
