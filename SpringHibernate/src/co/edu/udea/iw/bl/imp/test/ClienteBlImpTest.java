package co.edu.udea.iw.bl.imp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_config.xml"})
public class ClienteBlImpTest {
	
	//Autowired asocia el clienteBl con el que esta declarado en el archivo de configuracion
	@Autowired
	ClienteBl clienteBl;
	
	@Test
	public void testCrearCliente() {
		try {
			String cedula = "123456";
			String nombres = "federico";
			String apellidos = "ocampo";
			String email = "federico@federico.com";
			String usuarioCreado = "elvr";
			
			clienteBl.crearCliente(cedula, nombres, apellidos, email, usuarioCreado);
		} catch (MyDaoException | NullPointerException e) {
			fail(e.getMessage());
		}
		
	}

}
