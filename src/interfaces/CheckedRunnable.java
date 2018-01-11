package interfaces;

/**
 * Interface for being able to check if a Runnable object throws an exception
 * @author Mathew Carrigan
 *
 */
@FunctionalInterface
public interface CheckedRunnable {
	
	/**
	 * perform the Runnable run command
	 * @throws Exception Can throw any type of Exception as this runs any generic Runnable
	 */
	void run() throws Exception;
}
