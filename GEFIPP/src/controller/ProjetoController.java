package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.business.ItemDoProjeto;
import model.business.Projeto;
import model.business.ProjetoDoUsuario;
import model.db.IProjetoDAO;
import model.db.ProjetoDAOHibernate;

@ManagedBean(name = "projetoController")
@SessionScoped
public class ProjetoController implements Serializable {
	private Projeto projetoController = new Projeto();
	private IProjetoDAO projetoDAOHibernate = new ProjetoDAOHibernate();
	private Set<ProjetoDoUsuario> setList = new HashSet<ProjetoDoUsuario>();
	private List<Projeto> lista = new ArrayList<Projeto>();
	
	public ProjetoController(){
	}

	// ============================================================================================
	public int getId_projeto() {
		return projetoController.getId_projeto();
	}
	
	public void setId_projeto(int id_projeto) {
		projetoController.setId_projeto(id_projeto);
	}
	
	public String getNome() {
		return projetoController.getNome();
	}
	
	public void setNome(String nome) {
		projetoController.setNome(nome);
	}
	
	public String getDescricao() {
		return projetoController.getDescricao();
	}
	
	public void setDescricao(String descricao) {
		projetoController.setDescricao(descricao);
	}
	
	public float getValor_total() {
		return projetoController.getValor_total();
	}
	
	public void setValor_total(float valor_total) {
		projetoController.setValor_total(valor_total);
	}

	public Set<ProjetoDoUsuario> getProjetoDoUsuario() {
		return projetoController.getProjetoDoUsuario();
	}

	public void setProjetoDoUsuario(Set<ProjetoDoUsuario> projetoDoUsuario) {
		projetoController.setProjetoDoUsuario(projetoDoUsuario);
	}

	public Set<ItemDoProjeto> getItemDoProjeto() {
		return projetoController.getItemDoProjeto();
	}

	public void setItemDoProjeto(Set<ItemDoProjeto> itemDoProjeto) {
		projetoController.setItemDoProjeto(itemDoProjeto);
	}	
	
	// ============================================================================================
	
	
	public void listAll(){
		try{
			//lista = projetoController.getProjetoDoUsuario();
			
		}catch(Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
