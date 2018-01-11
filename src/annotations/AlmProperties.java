package annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface AlmProperties
{
	public String Domain();
	public String Project();
	public String Url() default "alm.corp.chartercom.com";
	public int Port () default 8080;
	public String userName();
	public String userPass();
}
