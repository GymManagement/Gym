package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimerTask;

public class CrawlTask extends TimerTask {
	private int count=0;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�ɹ���");
		/*try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ;
		}
		try {
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");	
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql= "update ��ʩ��ϸ��Ϣ set �û� = ? where ������=? and ʱ���=? and ����=?";
			PreparedStatement pst ;
			pst = conn.prepareStatement(sql);
            pst.setString(1,"hhhhh");
            pst.setString(2,"���ý���");
            pst.setInt(3, 1);
            pst.setInt(4, 1);
            pst.executeUpdate();
			try {
	            if (rs!= null) {
	              rs.close();
	            }

	            if (stmt != null) {
	              stmt.close();
	            }

	            if (conn != null) {
	              conn.close();
	            }
	          } catch (Exception e) {
	        	  System.out.print("get data error1!");
	          }
		} catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
		}
*/
	}
	

}
