package com;
import java.sql.*;
public class connect {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
      //Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
    	String url="jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf8&useSSL=false";
      Connection connect = DriverManager.getConnection(
          url,"root","suju051106!");
           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      ResultSet rs = stmt.executeQuery("select * from book");
                                                              //user Ϊ��������
	while (rs.next()) {
	        System.out.println(rs.getString("Title"));
	      }
    }catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }


}