package co.edu.udea.iw.dto;

import java.util.Date;

public class Sancion {

	
	private int Id_sancion;
	private Dispositivos Id_dispositivo;
	private Usuarios Id_cedula;
	private Date Fecha_inicio;
	private String Razon;
	private String Tiempo_sancion;
	
	public int getId_sancion() {
		return Id_sancion;
	}
	public void setId_sancion(int id_sancion) {
		Id_sancion = id_sancion;
	}
	public Dispositivos getId_dispositivo() {
		return Id_dispositivo;
	}
	public void setId_dispositivo(Dispositivos id_dispositivo) {
		Id_dispositivo = id_dispositivo;
	}
	public Usuarios getId_cedula() {
		return Id_cedula;
	}
	public void setId_cedula(Usuarios id_cedula) {
		Id_cedula = id_cedula;
	}
	public Date getFecha_inicio() {
		return Fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}
	public String getRazon() {
		return Razon;
	}
	public void setRazon(String razon) {
		Razon = razon;
	}
	public String getTiempo_sancion() {
		return Tiempo_sancion;
	}
	public void setTiempo_sancion(String tiempo_sancion) {
		Tiempo_sancion = tiempo_sancion;
	}
	
	
}
