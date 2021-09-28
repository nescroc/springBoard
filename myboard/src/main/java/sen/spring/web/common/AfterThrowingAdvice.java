package sen.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint joinPoint, Exception e) {
		String method = joinPoint.getSignature().getName();		
		System.out.println("[����ó��] :"+method+"() �޼��� ���� �� ���� �߻�. "
				+ "�޽��� : "+e.getMessage());
	}
}
