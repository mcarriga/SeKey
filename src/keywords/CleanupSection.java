package keywords;

import interfaces.IAAALogEvent;
import interfaces.ILogging;

public class CleanupSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	public CleanupSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	@Override
	public void doLog() {
		logger.info("\n"+"*** CLEANUP Section *** "+message);
	}

}
