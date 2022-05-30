package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Test;;

public class TestDao {
    public List<Test> getallTests() {
        List<Test> list = new ArrayList<Test>();
        Connection conn = DbHelper.getConnection();
        String sql = "select *from test order by cast(id as decimal)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Test test = new Test();
                test.setId(rst.getString("id"));
                test.setName(rst.getString("name"));
                test.setAcho(rst.getString("acho"));
                test.setBcho(rst.getString("bcho"));
                test.setCcho(rst.getString("ccho"));
                test.setAnswer(rst.getString("answer"));
                list.add(test);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean addTest(Test test) {
        String sql = "INSERT INTO `test`(`id`,`name`,`acho`,`bcho`,`ccho`,`answer`) VALUES (?,?,?,?,?,?)";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, test.getId());
            pst.setString(2, test.getName());
            pst.setString(3, test.getAcho());
            pst.setString(4, test.getBcho());
            pst.setString(5, test.getCcho());
            pst.setString(6, test.getAnswer());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean updateTest(Test test) {
        String sql = "UPDATE `test` SET `name`=?,`acho`=?,`bcho`=?,`ccho`=?,`answer`=? WHERE `id` = ?";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(6, test.getId());
            pst.setString(1, test.getName());
            pst.setString(2, test.getAcho());
            pst.setString(3, test.getBcho());
            pst.setString(4, test.getCcho());
            pst.setString(5, test.getAnswer());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTest(int id) {
        String sql = "delete from test where id = ?";
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

    public Test selectTest(int id) {
        Connection conn = DbHelper.getConnection();
        String sql = "select *from test where id = " + id;
        Test test = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                test = new Test();
                test.setId(rst.getString("id"));
                test.setName(rst.getString("name"));
                test.setAcho(rst.getString("acho"));
                test.setBcho(rst.getString("bcho"));
                test.setCcho(rst.getString("ccho"));
                test.setAnswer(rst.getString("answer"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

}
