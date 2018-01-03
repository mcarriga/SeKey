package framework;

import java.util.Set;

public class MvnProperties
{
	public final static String browser = System.getProperty("browser", "chrome").toLowerCase();
	public final static String browserArgs  = System.getProperty("browserArgs", "chrome");
	public final static String gridUrl = System.getProperty("gridUrl", "");
	public final static String almHost = System.getProperty("almHost", null);
	public final static String almPort = System.getProperty("almPort", null);
	public final static String almUsername = System.getProperty("almUsername", null);
	public final static String almPassword = System.getProperty("almPassword", null);
	public final static String almDomain = System.getProperty("almDomain", null);
	public final static String almProject = System.getProperty("almProject", null);
	public final static boolean doUpdateTestCase = Boolean.parseBoolean(System.getProperty("updateTestCase", "false").toLowerCase());
	public final static boolean runLocal = Boolean.parseBoolean(System.getProperty("runLocal", "true").toLowerCase());
	public final static Set<Object> allPropertyKeys = System.getProperties().keySet();
}
