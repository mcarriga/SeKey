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
	public String Url() default "";
	public int Port () default 1234;
	public String userName() default "";
	public String userPass() default "";
}
