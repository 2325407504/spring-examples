/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.StopWatch;

/**
 * A simple aspect used to log method times out.
 * 
 * @author cdelashmutt
 */
@Order(value=Ordered.HIGHEST_PRECEDENCE)
public class MethodTimingAspect
implements Ordered
{
	private final static Logger log = Logger.getLogger(MethodTimingAspect.class);
	
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

	/* (non-Javadoc)
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder()
	{
		// TODO Auto-generated method stub
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
