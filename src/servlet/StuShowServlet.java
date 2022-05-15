package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import entity.Student;

public class StuShowServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		this.doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		StudentDao dao = new StudentDao();
		List<Student> list = dao.getallStudents();
		req.setAttribute("list", list);
		req.getRequestDispatcher("student/student_user_index.jsp").forward(req, resp);
	}
}
