package co.edu.udea.iw.dto;

public class Direccion {
	
	private DireccionId direccionId;
	private String direccion;
	private String telefono;
	private Ciudad ciudad;
	private boolean preferida;
	
	
	public DireccionId getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(DireccionId direccionId) {
		this.direccionId = direccionId;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isPreferida() {
		return preferida;
	}
	public void setPreferida(boolean preferida) {
		this.preferida = preferida;
	}
	
	

}
