package framework;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class MvnProperties
{
	public final String browser;
	public final String gridUrl;
	public final boolean doUpdateTestCase;
	public final Set<String> allPropertyKeys;
	
	public MvnProperties() {
		java.util.Properties properties = new Properties();
		try
		{
			properties.load(this.getClass().getResourceAsStream("my.properties"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser = properties.getProperty("browser", "chrome").toLowerCase();
		gridUrl = properties.getProperty("gridUrl", "");
		doUpdateTestCase = Boolean.parseBoolean(properties.getProperty("updateTestCase", "false"));
		allPropertyKeys = properties.stringPropertyNames();
	}
}
