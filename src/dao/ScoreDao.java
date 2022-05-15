package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Score;;

public class ScoreDao {
	public List<Score> getallScores() { 
		List<Score> list = new ArrayList<Score>(); 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from score order by cast(id as decimal)"; 
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Score score = new Score();
				score.setId(rst.getString("id")); 
				score.setName(rst.getString("name"));
				score.setExperiment(rst.getString("experiment"));
				score.setResult(rst.getString("result"));
				list.add(score);
			}
			rst.close(); 
			pst.close(); 
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return list; 
	}
	
	public boolean addScore(Score score) { 
		String sql = "INSERT INTO `score`(`id`,`name`,`experiment`,`result`) VALUES (?,?,?,?)"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, score.getId());
			pst.setString(2, score.getName());
			pst.setString(3, score.getExperiment());
			pst.setString(4, score.getResult());
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Score selectsScore(String name) { 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from admin where name ='"+name+"'" ;
		Score score = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				score = new Score();
				score.setId(rst.getString("id"));
				score.setName(rst.getString("name"));
				score.setExperiment(rst.getString("experiment"));
				score.setResult(rst.getString("result"));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score; 
	}
	
	
}
