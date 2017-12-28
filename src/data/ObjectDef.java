package data;

public class ObjectDef 
{
	private final Class<?> clazz;
	private final Object object;
	public ObjectDef(Class<?> clazz,  Object object) 
	{
		this.clazz = clazz;
		this.object = object;
	}
	
	public Class<?> getClazz() 
	{
		return clazz;
	}
	
	public Object getObject() 
	{
		return object;
	}
}
