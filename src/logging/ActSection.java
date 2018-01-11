package logging;

import java.util.List;

import data.ObjectDef;
import framework.KeywordProvider;
import interfaces.IAAALogEvent;
import interfaces.ILogging;

/**
 * Concrete class for the IAAALogEvent Act Section
 * @author Mathew Carrigan
 *
 */
public class ActSection implements IAAALogEvent {

	private final String message;
	private final ILogging logger;
	
	/**
	 * Constructor
	 * @param logger ILogging 
	 * @param message Describes what the Act Section is doing
	 */
	public ActSection(ILogging logger, String message){
		this.logger = logger;
		this.message = message;
	}

	/**
	 * perform ActSection Log Event
	 */
	@Override
	public void doLog() {
		logger.info("\n"+"*** ACT Section *** "+message);
	}
	
	/**
	 * Helper method for being able to create an instance of this class from Excel Runner
	 * @param keywordProvider KeywordProvider instance
	 * @param defs ObjectDefs
	 * @param params List of Params from param column in excel spreadsheet
	 * @return new ActSection from external instantiation vai Excel Runner
	 */
	public static IAAALogEvent instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs, List<String> params) {
		return new ActSection(keywordProvider.loggers, params.get(0));
	}

}
