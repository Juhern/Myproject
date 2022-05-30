package dao;

import java.sql.*;

public class DbHelper {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/myproject?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT";
    private static String userName = "root";
    private static String passWord = "huangzhihui@11";
    private static Connection conn = null;

    private DbHelper() {

    }

    public static Connection getConnection() {
        if (null == conn) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        System.err.println(getConnection());
    }

}
