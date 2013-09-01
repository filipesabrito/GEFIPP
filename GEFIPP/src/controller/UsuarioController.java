package controller;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.business.Usuario;
import model.db.IUsuarioDAO;
import model.db.UsuarioDAOHibernate;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
	private Usuario usuarioController = new Usuario();
	private IUsuarioDAO usuarioDAOHibernate = new UsuarioDAOHibernate();
	
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

    public void getUsuario(ActionEvent actionEvent) {
        FacesContext faces = FacesContext.getCurrentInstance();
    	try {
        	Usuario usuario = usuarioDAOHibernate.getOne(usuarioController.getLogin(), usuarioController.getSenha());  
        	if (usuario == null){
        		String mensagem = "Login/Senha incorretos ou usu‡rio inexistente";
        		FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
        	}else{
        		if(usuario.getNivel_permissao() == Usuario.ADMIN){
                    faces.getExternalContext().redirect("/GEFIPP/admin/index.xhtml");
        		}else{
                    faces.getExternalContext().redirect("/GEFIPP/faces/superadmin/index.xhtml");
        		}
        	}
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }	
	
	
}
