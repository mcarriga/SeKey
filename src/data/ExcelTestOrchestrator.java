package data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import framework.Framework;
import interfaces.IAAALogEvent;
import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ITouchAction;
import interfaces.IWait;

public class ExcelTestOrchestrator {
	private final ExcelWorkbook workbook;
	private final Iterable<String> sheetsToRun;
	private final Framework framework;
	private final Class<?> pageObjectPackage;
	private final KeywordRunner keywordRunner;
	private List<Method> actionsX = Arrays.asList(IAction.class.getDeclaredMethods());
	private List<Method> assertsX = Arrays.asList(IAssert.class.getDeclaredMethods());
	private List<Method> getsX = Arrays.asList(IGet.class.getDeclaredMethods());
	private List<Method> waitsX = Arrays.asList(IWait.class.getDeclaredMethods());
	private List<Method> touchX = Arrays.asList(ITouchAction.class.getDeclaredMethods());
	private List<Method> aaaX = Arrays.asList(IAAALogEvent.class.getDeclaredMethods());
	private List<String> actions = actionsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	private List<String> asserts = assertsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	private List<String> gets = getsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	private List<String> waits = waitsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	private List<String> gestures = touchX.stream().map(x -> x.getName()).collect(Collectors.toList());
	private List<String> tripleALogs = aaaX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	public ExcelTestOrchestrator(Framework framework, Class<?> pageObjectPackage, ExcelWorkbook workbook, Iterable<String> sheetsToRun) {
		this.framework = framework;
		this.pageObjectPackage = pageObjectPackage;
		this.workbook = workbook;
		this.sheetsToRun = sheetsToRun;
		this.keywordRunner= new KeywordRunner(framework);
	}
	
	@SuppressWarnings("serial")
	public ExcelTestOrchestrator(Framework framework, Class<?> pageObjectPackage, ExcelWorkbook workbook, String sheetsToRun) {
		this(framework, pageObjectPackage, workbook, new ArrayList<String>() {{add(sheetsToRun);}});
	}
	
	public void x() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
		ExcelTestRunner runner = new ExcelTestRunner(workbook, sheetsToRun);
		HashMap<ExcelWorksheet, List<ExcelTest>> all = runner.init();
		Set<ExcelWorksheet> sheets = all.keySet();
		for(ExcelWorksheet sheet : sheets) {
			List<ExcelTest> tests = all.get(sheet);
			for(ExcelTest test : tests) {
				List<ExcelTestStep> steps = test.getTestSteps();
				for(ExcelTestStep step : steps) {
					
					if(!step.getKeyword().equalsIgnoreCase("PageObject")) {
						List<String> objects = step.getObjects();
						List<ObjectDef> defs = new ArrayList<ObjectDef>();
						for(String obj : objects) {
							String[] vals = obj.split("\\.");
							
							ObjectDef def = ObjectFinder.x(framework, "PageObject."+vals[0], vals[1]);
							defs.add(def);
						}
						
						//run the step
						b(step.getKeyword(), defs, step.getParams());
					} else {
						c(step.getObjects().get(0), step.getParams());
					}
				}
			}
		}
	}
	
	private void c(String objects, List<String> params) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String[] vals = objects.split("\\.");
		String cls = "PageObject."+vals[0];
		String method = vals[1];
		ObjectFinder.getMethod(framework, cls, method, params);
	}

	
	private void b(String keywordName, List<ObjectDef> defs, List<String> params) {
		
		if(containsIgnoreCase(actions, keywordName)) {
			String methodName = getMethodName(actionsX, keywordName);
			keywordRunner.doAction(methodName, defs, params);
			
		} else if(containsIgnoreCase(asserts, keywordName)) {
			
		} else if(containsIgnoreCase(gets, keywordName)) {
			
		} else if(containsIgnoreCase(waits, keywordName)) {
			
		} else if(containsIgnoreCase(gestures, keywordName)) {
			
		} else if(containsIgnoreCase(tripleALogs, keywordName)) {
			
		} else {
			
		}
	}
	
	private boolean containsIgnoreCase(List <String> l, String s){
		 Iterator<String> it = l.iterator();
		 while(it.hasNext()){
		  if(it.next().equalsIgnoreCase(s))
		  return true;
		 }
		 return false;
	}
	
	private String getMethodName(List <Method> l, String s) {
		Iterator<Method> it = l.iterator();
			while(it.hasNext()){
				Method method = it.next();
				String name = method.getName();
				if(name.equalsIgnoreCase(s)) {
					return name;
				}
			}
		throw new java.lang.UnsupportedOperationException("Method with name '"+s+"' not found in available keywords");
	}
}
