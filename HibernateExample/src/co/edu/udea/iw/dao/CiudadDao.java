package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los metodos para acceder a las Ciudades
 * @author aux10
 *
 */


public interface CiudadDao {
	
	
	/**
	 * Entrega la lista de ciudades disponibles en la bd
	 * @return
	 * @throws MyDaoException
	 */
	public List<Ciudad> obtener() throws MyDaoException;

}
