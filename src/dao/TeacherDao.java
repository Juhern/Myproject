package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;

public class TeacherDao {
	public List<Teacher> getallTeachers(){ 
		List<Teacher> list = new ArrayList<Teacher>(); 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from teacher order by cast(id as decimal)"; 
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rst.getString("id")); 
				teacher.setName(rst.getString("name"));
				teacher.setAge(rst.getString("age"));
				teacher.setSex(rst.getString("sex"));
				teacher.setPosition(rst.getString("position"));
				teacher.setAddress(rst.getString("address"));
				teacher.setPhone(rst.getString("phone"));
				teacher.setNamestr(rst.getString("namestr"));
				list.add(teacher);
			}
			rst.close(); 
			pst.close(); 
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return list; 
	}
	
	public boolean addTeacher(Teacher teacher) { 
		String sql = "INSERT INTO `teacher`(`id`,`name`,`age`,`sex`,`position`,`address`,`phone`,`namestr`) VALUES (?,?,?,?,?,?,?,?)"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getAge());
			pst.setString(4, teacher.getSex());
			pst.setString(5, teacher.getPosition());
			pst.setString(6, teacher.getAddress());
			pst.setString(7, teacher.getPhone());
			pst.setString(8, teacher.getNamestr());
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateTeacher(Teacher teacher) { 
		String sql = "UPDATE `teacher` SET `age`=?,`sex`=?,`position`=?,`address`=?,`phone`=? WHERE `name`=?"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(6, teacher.getName());
			pst.setString(1, teacher.getAge());
			pst.setString(2, teacher.getSex());
			pst.setString(3, teacher.getPosition());
			pst.setString(4, teacher.getAddress());
			pst.setString(5, teacher.getPhone());
			int count = pst.executeUpdate();
			pst.close(); 
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Teacher selectTeacher(String namestr) { 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from teacher where namestr = '" +namestr+"'";
		Teacher teacher = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				teacher = new Teacher();
				teacher.setName(rst.getString("name"));
				teacher.setAge(rst.getString("age"));
				teacher.setSex(rst.getString("sex"));
				teacher.setPosition(rst.getString("position"));
				teacher.setAddress(rst.getString("address"));
				teacher.setPhone(rst.getString("phone"));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
		
	
	public Teacher selectTeachername(String namestr) { 
		Connection conn = DbHelper.getConnection();
		String sql = "select `name` from teacher where namestr = '" +namestr+"'";
		Teacher teacher = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				teacher = new Teacher();
			    teacher.setName(rst.getString("name"));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
}
