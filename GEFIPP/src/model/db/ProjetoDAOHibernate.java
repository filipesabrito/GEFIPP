package model.db;

import java.util.List;

import org.hibernate.Session;

import model.business.Projeto;
import model.business.Usuario;
import model.util.Hibernate;

public class ProjetoDAOHibernate implements IProjetoDAO{
	private Session session = Hibernate.getSessionFactory().openSession();
	
	@Override
	public void save(Projeto projeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Projeto projeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Projeto projeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Projeto> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projeto getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	
}
