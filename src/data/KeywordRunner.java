package data;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.Framework;
import interfaces.*;

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
	
	public void doPageObject(Method method, List<Object> methodParams) {
		
	}
	
	public void doAction(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "selectbytext":
			if(isBy(defs.get(0))) {
				framework.withAction(action.selectByText(castToBy(defs.get(0)), params.get(0)));
			} else {
				framework.withAction(action.selectByText(castToElem(defs.get(0)), params.get(0)));
			}
			break;
		case "selectbyindex":
			if(isBy(defs.get(0))) {
				framework.withAction(action.selectByIndex(castToBy(defs.get(0)), Integer.parseInt(params.get(0))));
			} else {
				framework.withAction(action.selectByIndex(castToElem(defs.get(0)), Integer.parseInt(params.get(0))));
			}
			break;
		case "click":
			if(isBy(defs.get(0))) {
				framework.withAction(action.click(castToBy(defs.get(0))));
			} else {
				framework.withAction(action.click(castToElem(defs.get(0))));
			}
			break;
		case "sendkeys":
			if(isBy(defs.get(0))) {
				framework.withAction(action.sendKeys(castToBy(defs.get(0)), params.get(0)));
			} else {
				framework.withAction(action.sendKeys(castToElem(defs.get(0)), params.get(0)));
			}
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
			if(defs.get(0).getClazz().equals(By.class)) {
				framework.withAction(action.doubleClick(castToBy(defs.get(0))));
			} else {
				framework.withAction(action.doubleClick(castToElem(defs.get(0))));
			}
			break;
		case "hover":
			if(isBy(defs.get(0))) {
				framework.withAction(action.hover(castToBy(defs.get(0)), (long)Double.parseDouble(params.get(0))));
			} else {
				framework.withAction(action.hover(castToElem(defs.get(0)), (long)Double.parseDouble(params.get(0))));
			}
			break;
		case "mouseto":
			if(isBy(defs.get(0))) {
				framework.withAction(action.mouseTo((By)defs.get(0).getObject()));
			} else {
				framework.withAction(action.mouseTo(castToElem(defs.get(0))));
			}
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
			if(isBy(defs.get(0))) {
				framework.withAction(action.selectCheckbox(castToBy(defs.get(0))));
			} else {
				framework.withAction(action.selectCheckbox(castToElem(defs.get(0))));
			};
		case "unselectcheckbox":
			if(isBy(defs.get(0))) {
				framework.withAction(action.unselectCheckbox(castToBy(defs.get(0))));
			} else {
				framework.withAction(action.unselectCheckbox(castToElem(defs.get(0))));
			};
			break;
		case "selectradiooptionbyindex":
			if(isBy(defs.get(0))) {
				framework.withAction(action.selectRadioOptionByIndex(castToBy(defs.get(0)), Integer.parseInt(params.get(0))));
			} else {
				framework.withAction(action.selectRadioOptionByIndex(castToElem(defs.get(0)), Integer.parseInt(params.get(0))));
			};
			break;
		case "selectradiooptionbyvalue":
			if(isBy(defs.get(0))) {
				framework.withAction(action.selectRadioOptionByValue(castToBy(defs.get(0)), params.get(0)));
			} else {
				framework.withAction(action.selectRadioOptionByValue(castToElem(defs.get(0)), params.get(0)));
			};
			break;
		case "scrolltoelement":
			if(isBy(defs.get(0))) {
				framework.withAction(action.scrollToElement(castToBy(defs.get(0))));
			} else {
				framework.withAction(action.scrollToElement(castToElem(defs.get(0))));
			};
			break;
		case "switchtoframe":
			if(defs.size() > 0 && isBy(defs.get(0))) {
				framework.withAction(action.switchToFrame(castToBy(defs.get(0))));
			} else if (defs.size() > 0 && isElem(defs.get(0))) {
				framework.withAction(action.switchToFrame(castToElem(defs.get(0))));
			} else if (isInteger(params.get(0))) {
				framework.withAction(action.switchToFrame(Integer.parseInt(params.get(0))));
			} else {
				framework.withAction(action.switchToFrame(params.get(0)));
			}
		}
	}
	
	public void doAssert(String methodName, List<ObjectDef> defs, List<String> params) {
		switch(methodName.toLowerCase()) {
		case "asserttext":
			if(isBy(defs.get(0))) {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertText(castToBy(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertText(castToBy(defs.get(0)), params.get(0)));
				}
			} else {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertText(castToElem(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertText(castToElem(defs.get(0)), params.get(0)));
				}
			}
			break;
		case "asserttextcontains":
			if(isBy(defs.get(0))) {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertTextContains(castToBy(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertTextContains(castToBy(defs.get(0)), params.get(0)));
				}
			} else {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertTextContains(castToElem(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertTextContains(castToElem(defs.get(0)), params.get(0)));
				}
			}
			break;
		case "assertvalue":
			if(isBy(defs.get(0))) {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertValue(castToBy(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertValue(castToBy(defs.get(0)), params.get(0)));
				}
			} else {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertValue(castToElem(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertValue(castToElem(defs.get(0)), params.get(0)));
				}
			}
			break;
		case "assertvaluecontains":
			if(isBy(defs.get(0))) {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertValueContains(castToBy(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertValueContains(castToBy(defs.get(0)), params.get(0)));
				}
			} else {
				if(params.size() > 1) {
					framework.withAssert(asserts.assertValueContains(castToElem(defs.get(0)), params.get(0), (long)Integer.parseInt(params.get(1))));
				} else {
					framework.withAssert(asserts.assertValueContains(castToElem(defs.get(0)), params.get(0)));
				}
			}
			break;
		case "assertelementattributevalue":
			if(isBy(defs.get(0))) {
				if(params.size() > 2) {
					framework.withAssert(asserts.assertElementAttributeValue(castToBy(defs.get(0)), params.get(0), params.get(1), (long)Integer.parseInt(params.get(2))));
				} else {
					framework.withAssert(asserts.assertElementAttributeValue(castToBy(defs.get(0)), params.get(0), params.get(1) ));
				}
			} else {
				if(params.size() > 2) {
					framework.withAssert(asserts.assertElementAttributeValue(castToElem(defs.get(0)), params.get(0), params.get(1), (long)Integer.parseInt(params.get(2))));
				} else {
					framework.withAssert(asserts.assertElementAttributeValue(castToElem(defs.get(0)), params.get(0), params.get(1)));
				}
			}
			break;
		case "assertelementattributevaluecontains":
			if(isBy(defs.get(0))) {
				if(params.size() > 2) {
					framework.withAssert(asserts.assertElementAttributeValueContains(castToBy(defs.get(0)), params.get(0), params.get(1), (long)Integer.parseInt(params.get(2))));
				} else {
					framework.withAssert(asserts.assertElementAttributeValueContains(castToBy(defs.get(0)), params.get(0), params.get(1) ));
				}
			} else {
				if(params.size() > 2) {
					framework.withAssert(asserts.assertElementAttributeValueContains(castToElem(defs.get(0)), params.get(0), params.get(1), (long)Integer.parseInt(params.get(2))));
				} else {
					framework.withAssert(asserts.assertElementAttributeValueContains(castToElem(defs.get(0)), params.get(0), params.get(1)));
				}
			}
			break;
		case "assertelementexists":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementExists(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementExists(castToBy(defs.get(0))));
				}
			}
			break;
		case "assertelementvisible":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementVisible(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementVisible(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementVisible(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementVisible(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertelementnotvisible":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotVisible(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotVisible(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotVisible(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotVisible(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertelementenabled":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementEnabled(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementEnabled(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementEnabled(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementEnabled(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertelementnotenabled":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotEnabled(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotEnabled(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotEnabled(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotEnabled(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertelementselected":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementSelected(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementSelected(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementSelected(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementSelected(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertelementnotselected":
			if(isBy(defs.get(0))) {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotSelected(castToBy(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotSelected(castToBy(defs.get(0))));
				}
			} else {
				if(params.size() > 0) {
					framework.withAssert(asserts.assertElementNotSelected(castToElem(defs.get(0)), (long)Integer.parseInt(params.get(0))));
				} else {
					framework.withAssert(asserts.assertElementNotSelected(castToElem(defs.get(0))));
				}
			}
			break;
		case "assertpagetitleequals":
			if(params.size() > 1) {
				framework.withAssert(asserts.assertPageTitleEquals(params.get(0), (long)Integer.parseInt(params.get(2))));
			} else {
				framework.withAssert(asserts.assertPageTitleEquals(params.get(0)));
			}
			break;
		case "assertpagetitlecontains":
			if(params.size() > 1) {
				framework.withAssert(asserts.assertPageTitleContains(params.get(0), (long)Integer.parseInt(params.get(2))));
			} else {
				framework.withAssert(asserts.assertPageTitleContains(params.get(0)));
			}
			break;
		case "asserturlequals":
			break;
		case "asserturlcontains":
			break;
		case "assertalertispresent":
			break;
		case "assertlocatorreturnsnumberofelements":
			break;
		case "assertlocatorreturnslessthan":
			break;
		case "assertlocatorreturnsgreaterthat":
			break;
		case "assertdropdownselectedtextis":
			break;
		case "assertdropdownselectedvalueis":
			break;
		case "assertdropdownitemcountis":
			break;
		case "assertdropdowncountainsoption":
			break;
		case "assertdropdowncountainsoptions":
			break;
		case "assertdropdownoptionsinorderof":
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
	
	private static boolean isElem(ObjectDef def) {
		if(def.getClazz().equals(WebElement.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean isBy(ObjectDef def) {
		if(def.getClazz().equals(By.class)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static WebElement castToElem(ObjectDef def) {
		return (WebElement)def.getObject();
	}
	
	private static By castToBy(ObjectDef def) {
		return (By)def.getObject();
	}
	
	private static Object cast(Class<?> clazz, Object object) {
		return clazz.cast(object);
	}
}
