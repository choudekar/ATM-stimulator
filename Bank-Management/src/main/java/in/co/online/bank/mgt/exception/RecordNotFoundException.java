package in.co.online.bank.mgt.exception;
/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
public class RecordNotFoundException extends Exception
{
	/**
	 * @param msg
	 *            error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}
