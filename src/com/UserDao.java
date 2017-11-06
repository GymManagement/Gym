package com;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class UserDao {  
    public String findUsername(String identity){  
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
            String sql = "select * from 工作人员 where 编号=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, identity);  
            rs = pstmt.executeQuery();  
            if(rs==null){  
                return null;  
            }  
            if(rs.next()){  
                psw=rs.getString("编号");  
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
    public void addUser(String identity,String username,String email,String phone,String psw){  
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
            String sql = "INSERT INTO 力德健身工作人员(编号,姓名,邮箱,电话,密码) VALUES(?,?,?,?,?)";  
            pstmt = con.prepareStatement(sql);  
            
            pstmt.setString(1, identity);
            pstmt.setString(2, username);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, psw);  
            
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
        UserDao u = new UserDao();  
        u.addUser("346", "346","346", "365","355");  
    }  
      
}  