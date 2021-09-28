package sen.spring.web.common;

import org.aspectj.lang.JoinPoint;

import sen.spring.web.user.UserVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint joinPoint,Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName()+" �α��� ["+user.getRole()+"]");
			}
		}
		System.out.println("[����ó��] :"+method+"() �޼��� ���ϰ� : "+returnObj.toString());
	}
}
