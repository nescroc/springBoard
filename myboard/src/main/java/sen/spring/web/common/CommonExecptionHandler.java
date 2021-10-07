package sen.spring.web.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("sen.spring.web")
public class CommonExecptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handlerArithmeticException(Exception e) {
		ModelAndView mav=  new ModelAndView();
		mav.addObject("exception",e);
		//mav.setViewName("/common/arithmeticError.jsp");
		mav.setViewName("/common/error.jsp");
		return mav;
	}
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlerNullPointException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		//mav.setViewName("/common/nullPointerError.jsp");
		mav.setViewName("/common/error.jsp");
		return mav;		
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
}
