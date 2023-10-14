package in.co.online.bank.mgt.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 *

 *
 */

public class DatabaseException  extends Exception
{
	/**
    * @param msg
    *            : Error message
    */
   public DatabaseException(String msg) {
       super(msg);
   }
}

