package co.edu.udea.dto;

/**
 * 
 * clase para el transporte de datos de las ciudades
 * @author federico.ocampoo
 *
 */

public class Ciudad {
	
	private Integer codigo;
	private String nombre;
	private String codigoArea;
	
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
	

}
