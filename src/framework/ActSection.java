package framework;

import interfaces.IAAALogEvent;
import interfaces.ILogging;

public class ActSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	public ActSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	@Override
	public void doLog() {
		logger.info("\n"+"*** ACT Section *** "+message);
	}

}
