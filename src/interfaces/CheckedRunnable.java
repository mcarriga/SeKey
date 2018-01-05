package interfaces;

/**
 * Inteface for being able to check if a Runnable object throws an exception
 * @author Mathew Carrigan
 *
 */
@FunctionalInterface
public interface CheckedRunnable {
	
	/**
	 * perform the Runnable run command
	 * @throws Exception
	 */
	void run() throws Exception;
}
