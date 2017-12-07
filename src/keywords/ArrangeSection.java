package keywords;

import interfaces.IAAALogEvent;
import interfaces.ILogging;

public class ArrangeSection implements IAAALogEvent {
	private final String message;
	private final ILogging logger;
	
	public ArrangeSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	@Override
	public void doLog() {
		logger.info("\n"+"*** ARRANGE Section *** "+message);
	}
}
