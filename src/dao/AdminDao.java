package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
import entity.Admin;
 
public class AdminDao {
	public List<Admin> getAllAdmin() { 
		List<Admin> list = new ArrayList<Admin>(); 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from admin order by cast(id as decimal)"; 
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Admin admin = new Admin();
				admin.setId(rst.getString("id")); 
				admin.setName(rst.getString("name"));
				admin.setPassword(rst.getString("password"));
				admin.setStyle(rst.getString("style"));
				list.add(admin);
			}
			rst.close(); 
			pst.close(); 
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return list; 
	}
 
	public boolean addAdmin(Admin admin) { 
		String sql = "INSERT INTO `admin`(`id`,`name`,`password`,`style`) VALUES (?,?,?,?)"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getId());
			pst.setString(2, admin.getName());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getStyle());
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
 
	public boolean updateAdmin(Admin admin) { 
		String sql = "UPDATE `admin` SET `name`=?,`password`=?,`style`=? WHERE `id` = ?"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getPassword());
			pst.setString(4, admin.getId()); 
			pst.setString(3, admin.getStyle());
			int count = pst.executeUpdate();
			pst.close(); 
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
 
	public boolean deleteAdmin(int id) { 
		String sql = "delete from admin where id = ?"; 
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
 
	public Admin selectAdminById(int id) { 
		Connection conn = DbHelper.getConnection();
		String sql = "select *from admin where id = " + id;
		Admin admin = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				admin = new Admin();
				admin.setId(rst.getString("id"));
				admin.setName(rst.getString("name"));
				admin.setPassword(rst.getString("password"));
				admin.setStyle(rst.getString("style"));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin; 
	}
}
