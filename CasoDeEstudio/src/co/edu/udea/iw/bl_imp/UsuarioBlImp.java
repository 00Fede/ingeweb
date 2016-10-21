package co.edu.udea.iw.bl_imp;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import co.edu.udea.iw.business_logic.UsuarioBl;
import co.edu.udea.iw.dao.UsuariosDao;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * @see UsuarioBlImp 
 * @author Federico
 *
 */
public class UsuarioBlImp implements UsuarioBl{
	
	UsuariosDao userDao;

	/**
	 * Constructor de implementación
	 * @param userDao
	 */
	public UsuarioBlImp(UsuariosDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registrarAdministrador(int cedulaResponsable, int cedula, String nombre, String apellido, 
			String correo, String nombreUsuario, String contrasena, byte[] fotoRAW, String telefono, String direccion) throws MyDaoException, SerialException, SQLException {
		Usuarios userResponsable = userDao.obtener(cedulaResponsable);
		if(userResponsable.getEstado().equals("inactivo")){
			throw new MyDaoException("No se encuentra activo para hacer esta transacción",null);
		}
		if(!userResponsable.getRol().equals("superusuario")){
			throw new MyDaoException("No tiene permisos para hacer esta transaccion",null);
		}
		if(cedula == 0){
			throw new MyDaoException("Debe especificar cedula.",null);
		}
		if(nombreUsuario == null || "".equals(nombreUsuario)){
			throw new MyDaoException("Debe especificar nombre de usuario",null);
		}
		if(contrasena == null || "".equals(contrasena)){
			throw new MyDaoException("Debe especificar contraseña",null);
		}
		if(correo == null || "".equals(correo)){
			throw new MyDaoException("Debe especificar correo electronico",null);
		}
		if(telefono == null || "".equals(telefono)){
			throw new MyDaoException("Debe especificar telefono",null);
		}
		if(direccion == null || "".equals(direccion)){
			throw new MyDaoException("Debe especificar direccion",null);
		}
		if(!Validaciones.isEmail(correo)){
			throw new MyDaoException("El correo electronico no es valido",null);
		}
		if(contrasena.length()<6){
			throw new MyDaoException("La contraseña debe contener almenos 6 caracteres",null);
		}
		if(userDao.obtener(cedula)!=null){
			throw new MyDaoException("El usuario ya existe.",null);
		}
		
		//verificar que el usuario no existe
		List<Usuarios> users = userDao.obtener();
		Iterator<Usuarios> i = users.iterator();
		while(i.hasNext()){
			if(i.next().getUsuario().equals(nombreUsuario)){
				throw new MyDaoException("El nombre de usuario ya existe",null);
			}
		}
		i = users.iterator(); //reset iterator
		
		while(i.hasNext()){
			if(i.next().getEmail().equals(correo)){
				throw new MyDaoException("El correo electronico ingresado ya existe",null);
			}
		}
		
		Usuarios user = new Usuarios();
		user.setCedula(cedula);
		user.setNombre(nombre);
		user.setContrasena(contrasena);
		user.setUsuario(nombreUsuario);
		user.setApellido(apellido);
		user.setDireccion(direccion);
		user.setEstado("activo");
		user.setRol("Administrador");
		user.setTelefono(telefono);
		user.setFoto(new SerialBlob(fotoRAW));
		user.setEmail(correo);
		
		userDao.guardar(user);
		
		
	}

	@Override
	public boolean eliminarAdministrador(int idUsuario, String justificacion) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarInformacion(int idUsuario, String Nuevacontrasena, String NuevoCorreo, byte[] NuevafotoRAW,
			String NuevoTelefono, String nuevaDireccion) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean darseDeBajaLogicamenteInvestigador(int idUsuario) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarInvestigador(int idUsuario, String justificacion) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuarios> listarInvestigadores() throws MyDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String nombreUsuario, String contrasena) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cerrarSesion() throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuarios obtenerUsuarioConectado() throws MyDaoException {
		// TODO Auto-generated method stub
		return null;
	}


}
