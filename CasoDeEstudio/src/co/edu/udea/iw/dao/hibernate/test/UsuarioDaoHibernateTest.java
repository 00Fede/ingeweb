package co.edu.udea.iw.dao.hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.UsuariosDao;
import co.edu.udea.iw.dto.Dispositivos;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:configuracion.xml"})
public class UsuarioDaoHibernateTest {
	@Autowired
	UsuariosDao dao;
	@Test
	public void testObtener() {
		List<Usuarios> usuarios;
		try{
			usuarios = dao.obtener();
			assertTrue(usuarios.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() {
		
		Usuarios usuarios;
		int cedula=8;
		
		try{
			usuarios=dao.obtener(cedula);
			assertTrue(usuarios != null);
			
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {
		
		List<Usuarios> usuarios;
		Usuarios user=new Usuarios();
		user.setCedula(9);
		user.setNombre("carlos");
		user.setApellido("guerra");
		user.setUsuario("cargue");
		user.setContrasena("gueguera");
		user.setRol("invest");
		
		try{
			usuarios = dao.obtener();
			int num_user=usuarios.size();
			dao.guardar(user);
			usuarios = dao.obtener();
			int num_user2=usuarios.size();
			assertTrue(num_user2>num_user);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}

	@Test
	public void testModificar() {
		assertTrue(true);
	}

	@Test
	public void testEliminar() {
		List<Usuarios> usuarios;
		
		try{
			
			usuarios = dao.obtener();
			int num_user=usuarios.size();
			dao.eliminar(104);
			usuarios = dao.obtener();
			int num_user2=usuarios.size();
			assertTrue(num_user2<num_user);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

}
