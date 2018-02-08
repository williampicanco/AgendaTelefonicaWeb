package br.com.agendaTelefonica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.agendaTelefonica.modelo.Telefone;
import br.com.agendaTelefonica.util.JPAUtil;

public class TelefoneDao {

	//*** INSERT Telefone
		public void adiciona(Telefone telefone) {
			EntityManager manager = new JPAUtil().getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(telefone);
				transaction.commit();
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} finally {
				manager.close();
			}
		}
}
