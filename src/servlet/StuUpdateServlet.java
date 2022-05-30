package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import entity.Student;

public class StuUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namestr = req.getParameter("namestr");

        if (namestr != null && !namestr.equals("")) {
            StudentDao dao = new StudentDao();
            Student student = dao.selectStudent(namestr);
            req.setAttribute("student", student);
        }
        req.getRequestDispatcher("student/student_user_update.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String position = req.getParameter("position");
        String classname = req.getParameter("classname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setPosition(position);
        student.setClassname(classname);
        student.setAddress(address);
        student.setPhone(phone);


        StudentDao dao = new StudentDao();
        dao.updateStudent(student);
        req.getRequestDispatcher("StuShowServlet").forward(req, resp);
    }
}
