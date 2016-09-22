package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Metodos para acceder a la table roles de la base de dato
 * @author federico.ocampoo
 *
 */

public interface RolDao {
	
	
	/**
	 * Obtiene todos los roles
	 * @return
	 * @throws MyDaoException
	 */
	public List<Rol> obtener() throws MyDaoException;
	
	

}
