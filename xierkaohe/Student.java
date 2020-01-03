package xierkaohe;

import java.sql.*;
import java.util.Scanner;

public class Student {
//    public static void crete()throws SQLException{
//        String sql="CREATE DATABASE IF NOT EXISTS db1";
//        Connection conn1=Tools.getConnection1();
//        Statement st=conn1.createStatement();
//        st.executeUpdate(sql);
//        Connection conn=Tools.getConnection();
//        st=conn.createStatement();
//        sql="DROP TABLE student";
//        st.executeUpdate(sql);
//        sql="CREATE TABLE IF NOT EXISTS student(" +
//                "id VARCHAR (200)primary key ,"+
//                "name VARCHAR (200)," +
//                "banji int"+
//                ")";
//        st.executeUpdate(sql);
//        System.out.println("开始服务");
//        Tools.close(st,conn);
//        Tools.close(conn1);
//
//    }
    public static void insect(String id,String name,String banji) throws SQLException{
        Connection conn=Tools.getConnection();
        String sql1="SELECT * FROM class WHERE class = ? ";
        PreparedStatement pr= conn.prepareStatement(sql1);
        pr.setString(1,banji);
        int id_class=1;
        ResultSet rs=pr.executeQuery();
        int a=1;
        if (rs.next()){
            id_class=rs.getInt("id_class");
            a=0;
        }
        if (a==1){
            String sql2 = "INSERT INTO class(class) VALUES (?)";
            conn=Tools.getConnection();
            pr=conn.prepareStatement(sql2);

            pr.setString(1,banji);
            pr.executeUpdate();
            Tools.close(pr,conn);
        }

        Tools.close(pr,conn,rs);
        String sql = "INSERT INTO student(id,name,banji) VALUES (?,?,?)";
        conn=Tools.getConnection();
        pr=conn.prepareStatement(sql);
        pr.setString(1,id);
        pr.setString(2,name);
        pr.setInt(3,id_class);
        pr.executeUpdate();
        System.out.println("登记完成");
        Tools.close(pr,conn);
    }
    public static void update(String id,String name,String banji) throws SQLException {
        Connection conn=Tools.getConnection();
        String sql1="SELECT * FROM class WHERE class = ? ";
        PreparedStatement pr= conn.prepareStatement(sql1);
        pr.setString(1,banji);
        int id_class=1;
        ResultSet rs=pr.executeQuery();
        int a=1;
        if (rs.next()){
            id_class=rs.getInt("id_class");
            Tools.close(pr,conn,rs);
            a=0;
        }
        if (a==1){
            Tools.close(pr,conn,rs);
            String sql2 = "INSERT INTO class(class) VALUES (?)";
            conn=Tools.getConnection();
            pr=conn.prepareStatement(sql2);
            pr.setString(1,banji);
            pr.executeUpdate();
            Tools.close(pr,conn);
            conn=Tools.getConnection();
            String sql3="SELECT * FROM class WHERE class = ? ";
            pr= conn.prepareStatement(sql1);
            pr.setString(1,banji);
            rs=pr.executeQuery();
            rs.next();
            id_class=rs.getInt("id_class");
            Tools.close(pr, conn,rs);
        }


        String sql = "UPDATE student SET name= ? ,banji= ? WHERE id=?";
        conn = Tools.getConnection();
        pr = conn.prepareStatement(sql);
        pr.setString(1, name);
        pr.setInt(2, id_class);
        pr.setString(3, id);
        pr.executeUpdate();
        System.out.println("修改完成");
        Tools.close(pr, conn);
    }
    public static void remove(String id,String name,String banji) throws SQLException{
        Connection conn=Tools.getConnection();
        String sql1="SELECT * FROM class WHERE class = ? ";
        PreparedStatement pr= conn.prepareStatement(sql1);
        pr.setString(1,banji);
        int id_class=1;
        ResultSet rs=pr.executeQuery();
        rs.next();
        id_class=rs.getInt("id_class");
        Tools.close(pr,conn,rs);

        String sql="DELETE FROM student WHERE name = ? AND id= ? AND banji =? ";
        conn=Tools.getConnection();
        pr= conn.prepareStatement(sql);
        pr.setString(1,name);
        pr.setString(2,id);
        pr.setInt(3,id_class);
        pr.executeUpdate();
        System.out.println("删除完成");
        Tools.close(pr,conn);
    }
    public static void loginDo(String id) throws SQLException {

        Connection conn=Tools.getConnection();
        String sql="SELECT * FROM student WHERE id = ? ";
        PreparedStatement pr= conn.prepareStatement(sql);
        pr.setString(1,id);
        ResultSet rs=pr.executeQuery();

        int a=1;
        if (rs.next()){
            StudentLogin studentLogin=new StudentLogin();
            studentLogin.setId(rs.getString("id"));
            studentLogin.setName(rs.getString("name"));
            int banjiname =rs.getInt("banji");
            Tools.close(pr,conn,rs);
            conn=Tools.getConnection();
            String sql1="SELECT * FROM class WHERE id_class = ? ";
            pr= conn.prepareStatement(sql1);
            pr.setInt(1,banjiname);
            rs=pr.executeQuery();
            rs.next();
            String classname=rs.getString("class");


            System.out.println("名字："+studentLogin.getName()+"\t学号："+studentLogin.getId()+"\t班级："+classname);
            System.out.println("查询成功！");
            a=0;
        }
        if (a==1){
            System.out.println("查询失败！");
        }

        Tools.close(pr,conn,rs);

    }
    public static void run() throws SQLException {
        System.out.println("开始");
//        crete();
        int i;
        do {
            System.out.println("请问您要什么服务？\n1.登记\t2.查询\t3.删除\t4.修改\t5.退出");
            Scanner scanner=new Scanner(System.in);
            i=scanner.nextInt();
            if (i==1){
                System.out.println("请输入名字：");
                String name=scanner.next();
                System.out.println("请输入学号：");
                String id=scanner.next();
                System.out.println("请输入班级：");
                String banji=scanner.next();
                insect(id,name,banji);
            }else if (i==2){
                System.out.println("欢迎查询！请输入学号：");
                String id=null;
                id=scanner.next();
                loginDo(id);
            }else if (i==3){
                System.out.println("请输入名字：");
                String name=scanner.next();
                System.out.println("请输入学号：");
                String id=scanner.next();
                System.out.println("请输入班级：");
                String banji=scanner.next();
                remove(id,name,banji);
            }else if (i==4){
                System.out.println("请输入学号：");
                String id=scanner.next();
                System.out.println("请输入要修改的名字：");
                String name=scanner.next();
                System.out.println("请输入要修改的班级：");
                String banji=scanner.next();
                update(id,name,banji);
            } else if (i==5){
                System.out.println("结束！");
            }
        }while (i!=5);

    }
}
