package model.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.business.Projeto;
import model.util.Hibernate;

public class ProjetoDAOHibernate implements IProjetoDAO{
	private Session session = Hibernate.getSessionFactory().openSession();
	
	@Override
	public void save(Projeto projeto) throws Exception {
        Transaction t = session.beginTransaction();
        session.save(projeto);
        t.commit();
	}

	@Override
	public void update(Projeto projeto) throws Exception {
        Transaction t = session.beginTransaction();
        session.update(projeto);
        t.commit();
	}

	@Override
	public void remove(Projeto projeto) throws Exception {
        Transaction t = session.beginTransaction();
        session.delete(projeto);
        t.commit();
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
