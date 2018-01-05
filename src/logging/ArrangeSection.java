package logging;

import java.util.List;

import data.ObjectDef;
import framework.Framework;
import interfaces.IAAALogEvent;
import interfaces.ILogging;

/**
 * Concrete implementation of IAALogEvent Arrange Section
 * @author Mathew Carrigan
 *
 */
public class ArrangeSection implements IAAALogEvent {
	private final String message;
	private final ILogging logger;
	
	/**
	 * Constructor
	 * @param logger ILogging
	 * @param message Describes what the ArrangeSection for the test case is doing
	 */
	public ArrangeSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	/**
	 * Perform ArrangeSection Log Event
	 */
	@Override
	public void doLog() {
		logger.info("\n"+"*** ARRANGE Section *** "+message);
	}
	
	/**
	 * Helper method for being able to create an instance of this class from Excel Runner
	 * @param framework Framework instance
	 * @param defs ObjectDefs
	 * @param params List of Params from param column in excel spreadsheet
	 * @return new ArrangeSection from external instantiation vai Excel Runner
	 */
	public static IAAALogEvent instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params) {
		return new ArrangeSection(framework.logger, params.get(0));
	}
}
