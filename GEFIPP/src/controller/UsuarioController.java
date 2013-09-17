package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import model.business.Usuario;
import model.db.IUsuarioDAO;
import model.db.UsuarioDAOHibernate;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuarioController = new Usuario();
	private IUsuarioDAO usuarioDAOHibernate = new UsuarioDAOHibernate();
	private boolean adminAutorizado;
	private boolean superAdminAutorizado;
	
	public UsuarioController(){
	}
	
	// ============================================================================================
	public int getId_usuario() {
		return usuarioController.getId_usuario();
	}

	public void setId_usuario(int id_usuario) {
		usuarioController.setId_usuario(id_usuario);
	}
		
	public String getNome() {
		return usuarioController.getNome();
	}

	public void setNome(String nome) {
		usuarioController.setNome(nome);
	}

	public String getLogin() {
		return usuarioController.getLogin();
	}

	public void setLogin(String login) {
		usuarioController.setLogin(login);
	}
	
	public String getSenha() {
		return usuarioController.getSenha();
	}

	public void setSenha(String senha) {
		usuarioController.setSenha(senha);
	}
	
	public int getNivel_permissao() {
		return usuarioController.getNivel_permissao();
	}

	public void setNivel_permissao(int nivel_permissao) {
		usuarioController.setNivel_permissao(nivel_permissao);
	}
	// ============================================================================================
	public boolean isAdminAutorizado() {
		return adminAutorizado;
	}
	
	public void setAdminAutorizado(boolean adminAutorizado) {
		this.adminAutorizado = adminAutorizado;
	}

	public boolean isSuperAdminAutorizado() {
		return superAdminAutorizado;
	}
	
	public void setSuperAdminAutorizado(boolean superAdminAutorizado) {
		this.superAdminAutorizado = superAdminAutorizado;
	}
	
    public void login(ActionEvent actionEvent) {
        FacesContext faces = FacesContext.getCurrentInstance();
    	try {
        	Usuario usuario = usuarioDAOHibernate.getOne(usuarioController.getLogin(), usuarioController.getSenha()); 
        	if (usuario == null){
        		String mensagem = "Login/Senha incorretos ou usu‡rio inexistente";
        		FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
        	}else{
        		
        		HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
        		session.setAttribute("nome", usuario.getNome());
        		session.setAttribute("id", usuario.getId_usuario());

        		usuarioController.setNome(usuario.getNome());

        		if(usuario.getNivel_permissao() == Usuario.ADMIN){
                    faces.getExternalContext().redirect("/GEFIPP/faces/admin/index.xhtml");
                    this.setAdminAutorizado(true);
        		}else{
                    faces.getExternalContext().redirect("/GEFIPP/faces/superadmin/index.xhtml");
                    this.setSuperAdminAutorizado(true);
        		}
        	}
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }	
	
    public void logout(ActionEvent actionEvent) {
    	try{
    		FacesContext faces = FacesContext.getCurrentInstance();
    		HttpSession session = (HttpSession) faces.getExternalContext().getSession(false);
    		session.invalidate();
    		faces.getExternalContext().redirect("/GEFIPP/faces/index.xhtml");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificarAutorizacaoAdmin(ComponentSystemEvent e){
    	if (!this.isAdminAutorizado()) {
    		try {
    			FacesContext.getCurrentInstance().getExternalContext().redirect("/GEFIPP/faces/index.xhtml");
    		} catch (IOException ex) {
    			Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    		}
    	}
    }

    public void verificarAutorizacaoSuperAdmin(ComponentSystemEvent e){
    	if (!this.isSuperAdminAutorizado()) {
    		try {
    			FacesContext.getCurrentInstance().getExternalContext().redirect("/GEFIPP/faces/index.xhtml");
    		} catch (IOException ex) {
    			Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    		}
    	}
    }
    
}