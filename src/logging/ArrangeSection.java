package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
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
	
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new ArrangeSection(framework.logger, params.get(0));
	}
}
