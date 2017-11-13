package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import com.User;

  
public class UserDaoImpl implements UserDao {  

    @Override    
    public User userLogin(String phonenum,String password) {  
        Connection conn = null;  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
        User psw = null;  

        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";   
            String user ="root";  
            String password1 ="123456";//改为自己的用户名密码和数据库名  
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
            conn = DriverManager.getConnection(url, user, password1); 
            System.out.println("Success connect Mysql server!");  
            String sql="select * from 普通用户 where 电话=? and 密码=?"; 
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, phonenum);  
            pstmt.setString(2, password);  
            rs = pstmt.executeQuery();  
            if(rs.next()){  
                psw = new User();  
                psw.setPhonenum(rs.getString("电话"));
                psw.setPassword(rs.getString("密码"));  
                
                System.out.println(psw.getPhonenum());  
                System.out.println(psw.getPassword());  
               
            }  
        } catch (SQLException e) {  
            System.out.println("登陆错误！");  
            e.printStackTrace();  
        } finally{  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(conn!=null)conn.close();  
                }   
            catch (SQLException e) {          
                                    }    
        }  
        return psw;  
    }  
    @Override
    public int userRegister(User user) {  
        int i=-1;
        Connection conn = null;  
        PreparedStatement pstmt = null;  
 

        try {  
            String driver ="com.mysql.jdbc.Driver";  
            String url ="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";   
            String user1 ="root";  
            String password1 ="suju051106!";//改为自己的用户名密码和数据库名  
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
            conn = DriverManager.getConnection(url, user1, password1); 
            System.out.println("Success connect Mysql server!");  
            String sql = "INSERT INTO 普通用户(电话,姓名,邮箱,密码,体型,周期,身高,体重,目标体重,训练内容) VALUES(?,?,?,?,?,?,?,?,?,?)";    
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, user.getPhonenum());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4, user.getPassword());  
            pstmt.setString(5,user.getBody());
            pstmt.setString(6,user.getTime());
            
            pstmt.setInt(7,user.getHeight());
            pstmt.setInt(8,user.getWeight());
            pstmt.setInt(9,user.getAim());
            pstmt.setString(10,user.getExercise());
            i = pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println("注册错误！");  
            e.printStackTrace();  
        } finally{  
            try {  
                if(pstmt!=null)pstmt.close();  
                if(conn!=null)conn.close();  
                }   
            catch (SQLException e) {          
                                    }    
        }  
        return i;  
    }  
}
  