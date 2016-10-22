package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPrueba
 */
//@WebServlet(description = "Servlet para pruebas", urlPatterns = { "/ServletPrueba" })
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Hello Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		
		out.append("<h1>Hola</h1> <br>");
		out.append(nombre);
		
//		out.close();
		
		response.sendRedirect("../pages/Prueba.jsp");

	}

}
