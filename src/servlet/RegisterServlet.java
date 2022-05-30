package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.StudentDao;
import entity.Admin;
import entity.Student;
import dao.TeacherDao;
import entity.Teacher;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("userage");
        String account = req.getParameter("useracount");
        String password = req.getParameter("password");
        String hstyle = req.getParameter("type");


        String style = "学生";


        if (hstyle.equals("1")) {
            style = "教师";
        } else if (hstyle.equals("0")) {
            style = "学生";
        }


        String name = req.getParameter("username");
        String userclass = req.getParameter("userclass");
        String age = req.getParameter("userage");
        String sex = req.getParameter("usersex");
        String address = req.getParameter("useraddress");
        String tel = req.getParameter("phonenum");
        String position = req.getParameter("userposition");

        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(account);
        admin.setPassword(password);
        admin.setStyle(style);
        AdminDao dao = new AdminDao();
        dao.addAdmin(admin);

        if (style.equals("学生")) {
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setSex(sex);
            student.setPosition(position);
            student.setClassname(userclass);
            student.setAddress(address);
            student.setPhone(tel);
            student.setNamestr(account);

            StudentDao daos = new StudentDao();
            daos.addStudent(student);
        } else if (style.equals("教师")) {
            Teacher teacher = new Teacher();
            teacher.setId(id);
            teacher.setName(name);
            teacher.setAge(age);
            teacher.setSex(sex);
            teacher.setPosition(position);
            teacher.setAddress(address);
            teacher.setPhone(tel);
            teacher.setNamestr(account);

            TeacherDao daot = new TeacherDao();
            daot.addTeacher(teacher);
        }


        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
