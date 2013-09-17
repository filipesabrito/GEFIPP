package model.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.business.Item;
import model.util.Hibernate;

public class ItemDAOHibernate implements IITemDAO{
	private Session session = Hibernate.getSessionFactory().openSession();

	@Override
	public void save(Item item) throws Exception {
        Transaction t = session.beginTransaction();
        session.save(item);
        t.commit();
	}

	@Override
	public void update(Item item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Item item) throws Exception {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listAllByUser(int id_usuario) throws Exception {
        Transaction t = session.beginTransaction();
		
        List<Object[]> hibernateList = session.createSQLQuery("select item.id_item, item.nome"
				+ " from item, item_do_projeto, projeto, projeto_do_usuario"
				+ " where projeto_do_usuario.id_usuario = '"+ id_usuario +"'"
				+ " and projeto_do_usuario.id_projeto = projeto.id_projeto" 
				+ " and item_do_projeto.id_item_do_projeto = item.id_item").list();

		List<Item> itemList = new ArrayList<Item>();
	    for (Object[] o : hibernateList) {  
	         Object[] aux = o;
	         Item item = new Item();
	         item.setId_item((Integer)aux[0]);
	         item.setNome((String)aux[1]);
	         itemList.add(item);
	    }		
		
        t.commit();
        return itemList;
	}

	@Override
	public Item getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
