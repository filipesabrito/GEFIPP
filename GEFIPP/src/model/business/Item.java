package model.business;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private int id_item;
	private String nome;
	private Set<ItemDoProjeto> itemDoProjeto = new HashSet<ItemDoProjeto>(0);
	
	public int getId_item() {
		return id_item;
	}
	
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	
	public String getNome() {
		return nome;
	
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ItemDoProjeto> getItemDoProjeto() {
		return itemDoProjeto;
	}

	public void setItemDoProjeto(Set<ItemDoProjeto> itemDoProjeto) {
		this.itemDoProjeto = itemDoProjeto;
	}
	
	
	
}
