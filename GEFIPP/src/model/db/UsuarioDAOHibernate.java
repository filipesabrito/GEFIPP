package model.db;

import java.util.List;

import org.hibernate.Session;



import model.business.Usuario;
import model.util.Hibernate;

public class UsuarioDAOHibernate implements IUsuarioDAO {
	private Session session = Hibernate.getSessionFactory().openSession();

	@Override
	public void save(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuario getOne(String login, String senha) throws Exception {
		Usuario usuario = (Usuario) session.createQuery("from Usuario where login like '"+ login +"' and senha like '" + senha +"'").uniqueResult();
		return usuario;
	}	

}
