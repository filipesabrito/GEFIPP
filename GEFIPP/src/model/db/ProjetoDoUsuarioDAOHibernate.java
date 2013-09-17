package model.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.business.Projeto;
import model.business.ProjetoDoUsuario;
import model.util.Hibernate;

public class ProjetoDoUsuarioDAOHibernate implements IProjetoDoUsuarioDAO{
	private Session session = Hibernate.getSessionFactory().openSession();

	@Override
	public void save(ProjetoDoUsuario projetoDoUsuario) throws Exception {
        Transaction t = session.beginTransaction();
        session.save(projetoDoUsuario);
        t.commit();
	}

	@Override
	public void update(ProjetoDoUsuario projetoDoUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ProjetoDoUsuario projetoDoUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> listAll(int id_usuario) throws Exception {
        Transaction t = session.beginTransaction();
		
        List<Object[]> hibernateList = session.createSQLQuery("select projeto.id_projeto, projeto.nome, projeto.descricao, projeto.valor_total"
				+ " from projeto, projeto_do_usuario"
				+ " where projeto_do_usuario.id_usuario = '"+ id_usuario +"'"
				+ " and projeto_do_usuario.id_projeto = projeto.id_projeto").list();
		
		List<Projeto> projetoList = new ArrayList<Projeto>();
	    for (Object[] o : hibernateList) {  
	         Object[] aux = o;
	         Projeto projeto = new Projeto();
	         projeto.setId_projeto((Integer)aux[0]); 
	         projeto.setNome((String)aux[1]); 
	         projeto.setDescricao((String) aux[2]);
	         projeto.setValor_total((Float) aux[3]);
	         projetoList.add(projeto);
	    }		
		
        t.commit();
        return projetoList;
	}

	@Override
	public Projeto getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
