package servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.AdminDao;
import entity.Admin;
 
public class UpdateServlet extends HttpServlet{  
 
    private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		String idStr = req.getParameter("id");
		if (idStr != null && !idStr.equals("")) {
			int id = Integer.valueOf(idStr);
			AdminDao dao = new AdminDao();
			Admin admin = dao.selectAdminById(id);
			req.setAttribute("admin", admin);
		}
		req.getRequestDispatcher("admin/admin_user_update.jsp").forward(req, resp);
 
	}
 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  
    	
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("name");
        String userpwd = req.getParameter("password");
        String id = req.getParameter("id");
        String style=req.getParameter("style");
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(username);
        admin.setPassword(userpwd);
        admin.setStyle(style);
        AdminDao dao = new AdminDao();
        dao.updateAdmin(admin);
        req.getRequestDispatcher("ShowServlet").forward(req, resp);
    }
    
    
 
}