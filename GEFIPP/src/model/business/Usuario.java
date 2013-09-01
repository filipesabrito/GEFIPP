package model.business;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String login;
	private String senha;
	private int nivel_permissao;
	public static final int ADMIN = 1;
	public static final int SUPER_ADMIN = 2;
	
	private Set<ProjetoDoUsuario> projetoDoUsuario = new HashSet<ProjetoDoUsuario>(0);

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getNivel_permissao() {
		return nivel_permissao;
	}

	public void setNivel_permissao(int nivel_permissao) {
		this.nivel_permissao = nivel_permissao;
	}

	public Set<ProjetoDoUsuario> getProjetoDoUsuario() {
		return projetoDoUsuario;
	}

	public void setProjetoDoUsuario(Set<ProjetoDoUsuario> projetoDoUsuario) {
		this.projetoDoUsuario = projetoDoUsuario;
	}

}