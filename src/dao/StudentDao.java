package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Student;

public class StudentDao {
    public List<Student> getallStudents() {
        List<Student> list = new ArrayList<Student>();
        Connection conn = DbHelper.getConnection();
        String sql = "select *from student order by cast(id as decimal)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Student student = new Student();
                student.setId(rst.getString("id"));
                student.setName(rst.getString("name"));
                student.setAge(rst.getString("age"));
                student.setSex(rst.getString("sex"));
                student.setPosition(rst.getString("position"));
                student.setClassname(rst.getString("classname"));
                student.setAddress(rst.getString("address"));
                student.setPhone(rst.getString("phone"));
                student.setNamestr(rst.getString("namestr"));
                list.add(student);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO `student`(`id`,`name`,`age`,`sex`,`position`,`classname`,`address`,`phone`,`namestr`) VALUES (?,?,?,?,?,?,?,?,?)";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getAge());
            pst.setString(4, student.getSex());
            pst.setString(5, student.getPosition());
            pst.setString(6, student.getClassname());
            pst.setString(7, student.getAddress());
            pst.setString(8, student.getPhone());
            pst.setString(9, student.getNamestr());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        String sql = "UPDATE `student` SET `age`=?,`sex`=?,`position`=?,`classname`=?,`address`=?,`phone`=? WHERE `name`=?";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(7, student.getName());
            pst.setString(1, student.getAge());
            pst.setString(2, student.getSex());
            pst.setString(3, student.getPosition());
            pst.setString(4, student.getClassname());
            pst.setString(5, student.getAddress());
            pst.setString(6, student.getPhone());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student selectStudent(String namestr) {
        Connection conn = DbHelper.getConnection();
        String sql = "select *from student where namestr = '" + namestr + "'";
        Student student = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                student = new Student();
                student.setName(rst.getString("name"));
                student.setAge(rst.getString("age"));
                student.setSex(rst.getString("sex"));
                student.setPosition(rst.getString("position"));
                student.setClassname(rst.getString("classname"));
                student.setAddress(rst.getString("address"));
                student.setPhone(rst.getString("phone"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public Student selectStudentname(String namestr) {
        Connection conn = DbHelper.getConnection();
        String sql = "select `name` from student where namestr = '" + namestr + "'";
        Student student = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                student = new Student();
                student.setName(rst.getString("name"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


}
