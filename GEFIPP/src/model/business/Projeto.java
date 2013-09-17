package model.business;

import java.util.HashSet;
import java.util.Set;

public class Projeto {
	private int id_projeto;
	private String nome;
	private String descricao;
	private float valor_total;
	private Set<ProjetoDoUsuario> projetoDoUsuario = new HashSet<ProjetoDoUsuario>(0);
	private Set<ItemDoProjeto> itemDoProjeto = new HashSet<ItemDoProjeto>(0);
	
	public int getId_projeto() {
		return id_projeto;
	}
	
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getValor_total() {
		return valor_total;
	}
	
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public Set<ProjetoDoUsuario> getProjetoDoUsuario() {
		return projetoDoUsuario;
	}

	public void setProjetoDoUsuario(Set<ProjetoDoUsuario> projetoDoUsuario) {
		this.projetoDoUsuario = projetoDoUsuario;
	}

	public Set<ItemDoProjeto> getItemDoProjeto() {
		return itemDoProjeto;
	}

	public void setItemDoProjeto(Set<ItemDoProjeto> itemDoProjeto) {
		this.itemDoProjeto = itemDoProjeto;
	}
}
