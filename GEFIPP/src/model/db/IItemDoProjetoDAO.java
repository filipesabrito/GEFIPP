package model.db;

import java.util.List;

import model.business.Item;
import model.business.ItemDoProjeto;

public interface IItemDoProjetoDAO {

	public void save(ItemDoProjeto itemDoProjeto) throws Exception;
	public void update(ItemDoProjeto itemDoProjeto) throws Exception;
    public void remove(int id_item_do_projeto) throws Exception;
    public List<ItemDoProjeto> listAll(int id_projeto) throws Exception;
    public Item  getOne(int id) throws Exception;

}
