package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
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
	
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new ActSection(framework.logger, params.get(0));
	}

}
