package com;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class usersignuponeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Connection connect;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String nameOfGym;
    private String index;
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
		this.nameOfGym = nameOfGym;
	}
	private String data;
    private String introduce;    
    private String location;
    private String name;

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		String un=(String)session.get("username");
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			//显示比赛信息
			String sql = "select * from 比赛信息 where 编号='"+Integer.parseInt(getIndex())+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				setData(rs.getString("时间"));
				setIndex(String.valueOf(rs.getInt("编号")));
				setIntroduce(rs.getString("内容"));
				setLocation(rs.getString("地点"));
				setName(rs.getString("名称"));
				setNameOfGym(rs.getString("体育馆"));
			}
			
			
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			//报名
			sql = "select * from 比赛信息 where 编号='"+Integer.parseInt(getIndex())+"'";
			rs=stmt.executeQuery(sql);
			String sname=null,sgym=null;
			if(rs.next()) {
				sname=rs.getString("名称");
				sgym=rs.getString("体育馆");
			}
			sql = "select * from 报名信息";
			rs=stmt.executeQuery(sql);
			int sum=0;
			while(rs.next()) {
				sum=rs.getInt("编号");
				if(rs.getString("用户").equals(un)) {
					return INPUT;
				}
			}
			sum++;
			PreparedStatement pstmt = null;  
            sql = "INSERT INTO 报名信息(编号,比赛名称,体育馆,比赛序号,用户) VALUES(?,?,?,?,?)";    
            pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, sum);
            pstmt.setString(2,sname);
            pstmt.setString(3,sgym);
            pstmt.setInt(4,Integer.parseInt(getIndex()));  
            pstmt.setString(5,un);
            pstmt.executeUpdate(); 
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			
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



