package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.PKCompuesta;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.MyDaoException;

public interface SancionDao {
	
	public List<Sancion> obtener() throws MyDaoException;
	
	public Sancion obtener(PKCompuesta id) throws MyDaoException;
	
	public void eliminar(PKCompuesta id) throws MyDaoException;
	
	public void guardar(Sancion sancion) throws MyDaoException;
	
	public void modificar(Sancion sancion) throws MyDaoException;

}
