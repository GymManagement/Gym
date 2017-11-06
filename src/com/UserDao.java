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
            String url ="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";  
            String user ="root";  
            String password ="suju051106!";
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password);  
            System.out.println("Success connect Mysql server!");
            String sql = "select * from ������Ա where ���=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, identity);  
            rs = pstmt.executeQuery();  
            if(rs==null){  
                return null;  
            }  
            if(rs.next()){  
                psw=rs.getString("���");  
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
            String url ="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";   
            String user ="root";  
            String password ="suju051106!";//��Ϊ�Լ����û�����������ݿ���  
            Class.forName(driver);  
            con = DriverManager.getConnection(url, user, password); 
            System.out.println("Success connect Mysql server!");
            String sql = "INSERT INTO ���½�������Ա(���,����,����,�绰,����) VALUES(?,?,?,?,?)";  
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
    //��������ʹ��  
    public static void main(String[] args) {  
        String psw =new UserDao().findUsername("345");  
        System.out.println(psw);  
        UserDao u = new UserDao();  
        u.addUser("346", "346","346", "365","355");  
    }  
      
}  