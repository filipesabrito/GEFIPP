package model.business;

public class ItemDoProjeto {
	private int id_item_do_projeto;
	private Projeto projeto;
	private Item item;
	private float valor;
	private String nome;
	
	public int getId_item_do_projeto() {
		return id_item_do_projeto;
	}
	
	public void setId_item_do_projeto(int id_item_do_projeto) {
		this.id_item_do_projeto = id_item_do_projeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
