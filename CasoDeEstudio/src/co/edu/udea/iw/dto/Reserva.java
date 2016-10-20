package co.edu.udea.iw.dto;

public class Reserva {
	
	
	private PKCompuesta Id;
	private String Tiempo_reserva;
	
	public PKCompuesta getId() {
		return Id;
	}
	public void setId(PKCompuesta id) {
		Id = id;
	}
	public String getTiempo_reserva() {
		return Tiempo_reserva;
	}
	public void setTiempo_reserva(String tiempo_reserva) {
		Tiempo_reserva = tiempo_reserva;
	}
	
	
}
