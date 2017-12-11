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


public class changegameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
//	public Connection connect;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String nameOfGym;
    private String getgym;
    
    public String getGetgym() {
		return getgym;
	}

	public void setGetgym(String getgym) {
		this.getgym = getgym;
	}

	public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
		this.nameOfGym = nameOfGym;
	}

	
	private String newname;
	private String newlocation;
	private String newdata;
	private String newintroduce;
	private String index;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewlocation() {
		return newlocation;
	}

	public void setNewlocation(String newlocation) {
		this.newlocation = newlocation;
	}

	public String getNewdata() {
		return newdata;
	}

	public void setNewdata(String newdata) {
		this.newdata = newdata;
	}

	public String getNewintroduce() {
		return newintroduce;
	}

	public void setNewintroduce(String newintroduce) {
		this.newintroduce = newintroduce;
	}
	private List<String> signup=new ArrayList<String>();
	    
	public List<String> getSignup() {
		return signup;
	}

	public void setSignup(List<String> signup) {
		this.signup = signup;
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
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String nn=this.getGetgym();
		this.setNameOfGym(nn);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			System.out.println("index:"+getIndex());
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			//更改信息
			String sql;
			PreparedStatement pst ;
			if(!this.getNewdata().equals("")) {
				sql= "update 比赛信息  set 时间 = ? where 编号 = ?";
				pst = conn.prepareStatement(sql);
	            pst.setString(1,getNewdata());
	            pst.setInt(2,Integer.parseInt(getIndex()));
	            pst.executeUpdate();
			}
			if(!this.getNewintroduce().equals("")) {
				sql= "update 比赛信息  set 内容 = ? where 编号 = ?";
				pst = conn.prepareStatement(sql);
	            pst.setString(1,getNewintroduce());
	            pst.setInt(2,Integer.parseInt(getIndex()));
	            pst.executeUpdate();
			}
			if(!this.getNewlocation().equals("")) {
				sql= "update 比赛信息  set 地点 = ? where 编号 = ?";
				pst = conn.prepareStatement(sql);
	            pst.setString(1,getNewlocation());
	            pst.setInt(2,Integer.parseInt(getIndex()));
	           
	            pst.executeUpdate();
			}
			if(!this.getNewname().equals("")) {
				sql= "update 比赛信息  set 名称 = ? where 编号 = ?";
				pst = conn.prepareStatement(sql);
	            pst.setString(1,getNewname());
	            pst.setInt(2,Integer.parseInt(getIndex()));
	            pst.executeUpdate();
	            sql= "update 报名信息  set 比赛名称 = ? where 编号 = ?";
				pst = conn.prepareStatement(sql);
	            pst.setString(1,getNewname());
	            pst.setInt(2,Integer.parseInt(getIndex()));
	            pst.executeUpdate();
			}
			
			
			
			
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			//显示比赛信息
			sql = "select * from 比赛信息 where 编号='"+getIndex()+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				setData(rs.getString("时间"));
				setIndex(String.valueOf(rs.getInt("编号")));
				setIntroduce(rs.getString("内容"));
				setLocation(rs.getString("地点"));
				setName(rs.getString("名称"));
			}
			//显示报名信息
			sql = "select * from 报名信息 where 比赛序号='"+getIndex()+"'";
			rs=stmt.executeQuery(sql);
			List<String> tstring = new ArrayList<String>();
			while(rs.next()) {
				tstring.add(rs.getString("用户"));
			}
			this.setSignup(tstring);
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



