package sen.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable{
		String method = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();		
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(method +"() �޼��� ���࿡ �ɸ� �ð� : "+
				stopWatch.getTotalTimeMillis()+"(ms)��");
		return returnObj;
	}
}
