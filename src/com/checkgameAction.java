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


public class checkgameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Connection connect;
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

	public class game{
    	private String data;
        private String introduce;    
        private String location;
        private String name;
        private int index;
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
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
     
    }
    private List<game> gamelist = new ArrayList<game>();
    
	public List<game> getGamelist() {
		return gamelist;
	}

	public void setGamelist(List<game> gamelist) {
		this.gamelist = gamelist;
	}
	private String newname;
	private String newlocation;
	private String newdata;
	private String newintroduce;
	
	
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
			String sql = "select * from 比赛信息 where 体育馆='"+nn+"'";
			rs=stmt.executeQuery(sql);
			List<game> tlist = new ArrayList<game>();
			while(rs.next()) {
				game tgame=new game();
				tgame.setData(rs.getString("时间"));
				tgame.setIndex(rs.getInt("编号"));
				tgame.setIntroduce(rs.getString("内容"));
				tgame.setLocation(rs.getString("地点"));
				tgame.setName(rs.getString("名称"));
				tlist.add(tgame);
			}
			this.setGamelist(tlist);
			
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



