package facade.exception;

/**
 * 
 * @author lucadebeir
 *
 */

public class DisconnectedUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisconnectedUserException() {
		super("No user connected !");
	}
	
}
