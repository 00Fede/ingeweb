package co.edu.udea.iw.bl.imp;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.security.Cifrar;
/**
 * Implementacion de la interfaz UsuarioBl
 * @author root
 *
 */
public class UsuarioBlImp implements UsuarioBl {
	
	private UsuarioDao usuarioDao;

	@Override
	public boolean login(String userName, String password) throws MyDaoException {
	
		boolean resultado = false;
		
		try {
			Usuario user = usuarioDao.obtener(userName);
			if (user!=null) {
				Cifrar c = new Cifrar();
				String encryptedPass = c.encrypt(password);
				System.out.println("Pass login: "+encryptedPass);
				System.out.println("Pass bd: " + user.getContrasena());			
				if(user.getContrasena().equals(encryptedPass)){
					resultado = true;
					return resultado;
				}
			}
			
		} catch (MyDaoException e) {
			e.printStackTrace();
		}
		return resultado;
				
		
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
