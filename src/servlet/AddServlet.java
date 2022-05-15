package servlet;
import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.AdminDao;
import entity.Admin;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id=req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String style=req.getParameter("style");
		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(name); 
		admin.setPassword(password);
		admin.setStyle(style);
		AdminDao dao = new AdminDao();
		dao.addAdmin(admin);
		req.getRequestDispatcher("ShowServlet").forward(req, resp);
	}
}