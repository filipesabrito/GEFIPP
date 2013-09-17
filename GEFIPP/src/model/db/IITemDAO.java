package model.db;

import java.util.List;

import model.business.Item;

public interface IITemDAO {
	
	public void save(Item item) throws Exception;
	public void update(Item item) throws Exception;
    public void remove(Item item) throws Exception;
    public List<Item> listAllByUser(int id_usuario) throws Exception;
    public Item  getOne(int id) throws Exception;

}
