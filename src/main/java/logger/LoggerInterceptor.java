package logger;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerInterceptor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -424879825248298676L;
	private static final Logger LOGGER = LogManager
			.getLogger(LoggerInterceptor.class);

	@AroundInvoke
	public Object interceptor(InvocationContext ic) throws Exception {
		Method method = ic.getMethod();
		Object target = ic.getTarget();
		Object[] parameters = ic.getParameters();
		
		StringBuilder info = new StringBuilder();
		info.append(target.getClass().getSimpleName()).append(".");
		info.append(method.getName()).append("( ");
		for (Object o : parameters) {
			info.append("[").append(o.getClass().getSimpleName()).append("] ").append(o.toString()).append(" || ");
		}
		info.append(" )");
		LOGGER.info(info);
		return ic.proceed();
	}

}
