package co.edu.udea.iw.bl_imp;

import java.util.Date;

import co.edu.udea.iw.business_logic.SancionBl;
import co.edu.udea.iw.dao.ReservaDao;
import co.edu.udea.iw.dao.SancionDao;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.MyDaoException;

public class SancionBlImp implements SancionBl {

	
	SancionDao sancionDao;
	
	/**
	 * Constructor de la implementacion. Necesario para inyeccion Spring
	 * @param reservaDao
	 */
	public  SancionBlImp(SancionDao sancionDao) {
		this.sancionDao = sancionDao;
		
	}
	@Override
	public void generarSancion_limiteTiempo(int id_reserva, Date fecha) throws MyDaoException {
		
		if(id_reserva == 0){
			throw new MyDaoException("debe especificar un identificador", null);
		}
		if(fecha == null){
			throw new MyDaoException("Debe especificar la fecha", null);
		}
		
		
		
	}

	@Override
	public void generarSancion_estadoNoAdecuado(int id_reserva, String estado) throws MyDaoException {
		

	}

	@Override
	public void generarSancion_incumplimientoReserva(int id_reserva, Date fecha) throws MyDaoException {
		

	}

	@Override
	public void generarSancion_cancelacionInoportuna(int id_reserva, Date fecha) throws MyDaoException {
		

	}

	@Override
	public void generarSancion_extravio(int id_reserva, Date fecha) throws MyDaoException {
		

	}

	@Override
	public void modificarSancion(int id_sancion, int id_resp, int razon) throws MyDaoException {
		

	}

	@Override
	public void retirarSancion(int id_sancion, String razon, int id_administrador) throws MyDaoException {
		

	}

}
