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
            String url ="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";   
            String user ="root";  
            String password1 ="123456";//��Ϊ�Լ����û�����������ݿ���  
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
            conn = DriverManager.getConnection(url, user, password1); 
            System.out.println("Success connect Mysql server!");  
            String sql="select * from ������Ա where ���=? and ����=? and ������=?"; 
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, identity);  
            pstmt.setString(2, password);  
            pstmt.setString(3, gym);  
            rs = pstmt.executeQuery();  
            if(rs.next()){  
                psw = new Stuff();  
                psw.setIdentity(rs.getString("���"));
                psw.setPassword(rs.getString("����"));  
                psw.setGym(rs.getString("������"));
                System.out.println(psw.getIdentity());  
                System.out.println(psw.getPassword());  
               
            }  
        } catch (SQLException e) {  
            System.out.println("��½����");  
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
            String url ="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";   
            String user1 ="root";  
            String password1 ="suju051106!";//��Ϊ�Լ����û�����������ݿ���  
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
            conn = DriverManager.getConnection(url, user1, password1); 
            System.out.println("Success connect Mysql server!");  
            String sql = "INSERT INTO ������Ա(���,����,����,�绰,����,������) VALUES(?,?,?,?,?,?)";    
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, stuff.getIdentity());
            pstmt.setString(2,stuff.getUsername());
            pstmt.setString(3,stuff.getEmail());
            pstmt.setString(4,stuff.getPhonenum());  
            pstmt.setString(5,stuff.getPassword());
            pstmt.setString(6,stuff.getGym());
            i = pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println("ע�����");  
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
  