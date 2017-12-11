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
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			String sql= "select * from 普通用户";
			PreparedStatement pst ;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				if((rs.getString("密码")).equals(getPassword()) && (rs.getString("电话")).equals(un)) {
					System.out.println("密码输对了");
					if(!getNewname().equals("")) {
						sql= "update 普通用户  set 姓名 = ? where 电话 = ?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewname());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("改了名字");
					}
					if(!getNewpassword().equals("")) {
						sql= "update 普通用户  set 密码=? where 电话=?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewpassword());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("改了密码");
					}
					if(!getNewemail().equals("")) {
						sql= "update 普通用户  set 邮箱=? where 电话=?";
						pst = conn.prepareStatement(sql);
			            pst.setString(1,getNewemail());
			            pst.setString(2,un);
			            pst.executeUpdate();
			            System.out.println("改了邮箱");
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
