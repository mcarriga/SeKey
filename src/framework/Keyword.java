package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import interfaces.IKeyword;

public abstract class Keyword <T extends Object> implements IKeyword<Object>{
	public abstract T perform();
	public abstract void startLog();
	public abstract void endLog();
	public final T build() {
		startLog();
		T x = perform();
		endLog();
		return x;
	}
	public abstract Keyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects, List<String> params);
	
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
