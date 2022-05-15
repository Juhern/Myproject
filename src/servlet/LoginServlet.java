package servlet;

import entity.LoginMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String style=request.getParameter("type");
        LoginMgr user = new LoginMgr();
        int userType  = user.verifyUser(name, password,style);
        switch (userType) {
            case -1:
                request.getRequestDispatcher(
                        "error.jsp")
                        .forward(request, response);
                break;
            case 0:
                session.setAttribute("priv", "0");
                session.setAttribute("user", name);
                request.getRequestDispatcher("/admin/frame.jsp").forward(request,
                        response);
                break;
            case 1:
                session.setAttribute("priv", "1");
                session.setAttribute("user", name);
                request.getRequestDispatcher("/student/frame.jsp").forward(request,
                        response);
                break;
            case 2:
                session.setAttribute("priv", "2");
                session.setAttribute("user", name);
                request.getRequestDispatcher("/teacher/frame.jsp").forward(request,
                        response);
        }
    }

}
