package co.edu.udea.iw.dao.hibernate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.hibernate.CiudadDaoHibernate;
import co.edu.udea.iw.dao.hibernate.ClienteDaoHibernate;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;

public class ClienteDaoHibernateTest {

	@Test
	public void testObtener() {
		ClienteDao clienteDao= new ClienteDaoHibernate();
		
		List<Cliente> clientes;
		
		try{
			clientes = clienteDao.obtener();
			assertTrue(clientes.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar(){
		
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();
		usuario.setNombres("elver");
		
		cliente.setCedula("123456");
		cliente.setNombres("Federico");
		cliente.setApellidos("Ocampo Ortiz");
		cliente.setEmail("feedkiko@gmail.com");
		cliente.setFechaCreacion(new Date(java.lang.System.currentTimeMillis()));
		cliente.setUsuarioCreado(usuario);
		
		ClienteDao clienteDao = new ClienteDaoHibernate();
		
		try {
			clienteDao.guardar(cliente);
			
			assertTrue(clienteDao.obtener("12345")!=null);
					
			
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		
		
		
	}
	


}
