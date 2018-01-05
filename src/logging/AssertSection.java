package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
import interfaces.IAAALogEvent;
import interfaces.ILogging;

/**
 * Concrete implementation of the IAALogEvent AssertSection
 * @author Mathew Carrigan
 *
 */
public class AssertSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	/**
	 * Constructor
	 * @param logger ILogging
	 * @param message Describes what the AssertSection is Asserting
	 */
	public AssertSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	/**
	 * Perform the AssertSection Log Event
	 */
	@Override
	public void doLog() {
		logger.info("\n"+"*** ASSERT Section *** "+message);
	}
	
	/**
	 * Helper method for being able to create an instance of this class from Excel Runner
	 * @param framework
	 * @param defs
	 * @param params
	 * @return
	 */
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new AssertSection(framework.logger, params.get(0));
	}
}
