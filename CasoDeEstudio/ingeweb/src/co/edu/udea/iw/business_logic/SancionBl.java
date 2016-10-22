package co.edu.udea.iw.business_logic;

import java.util.Date;

import co.edu.udea.iw.exception.MyDaoException;

/*
 * En esta clase se presentará la firma de todos los metodos
 * correspondientes a la logica del negocio de nuestra entidad sancion
 */

public interface SancionBl {

	
	/**
	 * Este metodo generará una sancion cuando el usuario sobrepase el 
	 * tiempo limite de prestamo
	 * @param id_reserva
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void generarSancion_limiteTiempo(int id_reserva,Date fecha) throws MyDaoException;

	/**
	 * Este metodo generará una sancion cuando el usuario 
	 * retorne el dispositivo en un estado inadecuado
	 * @param id_reserva
	 * @param estado
	 * @throws MyDaoException
	 */
	public void generarSancion_estadoNoAdecuado(int id_reserva,String estado) throws MyDaoException;
	
	/**
	 * Este metodo generará una sancion cuando el 
	 * usuario haya hecho una reserva y no haya cumplido
	 * con esta(reservo y no uso)
	 * @param id_reserva
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void generarSancion_incumplimientoReserva(int id_reserva,Date fecha) throws MyDaoException;
	
	/**
	 * Este metodo generará una sancion cuando
	 * el usaurio generá una cancelacion de una reserva
	 * en un tiempo muy cercado a la fecha de la reserva
	 * @param id_reserva
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void generarSancion_cancelacionInoportuna(int id_reserva,Date fecha) throws MyDaoException;
	
	/**
	 * Este metodo generará una sancion cuando
	 * el usuario haya extraviado un dispositivo
	 * prestado
	 * @param id_reserva
	 * @param fecha
	 * @throws MyDaoException
	 */
	public void generarSancion_extravio(int id_reserva,Date fecha) throws MyDaoException;
	
	
	/**
	 * Este metodo permitirá modificar el tiempo
	 * de la sancion debido a una razon que debe ser 
	 * especificada.
	 * @param id_sancion
	 * @param id_resp
	 * @param razon
	 * @throws MyDaoException
	 */
	public void modificarSancion(int id_sancion,int id_resp, int razon) throws MyDaoException;
	
	/**
	 * Este metodo permitirá remover las 
	 * sanciones previamentes creadas, ya sea por retorno
	 * de dispositivo extraviado, finalizacion de tiempo de sancion
	 * o pago de multa.
	 * @param id_sancion
	 * @param razon
	 * @param id_administrador
	 * @throws MyDaoException
	 */
	public void retirarSancion(int id_sancion,String razon,int id_administrador) throws MyDaoException;
}
