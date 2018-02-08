package br.com.agendaTelefonica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.com.agendaTelefonica.modelo.Pessoa;
import br.com.agendaTelefonica.util.JPAUtil;
//import br.com.triadworks.bugtracker.modelo.Usuario;
//import br.com.triadworks.bugtracker.modelo.Usuario;


public class PessoaDao {
	
	//*** SELECT ALL Pessoa
	public List<Pessoa> lista() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.createQuery("select p from Pessoa p", Pessoa.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}
	//*** INSERT Pessoa
	public void adiciona(Pessoa pessoa) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(pessoa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	//*** UPDATE Pessoa
	public void atualiza(Pessoa pessoa) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(pessoa);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	//*** DELETE Pessoa
	public void remove(Pessoa pessoa) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(manager.merge(pessoa));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public Pessoa busca(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.find(Pessoa.class, id);
		} finally {
			manager.close();
		}
	}
	
	public Pessoa buscaPor(String login, String senha) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select p from Pessoa p "
									+ "where p.login = :login and p.senha = :senha", Pessoa.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			manager.close();
		}
	} 
	
	
}
