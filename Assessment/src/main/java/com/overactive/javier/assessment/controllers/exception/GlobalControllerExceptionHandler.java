package com.overactive.javier.assessment.controllers.exception;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * A convenient base class for @ControllerAdvice classes that wish to provide
 * centralized exception handling across all @RequestMapping methods
 * through @ExceptionHandler methods. <br>
 * <br>
 * This base class provides an @ExceptionHandler method for Spring MVC's
 * internal exception handling. This method returns a ResponseEntity to write to
 * the response with a message converter. <br>
 * 
 * @author Javier Agredo
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Method that catches exceptions caused by data integrity violation.<br>
	 * Stores the exception in a map and returns it in the request response
	 * 
	 * @param exception
	 * @return the arrangement with the exception
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleConflict(Exception exception) {

		String constraint = "key_unique";
		if (exception instanceof DataIntegrityViolationException) {
			DataIntegrityViolationException d = (DataIntegrityViolationException) exception;
			int ini = d.getMostSpecificCause().getLocalizedMessage().indexOf('«');
			int fin = d.getMostSpecificCause().getLocalizedMessage().indexOf('»');
			if (ini > 0) {
				constraint = d.getMostSpecificCause().getLocalizedMessage().substring(ini + 1, fin);
			}
		}

		Map<String, String> map = new HashMap<>();
		map.put(constraint.toUpperCase(), "DATA_INTEGRITY_VIOLATION");
		return new ResponseEntity<>(map, HttpStatus.CONFLICT);
	}

	/**
	 * Method that catches connection exceptions. <br>
	 * <br>
	 * N1: It is created to handle exceptions caused when it is not possible to
	 * connect to an IP address.
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Object> connectionException(Exception exception) {
		String constraint = "connectionException";
		Map<String, String> map = new HashMap<>();
		map.put(constraint, "Connection timed out: connect");
		return new ResponseEntity<>(map, HttpStatus.GATEWAY_TIMEOUT);
	}

	@ExceptionHandler(ClassCastException.class)
	public ResponseEntity<Object> classCastException(Exception exception) {
		String constraint = "castException";
		Map<String, String> map = new HashMap<>();
		map.put(constraint, "Bad request");
		return new ResponseEntity<>(map, HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Method that captures the errors when an object is validated with @Valid and
	 * returns in a Map the fields that failed and their respective description of
	 * the error
	 * 
	 * @param ex
	 * @return Map{fieldName, errorDescription}
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.getBindingResult().getAllErrors();
		Map<String, String> map = new HashMap<>();
		ResponseEntity<Object> re;
		FieldError tester = null;
		for (ObjectError o : ex.getBindingResult().getAllErrors()) {
			ex.getBindingResult().getAllErrors().size();

			if (o instanceof FieldError) {
				tester = (FieldError) o;
				map.put(tester.getField().replace(".", "_"), tester.getDefaultMessage());
			}
		}
		re = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		return re;
	}

	@ExceptionHandler(DataAccessResourceFailureException.class)
	public ResponseEntity<Object> dbException(DataAccessResourceFailureException exception) {
		String msg = "Internal error.";
		if (exception instanceof DataAccessResourceFailureException) {
			msg = "DB_CONECTION_FAILED";
		}
		Map<String, String> map = new HashMap<>();
		map.put("error", msg);
		return new ResponseEntity<>(map, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
