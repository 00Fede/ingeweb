package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

public class UsuarioDaoHibernateTest {

	@Test
	public void testObtener() {
		UsuarioDao usuarioDao = new UsuarioDaoHibernate();
		
		List<Usuario> resultado = null;
		
		try {
			resultado = usuarioDao.obtener();
			assertTrue(resultado.size() > 0);
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
