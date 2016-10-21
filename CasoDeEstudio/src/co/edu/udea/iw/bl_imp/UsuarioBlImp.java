package co.edu.udea.iw.bl_imp;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.mysql.jdbc.UpdatableResultSet;

import co.edu.udea.iw.business_logic.UsuarioBl;
import co.edu.udea.iw.dao.ReservaDao;
import co.edu.udea.iw.dao.SancionDao;
import co.edu.udea.iw.dao.UsuariosDao;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * @see UsuarioBlImp
 * @author Federico
 *
 */
public class UsuarioBlImp implements UsuarioBl {

	

	UsuariosDao userDao;
	ReservaDao reservaDao;
	SancionDao sancionDao;

	/**
	 * constructor para la inyeccion
	 * @param userDao
	 * @param reservaDao
	 * @param sancionDao
	 */
	public UsuarioBlImp(UsuariosDao userDao, ReservaDao reservaDao, SancionDao sancionDao) {
		this.userDao = userDao;
		this.reservaDao = reservaDao;
		this.sancionDao = sancionDao;
	}

	@Override
	public void registrarAdministrador(int cedulaResponsable, int cedula, String nombre, String apellido, String correo,
			String nombreUsuario, String contrasena, byte[] fotoRAW, String telefono, String direccion)
			throws MyDaoException, SerialException, SQLException {
		if (!isActiveUser(cedulaResponsable)) {
			throw new MyDaoException("No se encuentra activo para hacer esta transacción", null);
		}
		if (!matchRol(cedulaResponsable, "superusuario")) {
			throw new MyDaoException("No tiene permisos para hacer esta transaccion", null);
		}
		if (cedula == 0) {
			throw new MyDaoException("Debe especificar cedula.", null);
		}
		if (nombreUsuario == null || "".equals(nombreUsuario.trim())) {
			throw new MyDaoException("Debe especificar nombre de usuario", null);
		}
		if (contrasena == null || "".equals(contrasena.trim())) {
			throw new MyDaoException("Debe especificar contraseña", null);
		}
		if (correo == null || "".equals(correo.trim())) {
			throw new MyDaoException("Debe especificar correo electronico", null);
		}
		if (telefono == null || "".equals(telefono.trim())) {
			throw new MyDaoException("Debe especificar telefono", null);
		}
		if (direccion == null || "".equals(direccion.trim())) {
			throw new MyDaoException("Debe especificar direccion", null);
		}
		if (!Validaciones.isEmail(correo)) {
			throw new MyDaoException("El correo electronico no es valido", null);
		}
		if (contrasena.length() < 6) {
			throw new MyDaoException("La contraseña debe contener almenos 6 caracteres", null);
		}
		if (userDao.obtener(cedula) != null) {
			throw new MyDaoException("El usuario ya existe.", null);
		}

		List<Usuarios> users = userDao.obtener();
		Iterator<Usuarios> i = users.iterator();
		while (i.hasNext()) {
			if (i.next().getUsuario().equals(nombreUsuario)) {
				throw new MyDaoException("El nombre de usuario ya existe", null);
			}
		}
		if (existeEmail(correo)) {
			throw new MyDaoException("El correo electronico ingresado ya existe", null);
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
	public void eliminarAdministrador(int idResponsable, int idUsuario, String justificacion) throws MyDaoException {
		Usuarios userResponsable = userDao.obtener(idResponsable);
		if (!isActiveUser(idResponsable)) {
			throw new MyDaoException("No se encuentra activo para hacer esta transacción", null);
		}
		if(!matchRol(idResponsable,"superusuario")){
			throw new MyDaoException("No tiene permisos para hacer esta transaccion", null);
		}
		if (!userResponsable.getRol().equals("superusuario")) {
			throw new MyDaoException("No tiene permisos para hacer esta transaccion", null);
		}

		if (userDao.obtener(idUsuario).getRol() != "administrador") {
			throw new MyDaoException("El usuario a eliminar no es administrador", null);
		}
		if (justificacion.equals(null) || "".equals(justificacion.trim())) {
			throw new MyDaoException("Debe ingresar una justificacion", null);
		}
		Usuarios olduser = userDao.obtener(idUsuario);
		olduser.setEstado("inactivo"); // eliminado logico
		userDao.modificar(olduser);
	}

	private boolean matchRol(int idResponsable, String rol) throws MyDaoException {
		Usuarios userResponsable = userDao.obtener(idResponsable);
		if (userResponsable.getRol().equals(rol)) {
			return true;
		}
		return false;
	}

	@Override
	public void actualizarInformacion(int idResponsable, int idUsuario, String nuevaContrasena, String nuevoCorreo,
			byte[] nuevaFotoRAW, String nuevoTelefono, String nuevaDireccion) throws MyDaoException {
		if (!isActiveUser(idResponsable)) {
			throw new MyDaoException("No se encuentra activo para hacer esta transacción", null);
		}
		if (idResponsable != idUsuario) {
			throw new MyDaoException("No puede modificar la información de otro usuario", null);
		}
		if (!Validaciones.isEmail(nuevoCorreo)) {
			throw new MyDaoException("El correo electronico no es valido", null);
		}
		if (existeEmail(nuevoCorreo)) {
			throw new MyDaoException("El correo electronico ingresado ya existe", null);
		}
		Usuarios updatedUser = new Usuarios();
		updatedUser.setCedula(idUsuario);
		if (!"".equals(nuevaContrasena.trim()) || nuevaContrasena != null) {
			updatedUser.setContrasena(nuevaContrasena);
		}
		if (!"".equals(nuevoCorreo.trim()) || nuevoCorreo != null) {
			updatedUser.setEmail(nuevoCorreo);
		}
		if (!"".equals(nuevoTelefono.trim()) || nuevoTelefono != null) {
			updatedUser.setTelefono(nuevoTelefono);
		}
		if (!"".equals(nuevaDireccion.trim()) || nuevaDireccion != null) {
			updatedUser.setDireccion(nuevaDireccion);
		}
		if (nuevaContrasena.length() <= 6) {
			updatedUser.setContrasena(nuevaContrasena);
		}

		userDao.modificar(updatedUser);

	}

	private boolean existeEmail(String email) throws MyDaoException {
		List<Usuarios> users = userDao.obtener();
		Iterator<Usuarios> i = users.iterator();
		while (i.hasNext()) {
			if (i.next().getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isActiveUser(int id) throws MyDaoException{
		Usuarios userResponsable = userDao.obtener(id);
		if (userResponsable.getEstado().equals("inactivo")) {
			return false;
		}
		return true;
	}
	
	private boolean hasActiveReserves(int id) throws MyDaoException{
		List<Reserva> r = reservaDao.obtener();
		Iterator<Reserva> i = r.iterator();
		while(i.hasNext()){
			if(i.next().getId_cedula().getCedula()==id){
				return true;
			}
		}
		return false;
	}
	
	private boolean hasActiveSanctions(int id) throws MyDaoException{
		List<Sancion> s = sancionDao.obtener();
		Iterator<Sancion> i = s.iterator();
		while(i.hasNext()){
			if(i.next().getId_cedula().getCedula()==id){
				return true;
			}
		}
		return false;
	}
 
	@Override
	public void darseDeBajaLogicamenteInvestigador(int idUsuario) throws MyDaoException {
		if(!isActiveUser(idUsuario)){
			throw new MyDaoException("No se encuentra activo para hacer esta transacción", null);
		}
		if(!matchRol(idUsuario,"investigador")){
			throw new MyDaoException("No tiene permisos para hacer esta transaccion", null);
		}
		if(hasActiveReserves(idUsuario)){
			throw new MyDaoException("El usuario tiene reservas activas", null);
		}
		if(hasActiveSanctions(idUsuario)){
			throw new MyDaoException("El usuario tiene sanciones activas", null);
		}
		
		Usuarios delInv = userDao.obtener(idUsuario);
		delInv.setEstado("inactivo");
		userDao.modificar(delInv);
		
	}

	@Override
	public void eliminarInvestigador(int idResponsable, int idUsuario, String justificacion) throws MyDaoException {
		if(!isActiveUser(idUsuario)){
			throw new MyDaoException("El usuario ya fue eliminado", null);
		}
		if(!isActiveUser(idResponsable)){
			throw new MyDaoException("No se encuentra activo para hacer esta transacción", null);
		}
		if(!matchRol(idResponsable,"administrador")){
			throw new MyDaoException("No tiene permisos para hacer esta transaccion", null);
		}
		if(!matchRol(idUsuario,"investigador")){
			throw new MyDaoException("No puede eliminar este tipo de usuario", null);
		}
		if(hasActiveReserves(idUsuario)){
			throw new MyDaoException("El usuario tiene reservas activas", null);
		}
		if(hasActiveSanctions(idUsuario)){
			throw new MyDaoException("El usuario tiene sanciones activas", null);
		}
		if (justificacion.equals(null) || "".equals(justificacion.trim())) {
			throw new MyDaoException("Debe ingresar una justificacion", null);
		}
		
		Usuarios delInv = userDao.obtener(idUsuario);
		delInv.setEstado("inactivo");
		userDao.modificar(delInv);
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
