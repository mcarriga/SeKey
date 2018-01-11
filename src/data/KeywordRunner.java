package data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actionKeywords.*;
import framework.KeywordProvider;
import getKeywords.*;
import interfaces.*;
import logging.*;
import waitKeywords.*;
import assertKeywords.*;

public class KeywordRunner 
{
	private final KeywordProvider keywordProvider;
	private final IAction action;
	//private final IAssert asserts;
	//private final IWait wait;
	//private final IGet get;
	public final HashMap<String, Object> getterObjects = new HashMap<String, Object>();
	
	public KeywordRunner(KeywordProvider keywordProvider) 
	{
		this.keywordProvider = keywordProvider;
		this.action = keywordProvider.actions;
		//this.asserts = keywordProvider.asserts;
		//this.wait = keywordProvider.waits;
		//this.get = keywordProvider.get;
	}
	
	public void doAAALog(String methodName, List<ObjectDef> defs, List<String> params) 
	{
		switch(methodName.toLowerCase()) {
		case "arrangesection":
			ArrangeSection.instantiateExternal(keywordProvider, defs, params).doLog();
			break;
		case "actsection":
			ActSection.instantiateExternal(keywordProvider, defs, params).doLog();
			break;
		case "assertsection":
			AssertSection.instantiateExternal(keywordProvider, defs, params).doLog();
			break;
		case "cleanupsection":
			CleanupSection.instantiateExternal(keywordProvider, defs, params).doLog();
			break;
		}
	}
	
	public void doPageObject(Method method, List<Object> methodParams) 
	{
		
	}
	
	public void doGet(String methodName, List<ObjectDef> defs, List<String> params) 
	{
		Object value = null;
		String name = null;
		if(params.size() > 0) { // set the name of the parameter - this will be overridden in a few cases
			name = params.get(0);
		}
		switch(methodName.toLowerCase()) {
		case "getelementtext":
			value = GetText.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getelementvalue":
			if(params.size() > 1) { // if a return object is needed it should always be in the 0 index of Params- i.e. myVariableName|nameOfAttributeToGetValueOf
				params.add(1, "value");
			} else {
				params.add(0, "value");
			}
			
			value = GetElementAttribute.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getelementattribute":
			if(params.size() > 1) { // if a return object is needed it should always be in the 0 index of Params- i.e. myVariableName|nameOfAttributeToGetValueOf
				params.remove(0); // remove the param name like myVariableName so only the name of the Attribute is passed
			}
			value = GetElementAttribute.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "isvisible":
			value = IsVisible.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "isenabled":
			value = IsEnabled.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "isselected":
			value = IsSelected.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getdropdownoptions":
			value = GetDropDownOptions.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getdropdownselectedoption":
			value = GetDropDownSelectedOption.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getdropdownoptionscount":
			value = GetDropDownOptionsCount.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getpagetitle":
			value = GetPageTitle.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "getcurrenturl":
			value = GetCurrentUrl.instantiateExternal(keywordProvider, defs, params).build();
			break;
		}
		
		if(name != null) {
			getterObjects.put(name, value);
		}
	}
	
	public void doWait(String methodName, List<ObjectDef> defs, List<String> params) 
	{
		switch(methodName.toLowerCase()) {
		case "untilelementexists":
			UntilElementExists.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementnotpresent":
			UntilElementNotPresent.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementvisible":
			UntilElementVisible.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilpageloadstatuscomplete":
			UntilPageLoadStatusComplete.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementclickable":
			UntilElementClickable.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementtextequals":
			UntilElementTextEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementtextcontains":
			UntilElementTextContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementvalueequals":
			params.add(0, "value");
			UntilElementAttributeEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementvaluecontains":
			params.add(0, "value");
			UntilElementAttributeContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementattributeequals":
			UntilElementAttributeEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementattributecontains":
			UntilElementAttributeContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementselected":
			UntilElementSelected.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementnotselected":
			UntilElementNotSelected.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilpagetitleequals":
			UntilPageTitleEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilpagetitlecontains":
			UntilPageTitleContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilcurrenturlequals":
			UntilCurrentUrlEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilcurrenturlcontains":
			UntilCurrentUrlContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilalertispresent":
			UntilAlertIsPresent.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untillocatorreturnsnumberofelements":
			UntilLocatorReturnsNumberOfElements.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untillocatorreturnslessthan":
			UntilLocatorReturnsLessThan.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untillocatorreturnsgreaterthan":
			UntilLocatorReturnsGreaterThan.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilpresenceofnestedelement":
			UntilPresenceOfNestedElement.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilpresenceofnestedelements":
			UntilPresenceOfNestedElements.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdownselectedtextis":
			UntilDropDownSelectedTextIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdownselectedvalueis":
			UntilDropDownSelectedValueIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdownitemcountis":
			UntilDropDownItemCountIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdowncontainsoption":
			UntilDropDownContainsOption.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdowncontainsoptions":
			UntilDropDownContainsOptions.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untildropdownoptionsinorderof":
			UntilDropDownOptionsInOrderOf.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilstalenessof":
			UntilStalenessOf.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementnotvisible":
			UntilElementNotVisible.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementenabled":
			UntilElementEnabled.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilelementnotenabled":
			UntilElementNotEnabled.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "untilalertisnotpresent":
			UntilAlertIsNotPresent.instantiateExternal(keywordProvider, defs, params).build();
			break;
		}
	}
	
	public void doAction(String methodName, List<ObjectDef> defs, List<String> params) 
	{
		switch(methodName.toLowerCase()) {
		case "selectbytext":
			SelectByText.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "selectbyindex":
			SelectByIndex.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "click":
			Click.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "sendkeys":
			SetText.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "navigateto":
			keywordProvider.withAction(action.navigateTo(params.get(0)));
			break;
		case "navigateback":
			keywordProvider.withAction(action.navigateBack());
			break;
		case "navigateforward":
			keywordProvider.withAction(action.navigateForward());
			break;
		case "navigaterefresh":
			keywordProvider.withAction(action.navigateRefresh());
			break;
		case "doubleclick":
			DoubleClick.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "hover":
			Hover.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "mouseto":
			params.add(0, "0");
			Hover.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "clickanddrag":
			if(defs.size() == 1 && isBy(defs.get(0))) { // By, int, int
				keywordProvider.withAction(action.clickAndDrag(castToBy(defs.get(0)), Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1))));
			} else if(defs.size() == 1 && isElem(defs.get(0))) { // WebElement int, int
				keywordProvider.withAction(action.clickAndDrag(castToElem(defs.get(0)), Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1))));
			} else if (isBy(defs.get(0)) && isBy(defs.get(1))) { // By, By
				keywordProvider.withAction(action.clickAndDrag(castToBy(defs.get(0)), castToBy(defs.get(1))));
			} else if (isBy(defs.get(0)) && isElem(defs.get(1))) { // By, WebElement
				keywordProvider.withAction(action.clickAndDrag(castToBy(defs.get(0)), castToElem(defs.get(1))));
			} else if (isElem(defs.get(0)) && isBy(defs.get(1))) { // WebElement, By
				keywordProvider.withAction(action.clickAndDrag(castToElem(defs.get(0)), castToBy(defs.get(1))));
			} else { // WebElement, WebElement
				keywordProvider.withAction(action.clickAndDrag(castToElem(defs.get(0)), castToElem(defs.get(1))));
			}
			break;
		case "selectcheckbox":
			SelectCheckbox.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "unselectcheckbox":
			UnselectCheckbox.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "selectradiooptionbyindex":
			SelectRadioOptionByIndex.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "selectradiooptionbyvalue":
			SelectRadioOptionByValue.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "scrolltoelement":
			ScrollToElement.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "switchtoframe":
			if (params.size()>0 && isInteger(params.get(0))) {
				SwitchToFrameIndex.instantiateExternal(keywordProvider, defs, params).build();
				break;
			}
			if (params.size()>0) {
				SwitchToFrame.instantiateExternal(keywordProvider, defs, params).build();
				break;
			}
			SwitchToFrameElement.instantiateExternal(keywordProvider, defs, params).build();
			break;
		}
	}
	
	public void doAssert(String methodName, List<ObjectDef> defs, List<String> params) 
	{
		switch(methodName.toLowerCase()) {
		case "asserttext":
			AssertText.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "asserttextcontains":
			AssertTextContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertvalue":
			AssertValue.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertvaluecontains":
			AssertValueContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementattributevalue":
			AssertElementAttributeValue.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementattributevaluecontains":
			AssertElementAttributeValueContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementexists":
			AssertElementExists.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementvisible":
			AssertElementVisible.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementnotvisible":
			AssertElementNotVisible.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementenabled":
			AssertElementEnabled.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementnotenabled":
			AssertElementNotEnabled.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementselected":
			AssertElementSelected.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertelementnotselected":
			AssertElementNotSelected.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertpagetitleequals":
			AssertPageTitleEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertpagetitlecontains":
			AssertPageTitleContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "asserturlequals":
			AssertCurrentUrlEquals.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "asserturlcontains":
			AssertCurrentUrlContains.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertalertispresent":
			AssertAlertIsPresent.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertlocatorreturnsnumberofelements":
			AssertLocatorReturnsNumberOfElements.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertlocatorreturnslessthan":
			AssertLocatorReturnsLessThan.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertlocatorreturnsgreaterthan":
			AssertLocatorReturnsGreaterThan.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdownselectedtextis":
			AssertDropDownSelectedTextIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdownselectedvalueis":
			AssertDropDownSelectedValueIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdownitemcountis":
			AssertDropDownItemCountIs.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdowncontainsoption":
			AssertDropDownContainsOption.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdowncontainsoptions":
			AssertDropDownContainsOptions.instantiateExternal(keywordProvider, defs, params).build();
			break;
		case "assertdropdownoptionsinorderof":
			AssertDropDownOptionsInOrderOf.instantiateExternal(keywordProvider, defs, params).build();
			break;
		}
		
	}
	
	public static boolean isInteger(String s) 
	{
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
	
	public static boolean isElem(ObjectDef def) 
	{
		if(def.getClazz().equals(WebElement.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBy(ObjectDef def) 
	{
		if(def.getClazz().equals(By.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static WebElement castToElem(ObjectDef def) 
	{
		return (WebElement)def.getObject();
	}
	
	public static By castToBy(ObjectDef def) 
	{
		return (By)def.getObject();
	}
	
	public static Object cast(Class<?> clazz, Object object) 
	{
		return clazz.cast(object);
	}
}
