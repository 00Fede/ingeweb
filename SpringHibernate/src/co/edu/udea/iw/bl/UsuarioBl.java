package co.edu.udea.iw.bl;

import co.edu.udea.iw.exception.MyDaoException;
/**
 * Esta clase contiene las funcionalidades propias
 * de la logica del negocio del sistema
 * @author federico
 *
 */
public interface UsuarioBl {
	
	
	/**
	 * Valida que el usuario y la contraseña coinciden con las ingresadas
	 * en la base de datos
	 * @param userName
	 * @param password
	 * @return true si el login es exitoso, false de lo contrario.
	 * @throws MyDaoException
	 */
	public boolean login(String userName, String password) throws MyDaoException;

}
