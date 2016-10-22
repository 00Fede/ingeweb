package co.edu.udea.iw.dao.hibernate.test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.hibernate.CiudadDaoHibernate;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class CiudadDaoHibernateTest {
	
	@Autowired
	CiudadDao dao;

	@Test
	public void testObtener() {
		//CiudadDao ciudadDao = new CiudadDaoHibernate();
		
		List<Ciudad> ciudades;
		
		try{
			ciudades = dao.obtener();
			assertTrue(ciudades.size() > 0);
		}catch(MyDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerCiudad(){
		
		Ciudad ciudad = null;
		
		try {
			ciudad = dao.obtener(new Long(2));
			assertTrue(ciudad != null);

			
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar(){
		
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(new Long(53453));
		ciudad.setCodigoArea("6");
		ciudad.setNombre("Sabaneta");
		
		try {
			dao.guardar(ciudad);
			
			assertTrue(dao.obtener(ciudad.getCodigo())!=null);
			
			
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testModificar(){
		
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(new Long(2));
		ciudad.setCodigoArea("5");
		ciudad.setNombre("Sabaneta");
		
		try {
			dao.modificar(ciudad);
			Ciudad resultado =dao.obtener(ciudad.getCodigo());
			assertTrue(resultado.getCodigoArea()!=ciudad.getCodigoArea());
			
			
		} catch (MyDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	


}
