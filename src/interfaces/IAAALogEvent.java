package interfaces;

/**
 * Model for log events for Triple AAA Logging pattern which includes Arrange, Act, Assert, and optionally Cleanup sections of a test case
 * Classes that implement this interface are designed to create log events for these 4 sections of a test case
 * @author Mathew Carrigan
 *
 */
public interface IAAALogEvent {
	
	/**
	 * Performs the log event and formats the log message according to the type of Triple AAA log like Arrange, Act, Assert and optionally Cleanup
	 */
	void doLog();
}
