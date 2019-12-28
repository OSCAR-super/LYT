package xierkaohe;

import java.sql.*;

public class Tools {
    private static final String URL="jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
    private static final String URL1="jdbc:mysql://localhost:3306/";
    private static final String USER="root";
    private static final String PWD="123456";
    private static final String Driver="com.mysql.jdbc.Driver";
    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection1()throws SQLException {
        return DriverManager.getConnection(URL1,USER,PWD);
    }
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL,USER,PWD);
    }
    public static void close(PreparedStatement pr,Connection conn){
        try {
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement st,Connection conn){
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement pr, Connection conn, ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(pr,conn);
    }

    public static void close( Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
