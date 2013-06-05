/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.jdbctemplate;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * A simple aspect used to log method times out.
 * 
 * @author cdelashmutt
 */
@Component
@Aspect
public class MethodTimingAspect
{
	private final static Logger log = Logger.getLogger(MethodTimingAspect.class);
	
	@Around("execution(* gopivotal.examples.spring.jdbctemplate.PersonService.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint)
	throws Throwable
	{
		StopWatch sw = new StopWatch();
		if(log.isTraceEnabled())
		{
			log.trace("Starting method call: " + joinPoint.getSignature().toShortString());
			sw.start();
		}
		Object returnValue = joinPoint.proceed();
		if(log.isTraceEnabled())
		{
			log.trace("Ending method call: " + joinPoint.getSignature().toShortString());
			sw.stop();
			log.trace("Method took (ms): " + sw.getTotalTimeMillis());
		}
		return returnValue;
	}
}
