package in.co.online.bank.mgt.ctl;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

/**
 *   FrontCtl Implementation
 * @author Navigable Set
 *
 * @Version 1.0
 */

public class FrontCtl  extends HandlerInterceptorAdapter{
	
	

	@Autowired
	MessageSource messageSource;

	
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		  HttpSession session = request.getSession();
	        if (session.getAttribute("user") == null) {
	        	/*Cookie cookie= WebUtils.getCookie(request, "org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
	        	String locale= cookie.getValue();*/
	        	Locale locale=LocaleContextHolder.getLocale();
	        	System.out.println(locale);
	        	
	        	request.setAttribute("error", "Your session has been expired");
	            RequestDispatcher rd = request.getRequestDispatcher("/login");
	            rd.forward(request, response);
	            return false;
	        }
	        return true;
	}

}
