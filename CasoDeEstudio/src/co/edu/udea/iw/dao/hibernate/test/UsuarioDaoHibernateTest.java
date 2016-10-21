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
import co.edu.udea.iw.dto.Reserva;
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
		int cedula=1010;
		
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
		
		Usuarios user=new Usuarios();
		user.setCedula(1016);
		user.setNombre("carlos");
		user.setApellido("guerra");
		user.setUsuario("cargue");
		user.setContrasena("gueguera");
		user.setRol("invest");
		
		try{
			dao.guardar(user);
			assertTrue(dao.obtener(user.getCedula())!=null);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}

	@Test
	public void testModificar() {
		java.util.Date fechaActual = new java.util.Date(); //Fecha actual del sistema
		Usuarios user=new Usuarios();
		user.setCedula(1012);
		user.setNombre("carlos");
		user.setApellido("guerra");
		user.setUsuario("cargu");
		user.setContrasena("gueguera");
		user.setRol("investaaa");
		try{
			dao.modificar(user);
			Usuarios resultados=dao.obtener(user.getCedula());
			assertTrue(resultados.getRol()!=user.getRol());
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminar() {
		
		try{
			dao.eliminar(1016);
			assertTrue(dao.obtener(1016)==null);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

}
