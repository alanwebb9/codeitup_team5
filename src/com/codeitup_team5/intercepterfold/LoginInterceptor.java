package com.codeitup_team5.intercepterfold;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截�?
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		// URL:除了登录请求外，其他的URL都进行拦截||控制
		if (url.indexOf("/login.action") >= 0||url.indexOf("/sign.action") >= 0||url.indexOf("/creatUser.action") >= 0) {
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		//Admin admin = (Admin) session.getAttribute("USER_SESSION");
	
		// 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
		//if (admin != null) {
		//	return true;
		//}
		// 不符合条件的给出提示信息，并转发到登录页�?
		request.setAttribute("msg", "You need to login！");
		request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp")
		                                        .forward(request, response);
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("execute PermessionInterceptor --- postHandler() ---");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("execute PermessionInterceptor --- afterCompletion() ---");
	}
}
