package model.db;

import java.util.List;

import model.business.Projeto;
import model.business.ProjetoDoUsuario;

public interface IProjetoDoUsuarioDAO {
	
	public void save(ProjetoDoUsuario projetoDoUsuario) throws Exception;
	public void update(ProjetoDoUsuario projetoDoUsuario) throws Exception;
    public void remove(ProjetoDoUsuario projetoDoUsuario) throws Exception;
    public List<Projeto> listAll(int id_usuario) throws Exception;
    public Projeto getOne(int id) throws Exception;
	
}
