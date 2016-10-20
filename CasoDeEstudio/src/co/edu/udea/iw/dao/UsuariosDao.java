package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;

public interface UsuariosDao {
	
	public List<Usuarios> obtener() throws MyDaoException;
	
	
	public Usuarios obtener(int cedula) throws MyDaoException;
	

	public void guardar(Usuarios usuario) throws MyDaoException;
	

	public void modificar(Usuarios usuario) throws MyDaoException;
	

	public void eliminar(int cedula) throws MyDaoException;

}
