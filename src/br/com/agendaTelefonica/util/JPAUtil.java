package br.com.agendaTelefonica.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//mesma coisa do método CriarTabela
public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("agendatelefonica");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
