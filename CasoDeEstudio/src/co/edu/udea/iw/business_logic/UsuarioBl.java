package co.edu.udea.iw.business_logic;

import java.util.List;

import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * Metodo que garantiza la logica del negocio en
 * la interaccion con el usuario
 * 
 * @author estudiantelis
 *
 */


public interface UsuarioBl {

	
	/**
	 * FRQ-006- Registro de Administrador
	 * 
	 * @param cedulaResponsable cedula de quien va a registrar administrador Obligatorio, obtenido por el sistema
	 * @param cedula Obligatorio
	 * @param nombreUsuario Obligatorio
	 * @param contrasena Obligatorio
	 * @param correo Obligatorio
	 * @param fotoRAW 
	 * @param telefono Obligatorio
	 * @param direccion Obligatorio
	 * @throws MyDaoException
	 */	
	public boolean registrarAdministrador(int cedulaResponsable, int cedula, String nombreUsuario, String contrasena, String nombre, 
			byte[] fotoRAW, String telefono, String direccion) throws MyDaoException;
	
	/**
	 * FRQ-007- Eliminar  Administrador
	 * 
	 * @param idUsuario
	 * @param justificacion
	 * @throws MyDaoException
	 */	
	public boolean eliminarAdministrador(int idUsuario, String justificacion) throws MyDaoException;
	
	/**
	 * FRQ-015- Actualizaci��n de Informaci��n de usuario
	 * 
	 * @param idUsuario
	 * @param nuevacontrasena
	 * @param nuevoCorreo
	 * @param nuevaFotoRAW
	 * @param nuevoTelefono
	 * @param nuevaDireccion
	 * @throws MyDaoException
	 */	
	public boolean actualizarInformacion(int idUsuario, String Nuevacontrasena, String NuevoCorreo, byte[] NuevafotoRAW, String NuevoTelefono, String nuevaDireccion) throws MyDaoException;
	
	/**
	 * FRQ-007- Darse de baja logicamente * 
	 * @param idUsuario
	 * @throws MyDaoException	
	 */	
	public boolean darseDeBajaLogicamenteInvestigador(int idUsuario) throws MyDaoException;
		
	/**
	 * FRQ-024- Eliminar investigador * 
	 * @param idUsuario
	 * @param justificacion
	 * @throws MyDaoException	
	 */	
	public boolean eliminarInvestigador(int idUsuario, String justificacion) throws MyDaoException;
	
	/**
	 * FRQ-026- Listar investigadores
	 * @param idUsuario
	 * @return list<Usuarios>
	 * @throws MyDaoException	
	 */	
	public List<Usuarios> listarInvestigadores() throws MyDaoException;
	
	/**
	 * FRQ-0027- Iniciar sesi��n
	 * @param nombreUsuario
	 * @param contrasena
	 * @return  true si el login es exitoso, false de lo contrario.
	 * @throws MyDaoException	
	 */	
	public boolean login(String nombreUsuario, String contrasena) throws MyDaoException;
	
	/**
	 * FRQ-028- Cerrar sesi��n
	 * @param nombreUsuario
	 * @param contrasena
	 * @return  true si se cierra sesion exitosamente, false de lo contrario.
	 * @throws MyDaoException	
	 */	
	public boolean cerrarSesion() throws MyDaoException;
	
	/**
	 * FRQ-0-032- Cerrar sesi��n
	 * @throws MyDaoException	
	 */		
	public Usuarios obtenerUsuarioConectado() throws MyDaoException;
 
}
