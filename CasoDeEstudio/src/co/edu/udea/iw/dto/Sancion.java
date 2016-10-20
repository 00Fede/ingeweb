package co.edu.udea.iw.dto;

public class Sancion {

	private PKCompuesta Id;
	private String Razon;
	private String Tiempo_sancion;
	public PKCompuesta getId() {
		return Id;
	}
	public void setId(PKCompuesta id) {
		Id = id;
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
