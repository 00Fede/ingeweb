package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

public class MyDaoException extends Exception {
	
	Logger log = Logger.getLogger(this.getClass());

	public MyDaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
		log.error(message);
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		
		// TODO Auto-generated constructor stub
		log.error(cause.getMessage());
	}
	
	

}
