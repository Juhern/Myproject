package util;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	private static final String[] dir =
		{    "/admin",
			 "/student",
			 "/teacher"	
	};
	
	public  MyFilter() {
		// TODO 自动生成的构造函数存根
	}
    
    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = (req).getSession();
		String user = (String) session.getAttribute("user");
		String priv = (String) session.getAttribute("priv");
		String url = req.getRequestURI().substring(
				req.getContextPath().length());
		for (int i = 0; i < dir.length; i++) {
			if (url.startsWith(dir[i])) {
				if (user == null) {
					request.getRequestDispatcher("/index.jsp")
							.forward(request, response);
				} else if (Integer.parseInt(priv) != i) {
					request.getRequestDispatcher("/error.jsp").forward(
							request, response);
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
