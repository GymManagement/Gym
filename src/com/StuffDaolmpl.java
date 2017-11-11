package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import com.Stuff;

  
public class StuffDaolmpl implements StuffDao {  

    @Override    
    public Stuff stuffLogin(String identity,String password,String gym) {  
        Connection conn = null;  
        PreparedStatement pstmt = null;  
        ResultSet rs = null;  
        Stuff psw = null;  

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
            String sql="select * from 工作人员 where 编号=? and 密码=? and 体育馆=?"; 
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, identity);  
            pstmt.setString(2, password);  
            pstmt.setString(3, gym);  
            rs = pstmt.executeQuery();  
            if(rs.next()){  
                psw = new Stuff();  
                psw.setIdentity(rs.getString("编号"));
                psw.setPassword(rs.getString("密码"));  
                psw.setGym(rs.getString("体育馆"));
                System.out.println(psw.getIdentity());  
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
    public int stuffRegister(Stuff stuff) {  
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
            String sql = "INSERT INTO 工作人员(编号,姓名,邮箱,电话,密码,体育馆) VALUES(?,?,?,?,?,?)";    
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, stuff.getIdentity());
            pstmt.setString(2,stuff.getUsername());
            pstmt.setString(3,stuff.getEmail());
            pstmt.setString(4,stuff.getPhonenum());  
            pstmt.setString(5,stuff.getPassword());
            pstmt.setString(6,stuff.getGym());
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
  