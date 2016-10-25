package co.udea.edu.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Clase que respondera a las peticiones web para la funcionalidad
 * saludar. Ejercicio de clase
 * @author Federico
 *
 */
@Path("saludo") //ruta padre por la que va a responder
public class ServicioSaludo {
	
	//Para convertir esta clase en un servicio o candidata a servicio
	//1. agregar anotaciones (Path, GET, produces)
	//2. Configurar archivo web.xml
	
	/**
	 * Metodo sencillo para el primer saludo
	 * @return Buenas Tardes
	 */
	@GET //tipo de consumo de servicio (cuando la direccion se ingresa manual/e, es tipo get
	@Produces("text/html") //Tipo de la respuesta
	public String saludar(){
		return "Buenas Tardes";
	}
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("holaNombre")
	public String digameHola(){
		return "hola";
	}
	
	//enviar params al servicio. tres formas
	//PathParam: Pasan como tipo path <path url>/<servicio>/<valor>
	//FormParam: parametros pasados a traves del html, params de la forma @FormParam(<id_html>)
	//QueryParam: Pasan como tipo query <path url>/<servicio>?<param>=<valor>
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola/{nombre}")
	public String digameHola(@PathParam("nombre")String nombre){
		return "hola " + nombre;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola")
	public String digameHolaQuery(@QueryParam("nombre")String nombre,
			@QueryParam("apellido")String apellido){
		return "hola " + nombre + " "+ apellido;
	}

}
