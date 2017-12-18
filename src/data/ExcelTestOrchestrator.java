package data;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.IAAALogEvent;
import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ITouchAction;
import interfaces.IWait;

public class ExcelTestOrchestrator {
	private final ExcelWorkbook workbook;
	private final Iterable<String> sheetsToRun;
	
	public ExcelTestOrchestrator(ExcelWorkbook workbook, Iterable<String> sheetsToRun) {
		this.workbook = workbook;
		this.sheetsToRun = sheetsToRun;
	}
	
	public void x() {
		ExcelTestRunner runner = new ExcelTestRunner(workbook, sheetsToRun);
		HashMap<ExcelWorksheet, List<ExcelTest>> all = runner.init();
		
	}
	
	private void y() {
		List<Method> actionsX = Arrays.asList(IAction.class.getDeclaredMethods());
		List<Method> assertsX = Arrays.asList(IAssert.class.getDeclaredMethods());
		List<Method> getsX = Arrays.asList(IGet.class.getDeclaredMethods());
		List<Method> waitsX = Arrays.asList(IWait.class.getDeclaredMethods());
		List<Method> touchX = Arrays.asList(ITouchAction.class.getDeclaredMethods());
		List<Method> aaaX = Arrays.asList(IAAALogEvent.class.getDeclaredMethods());
		
		List<String> actions = actionsX.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> asserts = assertsX.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> gets = getsX.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> waits = waitsX.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> gestures = touchX.stream().map(x -> x.getName()).collect(Collectors.toList());
		List<String> tripleALogs = aaaX.stream().map(x -> x.getName()).collect(Collectors.toList());
	}
}
