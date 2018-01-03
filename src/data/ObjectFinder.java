package data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.Framework;

public class ObjectFinder 
{
	public static ObjectDef x(Framework framework, String ClassName, String fieldName) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException 
	{
		 
		Class<?> cls = Class.forName(ClassName);
		Constructor<?> constructor = cls.getConstructor(Framework.class);
		Object instance = constructor.newInstance(framework);
		
		Field field = instance.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		
		Class<?> fieldType = field.getType();
		if(field.isAnnotationPresent(FindBy.class)) {
			FindBy findBy = field.getDeclaredAnnotation(FindBy.class);
			if(WebElement.class.isAssignableFrom(fieldType)) {
				return new ObjectDef(fieldType, framework.driver.findElement(getByLocator(findBy)));
			}else {
				return new ObjectDef(fieldType, framework.driver.findElements(getByLocator(findBy)));
			}
		} else {
			return new ObjectDef(fieldType, field.get(fieldType.newInstance()));
		}
		
		//Object ret = fieldType.newInstance();
		//Object value = field.get(fieldType.insta);
	}
	
	public static void getMethod(Framework framework, String ClassName, String methodName, List<String> methodParams) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Class<?> cls = Class.forName(ClassName);
		Constructor<?> constructor = cls.getConstructor(Framework.class);
		Object instance = constructor.newInstance(framework);
		
		Method method = instance.getClass().getMethod(methodName);
		//Parameter[] params = method.getParameters();
		
		if(methodParams.size() >0 && methodParams.get(0) != "") {
			method.invoke(instance, methodParams.toArray());
		} else {
			method.invoke(instance);
		}
	}
	
	private static By getByLocator(FindBy find) 
	{
		String using = find.using();
		switch(find.how()) {
		case CLASS_NAME:
			return By.className(using);
		case CSS:
			return By.cssSelector(using);
		case ID:
			return By.id(using);
		case ID_OR_NAME:
			return By.xpath("//*[@name = '"+using+"' or @id='"+using+"']");
		case LINK_TEXT:
			return By.linkText(using);
		case NAME:
			return By.name(using);
		case PARTIAL_LINK_TEXT:
			return By.partialLinkText(using);
		case TAG_NAME:
			return By.tagName(using);
		case UNSET:
			return By.id(using);
		case XPATH:
			return By.xpath(using);
		default:
			return null;
		
		}
	}
}
