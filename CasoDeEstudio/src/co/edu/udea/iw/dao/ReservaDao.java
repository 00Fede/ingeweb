package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.PKCompuesta;
import co.edu.udea.iw.dto.Reserva;
import co.edu.udea.iw.exception.MyDaoException;

public interface ReservaDao {
	
	public List<Reserva> obtener() throws MyDaoException;
	
	public Reserva obtener(PKCompuesta id) throws MyDaoException;
	
	public void guardar(Reserva reserva) throws MyDaoException;
	
	public void eliminar(PKCompuesta id) throws MyDaoException;
	
	public void modificar(Reserva reserva) throws MyDaoException;

}
