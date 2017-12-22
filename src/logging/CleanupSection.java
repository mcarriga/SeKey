package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
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
	
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new CleanupSection(framework.logger, params.get(0));
	}

}
