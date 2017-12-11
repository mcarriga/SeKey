package framework;

import interfaces.IAAALogEvent;
import interfaces.ILogging;

public class AssertSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	public AssertSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	@Override
	public void doLog() {
		logger.info("\n"+"*** ASSERT Section *** "+message);
	}
}