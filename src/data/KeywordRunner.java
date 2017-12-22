package data;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.Framework;
import interfaces.*;
import keywords.*;
import logging.*;

public class KeywordRunner {
	private final Framework framework;
	private final IAction action;
	private final IAssert asserts;
	private final IWait wait;
	private final IGet get;
	
	public KeywordRunner(Framework framework) {
		this.framework = framework;
		this.action = framework.action;
		this.asserts = framework.asserter;
		this.wait = framework.wait;
		this.get = framework.get;
	}
	
	public void doAAALog(String methodName, List<ObjectDef> defs, List<String> params){
		switch(methodName.toLowerCase()) {
		case "arrangesection":
			ArrangeSection.instantiateExternal(framework, defs, params).doLog();
			break;
		case "actsection":
			ActSection.instantiateExternal(framework, defs, params).doLog();
			break;
		case "assertsection":
			AssertSection.instantiateExternal(framework, defs, params).doLog();
			break;
		case "cleanupsection":
			CleanupSection.instantiateExternal(framework, defs, params).doLog();
			break;
		}
	}
	
	public void doPageObject(Method method, List<Object> methodParams) {
		
	}
	
	public void doGet(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "getelementtext":
			GetText.instantiateExternal(framework, defs, params).build();
			break;
		case "getelementvalue":
			params.add(0, "value");
			GetElementAttribute.instantiateExternal(framework, defs, params).build();
			break;
		case "getelementattribute":
			GetElementAttribute.instantiateExternal(framework, defs, params).build();
			break;
		case "isvisible":
			IsVisible.instantiateExternal(framework, defs, params).build();
			break;
		case "isenabled":
			IsEnabled.instantiateExternal(framework, defs, params).build();
			break;
		case "isselected":
			IsSelected.instantiateExternal(framework, defs, params).build();
			break;
		case "getdropdownoptions":
			GetDropDownOptions.instantiateExternal(framework, defs, params).build();
			break;
		case "getdropdownselectedoption":
			GetDropDownSelectedOption.instantiateExternal(framework, defs, params).build();
			break;
		case "getdropdownoptionscount":
			GetDropDownOptionsCount.instantiateExternal(framework, defs, params).build();
			break;
		case "getpagetitle":
			GetPageTitle.instantiateExternal(framework, defs, params).build();
			break;
		case "getcurrenturl":
			GetCurrentUrl.instantiateExternal(framework, defs, params).build();
			break;
		}
	}
	
	public void doWait(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "untilelementexists":
			UntilElementExists.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementnotpresent":
			UntilElementNotPresent.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementvisible":
			UntilElementVisible.instantiateExternal(framework, defs, params).build();
			break;
		case "untilpageloadstatuscomplete":
			UntilPageLoadStatusComplete.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementclickable":
			UntilElementClickable.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementtextequals":
			UntilElementTextEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementtextcontains":
			UntilElementTextContains.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementvalueequals":
			params.add(0, "value");
			UntilElementAttributeEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementvaluecontains":
			params.add(0, "value");
			UntilElementAttributeContains.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementattributeequals":
			UntilElementAttributeEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementattributecontains":
			UntilElementAttributeContains.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementselected":
			UntilElementSelected.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementnotselected":
			UntilElementNotSelected.instantiateExternal(framework, defs, params).build();
			break;
		case "untilpagetitleequals":
			UntilPageTitleEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "untilpagetitlecontains":
			UntilPageTitleContains.instantiateExternal(framework, defs, params).build();
			break;
		case "untilcurrenturlequals":
			UntilCurrentUrlEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "untilcurrenturlcontains":
			UntilCurrentUrlContains.instantiateExternal(framework, defs, params).build();
			break;
		case "untilalertispresent":
			UntilAlertIsPresent.instantiateExternal(framework, defs, params).build();
			break;
		case "untillocatorreturnsnumberofelements":
			UntilLocatorReturnsNumberOfElements.instantiateExternal(framework, defs, params).build();
			break;
		case "untillocatorreturnslessthan":
			UntilLocatorReturnsLessThan.instantiateExternal(framework, defs, params).build();
			break;
		case "untillocatorreturnsgreaterthan":
			UntilLocatorReturnsGreaterThan.instantiateExternal(framework, defs, params).build();
			break;
		case "untilpresenceofnestedelement":
			UntilPresenceOfNestedElement.instantiateExternal(framework, defs, params).build();
			break;
		case "untilpresenceofnestedelements":
			UntilPresenceOfNestedElements.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdownselectedtextis":
			UntilDropDownSelectedTextIs.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdownselectedvalueis":
			UntilDropDownSelectedValueIs.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdownitemcountis":
			UntilDropDownItemCountIs.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdowncontainsoption":
			UntilDropDownContainsOption.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdowncontainsoptions":
			UntilDropDownContainsOptions.instantiateExternal(framework, defs, params).build();
			break;
		case "untildropdownoptionsinorderof":
			UntilDropDownOptionsInOrderOf.instantiateExternal(framework, defs, params).build();
			break;
		case "untilstalenessof":
			UntilStalenessOf.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementnotvisible":
			UntilElementNotVisible.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementenabled":
			UntilElementEnabled.instantiateExternal(framework, defs, params).build();
			break;
		case "untilelementnotenabled":
			UntilElementNotEnabled.instantiateExternal(framework, defs, params).build();
			break;
		case "untilalertisnotpresent":
			UntilAlertIsNotPresent.instantiateExternal(framework, defs, params).build();
			break;
		}
	}
	
	public void doAction(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "selectbytext":
			SelectByText.instantiateExternal(framework, defs, params).build();
			break;
		case "selectbyindex":
			SelectByIndex.instantiateExternal(framework, defs, params).build();
			break;
		case "click":
			Click.instantiateExternal(framework, defs, params).build();
			break;
		case "sendkeys":
			SetText.instantiateExternal(framework, defs, params).build();
			break;
		case "navigateto":
			framework.withAction(action.navigateTo(params.get(0)));
			break;
		case "navigateback":
			framework.withAction(action.navigateBack());
			break;
		case "navigateforward":
			framework.withAction(action.navigateForward());
			break;
		case "navigaterefresh":
			framework.withAction(action.navigateRefresh());
			break;
		case "doubleclick":
			DoubleClick.instantiateExternal(framework, defs, params).build();
			break;
		case "hover":
			Hover.instantiateExternal(framework, defs, params).build();
			break;
		case "mouseto":
			params.add(0, "0");
			Hover.instantiateExternal(framework, defs, params).build();
			break;
		case "clickanddrag":
			if(defs.size() == 1 && isBy(defs.get(0))) { // By, int, int
				framework.withAction(action.clickAndDrag(castToBy(defs.get(0)), Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1))));
			} else if(defs.size() == 1 && isElem(defs.get(0))) { // WebElement int, int
				framework.withAction(action.clickAndDrag(castToElem(defs.get(0)), Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1))));
			} else if (isBy(defs.get(0)) && isBy(defs.get(1))) { // By, By
				framework.withAction(action.clickAndDrag(castToBy(defs.get(0)), castToBy(defs.get(1))));
			} else if (isBy(defs.get(0)) && isElem(defs.get(1))) { // By, WebElement
				framework.withAction(action.clickAndDrag(castToBy(defs.get(0)), castToElem(defs.get(1))));
			} else if (isElem(defs.get(0)) && isBy(defs.get(1))) { // WebElement, By
				framework.withAction(action.clickAndDrag(castToElem(defs.get(0)), castToBy(defs.get(1))));
			} else { // WebElement, WebElement
				framework.withAction(action.clickAndDrag(castToElem(defs.get(0)), castToElem(defs.get(1))));
			}
			break;
		case "selectcheckbox":
			SelectCheckbox.instantiateExternal(framework, defs, params).build();
			break;
		case "unselectcheckbox":
			UnselectCheckbox.instantiateExternal(framework, defs, params).build();
			break;
		case "selectradiooptionbyindex":
			SelectRadioOptionByIndex.instantiateExternal(framework, defs, params).build();
			break;
		case "selectradiooptionbyvalue":
			SelectRadioOptionByValue.instantiateExternal(framework, defs, params).build();
			break;
		case "scrolltoelement":
			ScrollToElement.instantiateExternal(framework, defs, params).build();
			break;
		case "switchtoframe":
			if (params.size()>0 && isInteger(params.get(0))) {
				SwitchToFrameIndex.instantiateExternal(framework, defs, params).build();
				break;
			}
			if (params.size()>0) {
				SwitchToFrame.instantiateExternal(framework, defs, params).build();
				break;
			}
			SwitchToFrameElement.instantiateExternal(framework, defs, params).build();
			break;
		}
	}
	
	public void doAssert(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "asserttext":
			AssertText.instantiateExternal(framework, defs, params).build();
			break;
		case "asserttextcontains":
			AssertTextContains.instantiateExternal(framework, defs, params).build();
			break;
		case "assertvalue":
			AssertValue.instantiateExternal(framework, defs, params).build();
			break;
		case "assertvaluecontains":
			AssertValueContains.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementattributevalue":
			AssertElementAttributeValue.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementattributevaluecontains":
			AssertElementAttributeValueContains.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementexists":
			AssertElementExists.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementvisible":
			AssertElementVisible.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementnotvisible":
			AssertElementNotVisible.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementenabled":
			AssertElementEnabled.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementnotenabled":
			AssertElementNotEnabled.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementselected":
			AssertElementSelected.instantiateExternal(framework, defs, params).build();
			break;
		case "assertelementnotselected":
			AssertElementNotSelected.instantiateExternal(framework, defs, params).build();
			break;
		case "assertpagetitleequals":
			AssertPageTitleEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "assertpagetitlecontains":
			AssertPageTitleContains.instantiateExternal(framework, defs, params).build();
			break;
		case "asserturlequals":
			AssertCurrentUrlEquals.instantiateExternal(framework, defs, params).build();
			break;
		case "asserturlcontains":
			AssertCurrentUrlContains.instantiateExternal(framework, defs, params).build();
			break;
		case "assertalertispresent":
			AssertAlertIsPresent.instantiateExternal(framework, defs, params).build();
			break;
		case "assertlocatorreturnsnumberofelements":
			AssertLocatorReturnsNumberOfElements.instantiateExternal(framework, defs, params).build();
			break;
		case "assertlocatorreturnslessthan":
			AssertLocatorReturnsLessThan.instantiateExternal(framework, defs, params).build();
			break;
		case "assertlocatorreturnsgreaterthan":
			AssertLocatorReturnsGreaterThan.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdownselectedtextis":
			AssertDropDownSelectedTextIs.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdownselectedvalueis":
			AssertDropDownSelectedValueIs.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdownitemcountis":
			AssertDropDownItemCountIs.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdowncontainsoption":
			AssertDropDownContainsOption.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdowncontainsoptions":
			AssertDropDownContainsOptions.instantiateExternal(framework, defs, params).build();
			break;
		case "assertdropdownoptionsinorderof":
			AssertDropDownOptionsInOrderOf.instantiateExternal(framework, defs, params).build();
			break;
		}
		
	}
	
	public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	   }
	
	public static boolean isElem(ObjectDef def) {
		if(def.getClazz().equals(WebElement.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBy(ObjectDef def) {
		if(def.getClazz().equals(By.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static WebElement castToElem(ObjectDef def) {
		return (WebElement)def.getObject();
	}
	
	public static By castToBy(ObjectDef def) {
		return (By)def.getObject();
	}
	
	public static Object cast(Class<?> clazz, Object object) {
		return clazz.cast(object);
	}
}
