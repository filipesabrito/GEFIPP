package model.business;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.util.Hibernate;

public class HibernateTest {
	public static void main(String[] args){
		//HibernateTest main = new HibernateTest();
		//main.insertUsuario();
		//main.insertValue();
		//main.getOneUsuario("superadminpadrao", "superadmin");
		//main.listAllByUser();
	}

	public void insertUsuario(){
		Session session = Hibernate.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Usuario usuario = new Usuario();
			usuario.setNome("Exemplo de usu‡rio super administrador");
			usuario.setLogin("superadmim");
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

	public void listAllByUser(){
		Session session = Hibernate.getSessionFactory().openSession();
		Usuario usuario = new Usuario();
		usuario.setId_usuario(11);

		@SuppressWarnings("unchecked")
		List<Object[]> list = session.createSQLQuery(" select projeto.id_projeto, projeto.nome, projeto.descricao, projeto.valor_total "
				+ "from projeto, projeto_do_usuario"
				+ " where projeto_do_usuario.id_usuario = '"+ usuario.getId_usuario() +"'"
				+ " and projeto_do_usuario.id_projeto = projeto.id_projeto").list();
		
		List<Projeto> projetoList = new ArrayList<Projeto>();

	    for (Object[] o : list) {  
	         Object[] aux = o;
	         Projeto p = new Projeto();
	         p.setId_projeto((Integer)aux[0]);
	         p.setNome((String)aux[1]);
	         p.setDescricao((String) aux[2]);
	         p.setValor_total((Float) aux[3]);
	         projetoList.add(p);
	    }
	    
	    java.util.Iterator<Projeto> it = projetoList.iterator();
	    while(it.hasNext()){
	    	Projeto proj = (Projeto) it.next();
	    	System.out.println(proj.getId_projeto());
	    	System.out.println(proj.getNome());
	    	System.out.println(proj.getDescricao());
	    	System.out.println(proj.getValor_total());
	    }
	    
	}
}