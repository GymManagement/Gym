package com;

import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class getgameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Connection connect;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String data;
    private String introduce;    
    private String location;
    private String link;
    
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String execute() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("�ɹ�����MySQL��������");
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //����Statement����	
			String sql = "select * from ������Ϣ";
			rs=stmt.executeQuery(sql);
			int i=1;
			while(rs.next()) {
				i++;
			}
			sql = "INSERT INTO ������Ϣ(���,ʱ��,����,�ص�,��������) VALUES(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,i);
		    pst.setString(2,getData());
		    pst.setString(3,getIntroduce());
		    pst.setString(4,getLocation());
		    pst.setString(5,getLink());
		    //pst.setBlob(LOAD_FILE('/tmp/image.png'));
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
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
			return ERROR;
		}
	}
	}



