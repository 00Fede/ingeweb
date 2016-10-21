package co.edu.udea.iw.bl_imp;

import java.util.List;

import co.edu.udea.iw.business_logic.UsuarioBl;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioBlImp implements UsuarioBl{

	@Override
	public boolean registrarAdministrador(String nombreUsuario, String contrasena, String correo, byte[] fotoRAW,
			String telefono, String direccion) throws MyDaoException {
		// TODO Auto-generated method stub
		return false;
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
