package model.db;

import java.util.List;

import model.business.Projeto;

public interface IProjetoDAO {
	
	public void save(Projeto projeto) throws Exception;
	public void update(Projeto projeto) throws Exception;
    public void remove(Projeto projeto) throws Exception;
    public List<Projeto> listAll() throws Exception;
    public Projeto getOne(int id) throws Exception;

}
