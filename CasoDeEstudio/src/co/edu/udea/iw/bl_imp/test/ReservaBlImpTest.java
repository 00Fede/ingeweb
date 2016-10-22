package co.edu.udea.iw.bl_imp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.business_logic.ReservaBl;
import co.edu.udea.iw.business_logic.UsuarioBl;
import co.edu.udea.iw.dao.UsuariosDao;
import co.edu.udea.iw.dto.Usuarios;
import co.edu.udea.iw.exception.MyDaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:configuracion.xml"})
public class ReservaBlImpTest {

	@Autowired
	ReservaBl reservaDao;
	
	@Test
	public void testCancelarReserva() throws MyDaoException {
		
		reservaDao.cancelarReserva(102);
		
	}

	@Test
	public void testModificarReserva() throws MyDaoException {
		int id=9988;
		int Tiempo=5;
		Usuarios user=new Usuarios();
		user.setCedula(777);
		reservaDao.modificarReserva(id, Tiempo, 777);
	}

}
