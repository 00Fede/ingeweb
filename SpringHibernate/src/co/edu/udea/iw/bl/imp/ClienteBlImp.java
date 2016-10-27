package co.edu.udea.iw.bl.imp;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * @see ClienteBl
 * @author estudiantelis
 *
 */

public class ClienteBlImp implements ClienteBl {

	// Es inyectado con toda la configuraci��n de conexion a la bd
	ClienteDao clienteDao;
	UsuarioDao usuarioDao;
	
	public ClienteBlImp(ClienteDao clienteDao, UsuarioDao usuarioDao) {
		this.clienteDao = clienteDao;
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public void crearCliente(String cedula, String nombres, String apellidos,
			String email, String usuarioCrea) throws MyDaoException {
		
		if (cedula == null || "".equals(cedula.trim())){
			throw new MyDaoException("Debe especificar cedula",null);
		}
		if (nombres == null || "".equals(nombres.trim())){
			throw new MyDaoException("Debe especificar nombres",null);
		}
		if (apellidos == null || "".equals(apellidos.trim())){
			throw new MyDaoException("Debe especificar apellidos",null);
		}
		if (!Validaciones.isEmail(email)){
			throw new MyDaoException("El correo electronico no es valido",null);
		}
		if (usuarioCrea == null || "".equals(usuarioCrea.trim())){
			throw new MyDaoException("Debe especificar Usuario que crea cliente",null);
		}
		
		Usuario usuario = usuarioDao.obtener(usuarioCrea.toLowerCase());
		
		if(usuario == null){
			throw new MyDaoException("No existe el cliente que creo",null);
		}
		
		if(clienteDao.obtener(cedula)!=null){
			throw new MyDaoException("el Cliente ya existe",null);
		}
		
		//Debo validar que el cliente no exista
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		Usuario u = new Usuario();
		u.setContrasena(usuarioCrea);
		cliente.setUsuarioCreado(u);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(false);
	
		clienteDao.guardar(cliente);
		
	}
	
	@Override
	public List<Cliente> obtener() throws MyDaoException {
		return clienteDao.obtener();
	}

}
