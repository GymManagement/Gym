package com;
import java.sql.*;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class changeInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String password;
	private String newpassword;
	private String newname;
	private String newemail;
	private String username;
	private String setuser;
	private String getuser;
	
	
	public String getGetuser() {
		return getuser;
	}

	public void setGetuser(String getuser) {
		this.getuser = getuser;
	}



	public String getSetuser() {
		return setuser;
	}

	public void setSetuser(String setuser) {
		this.setuser = setuser;
	}

	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewemail() {
		return newemail;
	}

	public void setNewemail(String newemail) {
		this.newemail = newemail;
	}

	public String execute() throws Exception{
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String un=this.getGetuser();
		this.setSetuser(un);
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
			String sql= "select * from ��ͨ�û�";
			PreparedStatement pst ;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				if((rs.getString("����")).equals(getPassword()) && (rs.getString("�绰")).equals(un)) {
					System.out.println("���������");
					if(!getNewname().equals("")) {
						sql= "update ��ͨ�û�  set ���� = ? where �绰 = ?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewname());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("��������");
					}
					if(!getNewpassword().equals("")) {
						sql= "update ��ͨ�û�  set ����=? where �绰=?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewpassword());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("��������");
					}
					if(!getNewemail().equals("")) {
						sql= "update ��ͨ�û�  set ����=? where �绰=?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewemail());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("��������");
					}
				}
            }
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
