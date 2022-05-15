package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import dao.StudentDao;
import entity.Score;
import entity.Student;



public class AdjustServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	
    	int n=0;
    	for(int i=0;i<10;i++)
    	{
        String myanswer = req.getParameter(Integer.toString(i));
        String answer = req.getParameter(Integer.toString(i+15));
        if(myanswer.equals(answer))
        {
        	n++;
        }
    	}
    	int testscore=n*10;
    	String testscore1=String.valueOf(testscore);
    	
    	String namestr=req.getParameter("str");
    	String experimentname=req.getParameter("experimentname");
    	

        Random rand1 = new Random ();
        int a = rand1.nextInt(200);
        String n1=String.valueOf(a);
    	
    	StudentDao dao=new StudentDao();
        Student stu=new Student();
        stu=dao.selectStudent(namestr);
        String name=stu.getName();
        Score score=new Score();
        score.setId(n1);
        score.setName(name);
        score.setExperiment(experimentname);
        score.setResult(testscore1);
        
        ScoreDao dao2=new ScoreDao();
		dao2.addScore(score);
		
    	req.setAttribute("n", n);
		req.getRequestDispatcher("student/score.jsp").forward(req, resp);
	}
}
