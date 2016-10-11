package co.edu.udea.iw.bl.imp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.exception.MyDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class UsuarioBlImpTest {
	
	@Autowired
	UsuarioBl usuarioBl;

	@Test
	public void testLogin() {
		String login = "elver";
		String pass = "elver";
		
		try {
			assertTrue(usuarioBl.login(login,pass));
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
