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
		System.out.println(method +"() 메서드 수행에 걸린 시간 : "+
				stopWatch.getTotalTimeMillis()+"(ms)초");
		return returnObj;
	}
}
