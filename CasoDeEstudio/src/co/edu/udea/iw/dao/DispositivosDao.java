package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivos;
import co.edu.udea.iw.exception.MyDaoException;

public interface DispositivosDao {
	
	
	public List<Dispositivos> obtener() throws MyDaoException;
	
	public Dispositivos obtener(int no_serie) throws MyDaoException;
	
	/**
	 * Agrega un dispositivo a la base de datos
	 * @param dispositivo 
	 * @throws MyDaoException
	 */
	public void guardar(Dispositivos dispositivo) throws MyDaoException;
	
	public void eliminar(int no_serie) throws MyDaoException;
	
	public void modificar(Dispositivos dispositivo) throws MyDaoException;

}
