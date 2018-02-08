package br.com.agendaTelefonica.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {
	
private FacesContext facesContex;
	
	public FacesUtils(){
		
		this.facesContex = FacesContext.getCurrentInstance();
	}
	
	public void adicionaMensagemDeErro(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		facesContex.addMessage(null, facesMessage);
	}
	
	public void adicionaMensagemDeSucesso(String mensagem){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		facesContex.addMessage(null, facesMessage);
		
	}
}
