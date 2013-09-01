package model.business;

public class ProjetoDoUsuario {
	private int id_projeto_do_usuario;
	private Usuario usuario;
	private Projeto projeto;
	
	public int getId_projeto_do_usuario() {
		return id_projeto_do_usuario;
	}
	
	public void setId_projeto_do_usuario(int id_projeto_do_usuario) {
		this.id_projeto_do_usuario = id_projeto_do_usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
}
