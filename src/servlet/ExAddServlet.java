package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExperimentDao;
import entity.Experiment;

public class ExAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String name = req.getParameter("name");
		String hour = req.getParameter("hour");
		String device=req.getParameter("device");
		String rule=req.getParameter("rule");
		String goal=req.getParameter("goal");
		String tips=req.getParameter("tips");
		String step=req.getParameter("step");
		Experiment experiment = new Experiment();
		experiment.setId(id);
		experiment.setName(name); 
		experiment.setHour(hour);
		experiment.setDevice(device);
		experiment.setRule(rule);
		experiment.setGoal(goal);
        experiment.setTips(tips);
        experiment.setStep(step);
		ExperimentDao dao = new ExperimentDao();
		dao.addExperiment(experiment);
		req.getRequestDispatcher("ExShowServlet").forward(req, resp);
	}
}