package sen.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint joinPoint, Exception e) {
		String method = joinPoint.getSignature().getName();		
		System.out.println("[예외처리] :"+method+"() 메서드 수행 중 예외 발생. "
				+ "메시지 : "+e.getMessage());
	}
}
