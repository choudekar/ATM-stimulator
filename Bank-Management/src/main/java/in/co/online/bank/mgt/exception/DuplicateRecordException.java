package in.co.online.bank.mgt.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 

 * 
 */
public class DuplicateRecordException  extends Exception
{
	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
