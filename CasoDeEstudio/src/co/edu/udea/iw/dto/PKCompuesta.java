package co.edu.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class PKCompuesta implements Serializable {

	private int Id_dispositivo;
	private int Id_cedula;
	private Date Fecha_inicio;
	
	public int getId_dispositivo() {
		return Id_dispositivo;
	}
	public void setId_dispositivo(int id_dispositivo) {
		Id_dispositivo = id_dispositivo;
	}
	public int getId_cedula() {
		return Id_cedula;
	}
	public void setId_cedula(int id_cedula) {
		Id_cedula = id_cedula;
	}
	public Date getFecha_inicio() {
		return Fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}
	
	
}
