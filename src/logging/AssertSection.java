package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
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
	
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new AssertSection(framework.logger, params.get(0));
	}
}
