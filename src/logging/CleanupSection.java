package logging;

import java.util.List;

import data.ObjectDef;
import framework.KeywordProvider;
import interfaces.IAAALogEvent;
import interfaces.ILogging;

/**
 * Concrete implementation of the IAALogEvent CleanupSection
 * @author Mathew Carrigan
 *
 */
public class CleanupSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	/**
	 * Constructor
	 * @param logger ILogging
	 * @param message Describes what the CleanupSection is doing
	 */
	public CleanupSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	/**
	 * Perform the CleanupSection Log Event
	 */
	@Override
	public void doLog() {
		logger.info("\n"+"*** CLEANUP Section *** "+message);
	}
	
	/**
	 * Helper method for being able to create an instance of this class from Excel Runner
	 * @param keywordProvider KeywordProvider instance
	 * @param defs ObjectDefs
	 * @param params List of Params from param column in excel spreadsheet
	 * @return new CleanupSection from external instantiation vai Excel Runner
	 */
	public static IAAALogEvent instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs, List<String> params) {
		return new CleanupSection(keywordProvider.loggers, params.get(0));
	}

}
