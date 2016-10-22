package co.edu.udea.iw.business_logic;

import java.util.Date;

import co.edu.udea.iw.exception.MyDaoException;

/*
 * En esta clase se presentan los metodos pertinentes para la capa
 * de negocio de nuestra entidad Reserva
 * Para esta entidad usaremos una notacion para el campo
 * estado, será la siguiente
 * estado = 0--->estado de reserva
 * estado = 1--->prestamos activo
 * estado = 2--->prestamo terminado
 * estado = 3--->reserva cancelada.
 */
public interface ReservaBl {
	
	
	/**
	 * Este metodo permitirá cancelar una reserva brindandole
	 * un identificar unico.
	 * @param id
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void cancelarReserva(int id,Date fecha) throws MyDaoException;
	
	
	/**
	 * Este metodo permite al usuario modificar una
	 * reserva, usuario podrá moficar los campos de 
	 * dispositivo, fecha de inicio y tiempo de reserva
	 * @param id
	 * @param Tiempo
	 * @param id_disp
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void modificarReserva(int id,String Tiempo,String id_disp,Date fecha) throws MyDaoException;
	
}
