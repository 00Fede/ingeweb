package co.edu.udea.iw.dao.hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class UsuarioDaoHibernateTest {
	
	@Autowired
	UsuarioDao usuarioDao;

	@Test
	public void testObtener() {
		List<Usuario> usuarios;
		
		try {
			usuarios = usuarioDao.obtener();
			assertTrue(usuarios.size()>0);
			
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

	

}
