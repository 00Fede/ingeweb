package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Define los metodos para acceder a la informacion
 * de la tabla clientes en la base de datos
 * @author federico.ocampoo
 *
 */

public interface ClienteDao {
	
	
	/**
	 * Obtiene todos los clientes
	 * @return Lista con los clientes guardados
	 * @throws MyDaoException
	 */
	public List<Cliente> obtener() throws MyDaoException;
	
	/**
	 * Obtiene un cliente dada la cedula
	 * @param cedula del cliente
	 * @return Cliente obtenido
	 * @throws MyDaoException
	 */
	public Cliente obtener(String cedula) throws MyDaoException;
	
	/**
	 * Guarda un cliente en la base de datos
	 * @param cliente: cliente que va a ser ingresado
	 * @throws MyDaoException
	 */
	public void guardar(Cliente cliente) throws MyDaoException;
	
	/**
	 * elimina un cliente que tenga la cedula enviada
	 * @param cedula: cedula del cliente a eliminar
	 * @throws MyDaoException
	 */
	public void eliminar(String cedula) throws MyDaoException;
	
	/**
	 * Modificar un cliente dado
	 * @param cliente
	 * @throws MyDaoException
	 */
	public void modificar(Cliente cliente) throws MyDaoException;

}
