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


public class usercancelsignupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Connection connect;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String nameOfGym;
    private String indexget;
    private String index;
    private String getuser;
	private String setuser;
	
	public String getSetuser() {
		return setuser;
	}

	public void setSetuser(String setuser) {
		this.setuser = setuser;
	}

	public String getGetuser() {
		return getuser;
	}

	public void setGetuser(String getuser) {
		this.getuser = getuser;
	}
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndexget() {
		return indexget;
	}

	public void setIndexget(String indexget) {
		this.indexget = indexget;
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
    private String ifjoin;
    

   	public String getIfjoin() {
   		return ifjoin;
   	}

   	public void setIfjoin(String ifjoin) {
   		this.ifjoin = ifjoin;
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
			//取消报名
			String sql = "delete from 报名信息 where 用户='"+un+"' and 比赛序号='"+Integer.parseInt(getIndexget())+"'";
			stmt.executeUpdate(sql);
			//显示比赛信息
			conn = DriverManager.getConnection(url,"root","123456");	
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql = "select * from 比赛信息 where 编号='"+Integer.parseInt(getIndexget())+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				setData(rs.getString("时间"));
				setIndex(getIndexget());
				setIntroduce(rs.getString("内容"));
				setLocation(rs.getString("地点"));
				setName(rs.getString("名称"));
				setNameOfGym(rs.getString("体育馆"));
			}
			sql = "select * from 报名信息 where 比赛序号='"+Integer.parseInt(getIndexget())+"' and 用户='"+un+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				setIfjoin("您已报名");
			}
			else {
				setIfjoin("您未报名");
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
	           return INPUT;
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



