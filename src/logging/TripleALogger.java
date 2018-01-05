package logging;

import interfaces.ILogging;

/**
 * Base Class for Triple AAA Log Events
 * @author Mathew Carrigan
 *
 */
public class TripleALogger {
	
	@SuppressWarnings("unused")
	private final ILogging logger;
	
	public TripleALogger(ILogging logger) {
		this.logger = logger;
	}
	
	
}
