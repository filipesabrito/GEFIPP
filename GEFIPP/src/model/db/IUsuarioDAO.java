package model.db;

import java.util.List;

import model.business.Usuario;

public interface IUsuarioDAO {
	
	public void save(Usuario usuario) throws Exception;
	public Usuario getOne(String login, String senha) throws Exception;
	public void update(Usuario usuario) throws Exception;
    public void remove(Usuario usuario) throws Exception;
    public List<Usuario>listAll() throws Exception;
}
