package sen.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sen.spring.web.user.impl.UserDAO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("�α��� ȭ�� ó�� : Method=GET");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo,HttpSession session) {
		System.out.println("�α��� ���� ó�� : Method=POST");
		UserVO user = userService.getUser(vo);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else {
			return "login.jsp";
			}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("LoginController : �α׾ƿ� ó��");
		session.invalidate();

		// 2. ���� ���� �� ���� ȭ������ �̵�
		return "login.jsp";
	}
}
