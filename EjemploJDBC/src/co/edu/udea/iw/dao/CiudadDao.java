package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.dto.Ciudad;
import co.edu.udea.iw.exception.ClaseExceptionDao;

/**
 * Define la funcionalidad que proveera el DAO de Ciudades
 * @author federico.ocampoo
 *
 */
public interface CiudadDao {
	
	
	/**
	 * Entrega la lista de ciudades que tiene el sistema
	 * ordenadas por nombre
	 * @return Lista de ciudades
	 * @throws ClaseExceptionDao cuando hay un error consultado la BD
	 */
	public List<Ciudad> obtener() throws ClaseExceptionDao;

	Ciudad obtenerCiudad(Integer codigo) throws ClaseExceptionDao;

	public void guardar(Ciudad ciudad) throws ClaseExceptionDao;
	
	

}
