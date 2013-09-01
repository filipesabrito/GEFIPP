package model.business;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.util.Hibernate;

public class HibernateTest {
	public static void main(String[] args){
		HibernateTest main = new HibernateTest();
		
		//main.insertUsuario();
		//main.insertValue();
		main.getOneUsuario("superadminpadrao", "superadmin");
	}

	public void insertUsuario(){
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Usuario usuario = new Usuario();
			usuario.setNome("Super Administrador Padrao do GEFIPP");
			usuario.setLogin("superadminpadrao");
			usuario.setSenha("superadmin");
			usuario.setNivel_permissao(2);
			
			session.save(usuario);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");     
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		

	}
	/*
	public void insertValue(){
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;

		try{
			transaction = session.beginTransaction();

			Value value = new Value();
			value.setContent("hi");
			Tag tag_ = (Tag) session.createQuery("from Tag where children_tag like '%TESTE%' ").uniqueResult();
			value.setTag(tag_);	

			session.save(value);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");     
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}	
	}
*/
	public void getOneUsuario(String login, String senha) {
		Session session = Hibernate.getSessionFactory().openSession();
		Usuario usuario = (Usuario) session.createQuery("from Usuario where login like '"+ login +"' and senha like '" +senha+"'").uniqueResult();
		System.out.println(usuario.getNivel_permissao());
	}

}
