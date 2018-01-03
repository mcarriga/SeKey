package interfaces;

import java.util.List;

public interface ITestStep
{
	String getKeyword();
	List<String> getObjects();
	List<String> getParams();
}
