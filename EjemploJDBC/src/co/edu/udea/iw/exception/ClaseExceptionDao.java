package co.edu.udea.iw.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ClaseExceptionDao extends Exception {
	
	
	public ClaseExceptionDao(String e) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}
	
	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	
	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}
	
	@Override
	public synchronized Throwable initCause(Throwable cause) {
		// TODO Auto-generated method stub
		return super.initCause(cause);
	}
	public ClaseExceptionDao() {
		// TODO Auto-generated constructor stub
	}

	public ClaseExceptionDao(SQLException e) {
		// TODO Auto-generated constructor stub
	}
	
	
}
