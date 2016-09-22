package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los metodos para acceder a la tabla Usuarios
 * @author federico.ocampoo
 *
 */

public interface UsuarioDao {
	
	
	/**
	 * Obtiene todos los usuarios contenidos en la base de datos
	 * @return Lista con todos los usuarios
	 * @throws MyDaoException
	 */
	public List<Usuario> obtener() throws MyDaoException;

}
