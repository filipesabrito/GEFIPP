package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;

import model.business.Item;
import model.business.ItemDoProjeto;
import model.business.Projeto;
import model.business.ProjetoDoUsuario;
import model.business.Usuario;
import model.db.IITemDAO;
import model.db.IItemDoProjetoDAO;
import model.db.IProjetoDAO;
import model.db.IProjetoDoUsuarioDAO;
import model.db.ItemDAOHibernate;
import model.db.ItemDoProjetoDAOHibernate;
import model.db.ProjetoDAOHibernate;
import model.db.ProjetoDoUsuarioDAOHibernate;

@ManagedBean(name = "projetoController")
@SessionScoped
public class ProjetoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Projeto projetoController = new Projeto();
	private IProjetoDAO projetoDAOHibernate = new ProjetoDAOHibernate();
	private List<Projeto> projetoList = new ArrayList<Projeto>();
	
	private String itemNome;
	private float itemValor;
	private float valorTotalAtual;
	
	private IITemDAO itemDAOHibernate = new ItemDAOHibernate();
	private IItemDoProjetoDAO itemDoProjetoDAOHibernate = new ItemDoProjetoDAOHibernate();
	private IProjetoDoUsuarioDAO projetoDoUsuarioDAOHibernate = new ProjetoDoUsuarioDAOHibernate();  
	 
	
	private Projeto selectedProject;  
	
	@PostConstruct
	public void init() {
		setSelectedProject(new Projeto());
	}
	
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

	
	public List<Projeto> getProjetoList() {
		return projetoList;
	}

	public void setProjetoList(List<Projeto> projetoList) {
		this.projetoList = projetoList;
	}
	
	public Projeto getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(Projeto selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	public void setItemNome(String itemNome){
		this.itemNome = itemNome;
	}
	
	public String getItemNome(){
		return this.itemNome;
	}

	public float getItemValor() {
		return itemValor;
	}

	public void setItemValor(float itemValor) {
		this.itemValor = itemValor;
	}

	public float getValorTotalAtual() {
		return valorTotalAtual;
	}

	public void setValorTotalAtual(float valorTotalAtual) {
		this.valorTotalAtual = valorTotalAtual;
	}
	
	public void listAllByUser(){
		try{
            FacesContext faces = FacesContext.getCurrentInstance();
			
			HttpSession session = (HttpSession) faces.getExternalContext().getSession(false);
			int id_usuario = (Integer) session.getAttribute("id");

			this.setProjetoList(projetoDoUsuarioDAOHibernate.listAll(id_usuario));
			
            faces.getExternalContext().redirect("/GEFIPP/faces/superadmin/projetos.xhtml");
		}catch(Exception e) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void addItem(Projeto projeto){
		try{
			Item item = new Item();
			item.setNome(this.getItemNome());
			
			ItemDoProjeto itemDoProjeto = new ItemDoProjeto();
			itemDoProjeto.setProjeto(projeto);
			itemDoProjeto.setItem(item);
			itemDoProjeto.setValor(this.getItemValor());

			itemDAOHibernate.save(item);
			itemDoProjetoDAOHibernate.save(itemDoProjeto);
			
		}catch(Exception e){
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
    public void save(ActionEvent actionEvent) {
        try {

            FacesContext faces = FacesContext.getCurrentInstance();
        	HttpSession session = (HttpSession) faces.getExternalContext().getSession(false);
			int id_usuario = (Integer) session.getAttribute("id");

        	Usuario usuario = new Usuario();
        	usuario.setId_usuario(id_usuario);
        	

        	ProjetoDoUsuario projetoDoUsuario = new ProjetoDoUsuario();
        	projetoDoUsuario.setProjeto(projetoController);
        	projetoDoUsuario.setUsuario(usuario);
        	
        	projetoDAOHibernate.save(projetoController);
        	projetoDoUsuarioDAOHibernate.save(projetoDoUsuario);
        }catch(Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}	
	
    public void onEdit(RowEditEvent event) {
    	Projeto temp = (Projeto) event.getObject();
    	try {
    		projetoDAOHibernate.update(temp);
    		String mensagem = "Projeto " + temp.getNome() + " editado";
    		FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
		} catch (Exception e) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
    }

    public void deleteProjeto(Projeto projeto){
    	String projetoNome = projeto.getNome();
    	try {
    		projetoDAOHibernate.remove(projeto);
    		String mensagem = "Projeto " + projetoNome + " removido";
    		FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));

    		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    		int id_usuario = (Integer) session.getAttribute("id");

    		projetoList = projetoDoUsuarioDAOHibernate.listAll(id_usuario);
    	} catch (Exception e) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, e);
		}
    }

    public void onCancel(RowEditEvent event) {   
    
    }

}