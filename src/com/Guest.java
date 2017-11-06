package com;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class Guest {  
    public String findUsername(String username){  
        String psw = null;  
        Connection con =null;  
        PreparedStatement pstmt =null;  
        ResultSet rs = null;  
        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";  
            String user ="root";  
            String password ="suju051106!";
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password);  
            System.out.println("Success connect Mysql server!");
            String sql = "select * from 普通用户 where 姓名=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, username);  
            rs = pstmt.executeQuery();  
            if(rs==null){  
                return null;  
            }  
            if(rs.next()){  
                psw=rs.getString("姓名");  
            }else{  
                psw=null;  
            }  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally {  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(con!=null)con.close();  
                }   
            catch (SQLException e) {          
                                    }  
        }  
        return psw;  
    }  
    public void addUser(String phone,String username,String email,String psw,String body,String time,int aim,int height,int weight,String exercise){  
        Connection con =null;  
        PreparedStatement pstmt =null;  
        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";   
            String user ="root";  
            String password ="suju051106!";//改为自己的用户名密码和数据库名  
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password); 
            System.out.println("Success connect Mysql server!");
            String sql = "INSERT INTO 普通用户(电话,姓名,邮箱,密码,体型,周期,目标体重,身高,体重,训练内容) VALUES(?,?,?,?,?,?,?,?,?,?)";  
            pstmt = con.prepareStatement(sql);  
            
            pstmt.setString(1, phone);
            pstmt.setString(2, username);
            pstmt.setString(3, email);
            pstmt.setString(4, psw);
            pstmt.setString(5, body);  
            pstmt.setString(6, time);
            pstmt.setInt(7, height);
            pstmt.setInt(8, weight);
            pstmt.setInt(9, aim);
            pstmt.setString(10,exercise);
            pstmt.executeUpdate();  
            
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally {  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(con!=null)con.close();  
                }   
            catch (SQLException e) {          
                                    }  
        }  
    }  
    //单独测试使用  
    public static void main(String[] args) {  
        String psw =new UserDao().findUsername("345");  
        System.out.println(psw);  
        Guest u = new Guest();  
        u.addUser("346", "346","346", "365","355","346",34,34,36,"355");  
    }  
      
}  