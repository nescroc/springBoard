package sen.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


@Controller
public class LogoutController  {
	
	//@RequestMapping("/logout.do")	
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();

		//2. ���� ���� �� ���� ȭ������ �̵�
		return "login.jsp";
	}

}
