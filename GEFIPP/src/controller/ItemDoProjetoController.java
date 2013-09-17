package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import model.business.Item;
import model.business.ItemDoProjeto;
import model.business.Projeto;
import model.db.IItemDoProjetoDAO;
import model.db.ItemDoProjetoDAOHibernate;

@ManagedBean(name = "itemDoProjetoController")
@SessionScoped
public class ItemDoProjetoController  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private ItemDoProjeto itemDoProjetoController = new ItemDoProjeto();  
	private IItemDoProjetoDAO itemDoProjetoDAOHibernate = new ItemDoProjetoDAOHibernate();
	private List<ItemDoProjeto> itemDoProjetoList = new ArrayList<ItemDoProjeto>();
	
	public ItemDoProjetoController(){
	}
	
	// ============================================================================================
	public int getId_item_do_projeto() {
		return itemDoProjetoController.getId_item_do_projeto();
	}
	
	public void setId_item_do_projeto(int id_item_do_projeto) {
		itemDoProjetoController.setId_item_do_projeto(id_item_do_projeto);
	}

	public Projeto getProjeto() {
		return itemDoProjetoController.getProjeto();
	}

	public void setProjeto(Projeto projeto) {
		itemDoProjetoController.setProjeto(projeto);
	}

	public Item getItem() {
		return itemDoProjetoController.getItem();
	}

	public void setItem(Item item) {
		itemDoProjetoController.setItem(item);
	}

	public float getValor() {
		return itemDoProjetoController.getValor();
	}
	
	public void setValor(float valor) {
		itemDoProjetoController.setValor(valor);
	}

	public String getNome() {
		return itemDoProjetoController.getNome();
	}

	public void setNome(String nome) {
		itemDoProjetoController.setNome(nome);
	}
	// ============================================================================================
	public List<ItemDoProjeto> getItemDoProjetoList() {
		return itemDoProjetoList;
	}

	public void setItemDoProjetoList(List<ItemDoProjeto> itemDoProjetoList) {
		this.itemDoProjetoList = itemDoProjetoList;
	}

	public void list(Projeto projeto){
		try {
			this.setItemDoProjetoList(itemDoProjetoDAOHibernate.listAll(projeto.getId_projeto()));
		} catch (Exception e) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
    public void onEdit(RowEditEvent event) {
    }

	
	public void onCancel(RowEditEvent event) {   
        
    }
	
    public void deleteItem(ItemDoProjeto itemDoProjeto){
    	String itemDoProjetoNome = itemDoProjeto.getNome();
    	try {
    		//itemDoProjetoList.remove(itemDoProjeto);
    		itemDoProjetoDAOHibernate.remove(itemDoProjeto.getId_item_do_projeto());
    		String mensagem = "Item " + itemDoProjetoNome + " removido";
    		FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
    	} catch (Exception e) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
    }
	
	

}
