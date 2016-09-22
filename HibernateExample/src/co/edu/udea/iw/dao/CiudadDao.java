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
	
	
	/**
	 * Entrega una ciudad del codigo ingresado
	 * @param codigo codigo de la ciudad
	 * @return Ciudad obtenida
	 * @throws MyDaoException
	 */
	public Ciudad obtener(Long codigo) throws MyDaoException;
	
	/**
	 * Guarda una ciudad en la bd
	 * @param ciudad Ciudad a guardar
	 * @throws MyDaoException
	 */
	public void guardar(Ciudad ciudad) throws MyDaoException;
	
	/**
	 * Modifica una ciudad
	 * @param ciudad Ciudad con las modificaciones realizadas
	 * @throws MyDaoException
	 */
	public void modificar(Ciudad ciudad) throws MyDaoException;
	
	/**
	 * Elimina una ciudad de la base de datos
	 * @param codigo codigo de laciudad a eliminar.
	 * @throws MyDaoException
	 */
	public void eliminar(Long codigo) throws MyDaoException;
	

}
