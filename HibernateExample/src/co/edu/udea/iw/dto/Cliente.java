package co.edu.udea.iw.dto;

import java.util.Date;

public class Cliente {
	
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private Usuario usuarioCreado;
	private Date fechaCreacion;
	private Usuario usuarioModificado;
	private Date fechaModificacion;
	private boolean eliminado;
	private Usuario usuarioEliminado;
	private Date fechaEliminacion;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario getUsuarioCreado() {
		return usuarioCreado;
	}
	public void setUsuarioCreado(Usuario usuarioCreado) {
		this.usuarioCreado = usuarioCreado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Usuario getUsuarioModificado() {
		return usuarioModificado;
	}
	public void setUsuarioModificado(Usuario usuarioModificado) {
		this.usuarioModificado = usuarioModificado;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public Usuario getUsuarioEliminado() {
		return usuarioEliminado;
	}
	public void setUsuarioEliminado(Usuario usuarioEliminado) {
		this.usuarioEliminado = usuarioEliminado;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

}
