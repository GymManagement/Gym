package com;

import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class meetingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String name;
    private String address;
    private String price;
    private String kind;
    private String time;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String execute() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("成功加载MySQL驱动程序");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/我要去健身?characterEncoding=UTF-8","root","d19970414");
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
								
					String sql= "update 所有体育馆  set 价格=?,位置=?,时间=?,设施种类=? where 名称 = ?";
					PreparedStatement pst = conn.prepareStatement(sql);
					BigDecimal bd=new BigDecimal(getPrice());
		            pst.setBigDecimal(1,bd);
		            pst.setString(2,getAddress());
		            pst.setString(3,getTime());
		            pst.setString(4,getKind());
		            pst.setString(5,getName());
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



