package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Experiment;

public class ExperimentDao {
    public List<Experiment> getAllExperiment() {
        List<Experiment> list = new ArrayList<Experiment>();
        Connection conn = DbHelper.getConnection();
        String sql = "select *from experiment order by cast(id as decimal)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rst.getString("id"));
                experiment.setName(rst.getString("name"));
                experiment.setHour(rst.getString("hour"));
                experiment.setDevice(rst.getString("device"));
                experiment.setRule(rst.getString("rule"));
                experiment.setGoal(rst.getString("goal"));
                experiment.setTips(rst.getString("tips"));
                experiment.setStep(rst.getString("step"));
                list.add(experiment);
            }
            rst.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean addExperiment(Experiment experiment) {
        String sql = "INSERT INTO `experiment`(`id`,`name`,`hour`,`device`,`rule`,`goal`,`tips`,`step`) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, experiment.getId());
            pst.setString(2, experiment.getName());
            pst.setString(3, experiment.getHour());
            pst.setString(4, experiment.getDevice());
            pst.setString(5, experiment.getRule());
            pst.setString(6, experiment.getGoal());
            pst.setString(7, experiment.getTips());
            pst.setString(8, experiment.getStep());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateExperiment(Experiment experiment) {
        String sql = "UPDATE `experiment` SET `name`=?,`hour`=?,`device`=?,`rule`=?,`goal`=?,`tips`=?,`step`=? WHERE `id` = ?";
        Connection conn = DbHelper.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, experiment.getName());
            pst.setString(2, experiment.getHour());
            pst.setString(3, experiment.getDevice());
            pst.setString(4, experiment.getRule());
            pst.setString(5, experiment.getGoal());
            pst.setString(6, experiment.getTips());
            pst.setString(7, experiment.getStep());
            pst.setString(8, experiment.getId());
            int count = pst.executeUpdate();
            System.out.println(count);
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteExperiment(int id) {
        String sql = "delete from experiment where id = ?";
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

    public Experiment selectExperiment(int id) {
        Connection conn = DbHelper.getConnection();
        String sql = "select *from experiment where id = " + id;
        Experiment experiment = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                experiment = new Experiment();
                experiment.setId(rst.getString("id"));
                experiment.setName(rst.getString("name"));
                experiment.setHour(rst.getString("hour"));
                experiment.setDevice(rst.getString("device"));
                experiment.setRule(rst.getString("rule"));
                experiment.setGoal(rst.getString("goal"));
                experiment.setTips(rst.getString("tips"));
                experiment.setStep(rst.getString("step"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return experiment;
    }

}
