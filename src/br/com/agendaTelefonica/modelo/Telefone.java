package br.com.agendaTelefonica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.agendaTelefonica.modelo.Telefone;
import br.com.agendaTelefonica.util.JPAUtil;

@Entity
public class Telefone implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ddd;
	
	private String numero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
