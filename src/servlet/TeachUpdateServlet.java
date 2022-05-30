package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import entity.Teacher;

public class TeachUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namestr = req.getParameter("namestr");

        if (namestr != null && !namestr.equals("")) {
            TeacherDao dao = new TeacherDao();
            Teacher teacher = dao.selectTeacher(namestr);
            req.setAttribute("teacher", teacher);
        }
        req.getRequestDispatcher("teacher/teacher_user_update.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String position = req.getParameter("position");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setSex(sex);
        teacher.setPosition(position);
        teacher.setAddress(address);
        teacher.setPhone(phone);


        TeacherDao dao = new TeacherDao();
        dao.updateTeacher(teacher);
        req.getRequestDispatcher("TeachShowServlet").forward(req, resp);
    }
}
