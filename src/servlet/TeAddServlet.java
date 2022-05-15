package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import entity.Test;

public class TeAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id=req.getParameter("id");
		String name = req.getParameter("name");
		String acho = req.getParameter("acho");
		String bcho=  req.getParameter("bcho");
		String ccho=  req.getParameter("ccho");
		String answer=  req.getParameter("answer");
		Test test = new Test();
        test.setId(id);
		test.setName(name); 
		test.setAcho(acho);
		test.setBcho(bcho);
		test.setCcho(ccho);
		test.setAnswer(answer);
		TestDao dao = new TestDao();
		dao.addTest(test);
		req.getRequestDispatcher("TeShowServlet").forward(req, resp);
	}
}
