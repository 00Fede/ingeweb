package co.edu.udea.iw.bl_imp;

import java.util.Date;

import co.edu.udea.iw.business_logic.ReservaBl;
import co.edu.udea.iw.dao.ReservaDao;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.exception.MyDaoException;

/*
 * see ReservaBl
 * @author Andres Montoya
 */
public class ReservaBlImp implements ReservaBl {

	ReservaDao reservaDao;
	
	/**
	 * Constructor de la implementacion. Necesario para inyeccion Spring
	 * @param reservaDao
	 */
	public  ReservaBlImp(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
		
	}
	
	@Override
	public void cancelarReserva(int id,Date date) throws MyDaoException {
		
		Reserva reserva=new Reserva();
		reserva=reservaDao.obtener(id);
		
		Date dateReserva=reserva.getFecha_inicio();
		int init_time=dateReserva.getHours();
		int now_time=date.getHours();
		String tiempo=reserva.getTiempo_reserva();
		
		//if(now_time>init_time+tiempo){
			//Usuario ha sobrepasado el limite de horas no puede cancelar
		//}
		
		

	}

	@Override
	public void modificarReserva(int id, String Tiempo, String id_disp, Date fecha) throws MyDaoException {
		

	}

}
