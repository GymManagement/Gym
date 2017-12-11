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


public class checkgamedetailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Connection connect;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String nameOfGym;
    private int index;
    private List<String> signup=new ArrayList<String>();
    private String getgym;
    
    public String getGetgym() {
		return getgym;
	}

	public void setGetgym(String getgym) {
		this.getgym = getgym;
	}

	public List<String> getSignup() {
		return signup;
	}

	public void setSignup(List<String> signup) {
		this.signup = signup;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
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
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			//显示比赛信息
			String sql = "select * from 比赛信息 where 编号='"+getIndex()+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				setData(rs.getString("时间"));
				setIndex(rs.getInt("编号"));
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
			/*String sql = "select * from 比赛信息";
			rs=stmt.executeQuery(sql);
			int i=1;
			while(rs.next()) {
				i++;
			}
			sql = "INSERT INTO 比赛信息(编号,时间,内容,地点,报名链接) VALUES(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,i);
		    pst.setString(2,getData());
		    pst.setString(3,getIntroduce());
		    pst.setString(4,getLocation());
		    pst.setString(5,getLink());
		    //pst.setBlob(LOAD_FILE('/tmp/image.png'));
		    pst.executeUpdate();*/
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



