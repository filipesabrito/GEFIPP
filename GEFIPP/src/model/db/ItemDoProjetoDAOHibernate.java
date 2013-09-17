package model.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.business.Item;
import model.business.ItemDoProjeto;
import model.util.Hibernate;

public class ItemDoProjetoDAOHibernate implements IItemDoProjetoDAO{
	private Session session = Hibernate.getSessionFactory().openSession();
	
	@Override
	public void save(ItemDoProjeto itemDoProjeto) throws Exception {
        Transaction t = session.beginTransaction();
        session.save(itemDoProjeto);
        t.commit();		
	}

	@Override
	public void update(ItemDoProjeto itemDoProjeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id_item_do_projeto) throws Exception {
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("delete from item_do_projeto where id_item_do_projeto = " + id_item_do_projeto);
        q.executeUpdate();
        t.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemDoProjeto> listAll(int id_projeto) throws Exception {
        Transaction t = session.beginTransaction();
		
		List<Object[]> hibernateList = session.createSQLQuery("select item_do_projeto.id_item_do_projeto, item.nome, item_do_projeto.valor"
				+ " from item_do_projeto, item"
				+ " where item_do_projeto.id_projeto = '"+ id_projeto +"'"
				+ " and item_do_projeto.id_item = item.id_item").list();

		List<ItemDoProjeto> itemDoProjetoList = new ArrayList<ItemDoProjeto>();
	    for (Object[] o : hibernateList) {  
	         Object[] aux = o;
	         ItemDoProjeto i = new ItemDoProjeto();
	         i.setId_item_do_projeto((Integer)aux[0]);
	         i.setNome((String)aux[1]);
	         i.setValor((Float) aux[2]);
	         itemDoProjetoList.add(i);
	    }
	         t.commit();
	         return itemDoProjetoList;
	}

	@Override
	public Item getOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
