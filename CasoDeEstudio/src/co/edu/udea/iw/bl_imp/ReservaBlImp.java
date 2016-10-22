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
	public void cancelarReserva(int id) throws MyDaoException {
		

		if(id == 0){
			throw new MyDaoException("El identificador ingresado no es valido", null);
		}
		
		Reserva reserva=new Reserva();
		reserva=reservaDao.obtener(id);
		
		if(reserva == null){
			throw new MyDaoException("La reserva no se ha encontrado", null);
		}
		//Para que el usuario pueda cancelar una reserva inicialmente
		//aun debera ser reserva por ende estado será 0
		
		if(reserva.getEstado() != 0){ //aun es reserva
			
			throw new MyDaoException("Esta entidad no tiene estado de reserva", null);
		}
		//es diferente de reserva, es decir o ya esta en prestemo activo o inactivo o en cancelado
		
		if(reserva.getEstado() == 0){
			// Se elimina la reserva con el id entrado
			reservaDao.eliminar(id);
		}

	}

	@Override
	public void modificarReserva(int id, int Tiempo, int id_disp) throws MyDaoException {
		if(id == 0){
			throw new MyDaoException("El identificador ingresado no es valido", null);
		}
		
		if(Tiempo == 0){
			throw new MyDaoException("Debe especfiicar el tiempo de sancion", null);
		}
		
		if(id_disp == 0){
			throw new MyDaoException("El identificador ingresado no es valido", null);
		}
		
		Reserva reserva;
		reserva=reservaDao.obtener(id);
		reserva.setTiempo_reserva(Tiempo);
		
	}

}
