package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Metodos que garantizan la logica del negocio en la interracción
 * con el cliente
 * @author estudiantelis
 *
 */

public interface ClienteBl {
	
	/**
	 * Crea un cliente en la base de datos
	 * @param cliente
	 * @throws MyDaoException, {@link NullPointerException} 
	 */
	public void crearCliente(String cedula, String nombres, String apellidos,
			String email, String usuarioCrea) throws MyDaoException;
	
	/**
	 * Entrega la lista de clientes del sistema
	 * 
	 * @return lista de clientes
	 * @throws MyDaoException
	 *             si hay un error accediendo los datos
	 */
	public List<Cliente> obtener() throws MyDaoException;

}
