package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;

public class TeDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id"); 
		if (idStr != null && !idStr.equals("")) {
			int id = Integer.valueOf(idStr);
			TestDao dao = new TestDao();
			dao.deleteTest(id);
		}
		req.getRequestDispatcher("TeShowServlet").forward(req, resp);
	}
 
}
