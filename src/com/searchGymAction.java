package com;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.LoginuserAction.game;
import com.gymdetailstuffAction.facility;
import com.opensymphony.xwork2.ActionSupport;

public class searchGymAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int nameOfGym;
	private String position;
	private String price;
	private String time;
	private String tag;
	private String score;
	private String tele;
	private String name;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public class facility{
    	private String fac;
    	private String introduction;
		public String getFac() {
			return fac;
		}
		public void setFac(String fac) {
			this.fac = fac;
		}
		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		
    }
    
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(int nameOfGym) {
		this.nameOfGym = nameOfGym;
	}

	private List<facility> faclist =new ArrayList<facility>();
	
	
	public List<facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<facility> faclist) {
		this.faclist = faclist;
	}

	public String execute() throws Exception{
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
			String sql= "select * from 所有体育馆 where 编号='"+getNameOfGym()+"'";
			
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				setNameOfGym(getNameOfGym());
					setPosition(rs.getString("位置"));
					setPrice(rs.getString("价格"));
					setTime(rs.getString("时间"));
					setTag(rs.getString("标签"));
					setTele(rs.getString("联系电话"));
					setScore(String.valueOf(rs.getBigDecimal("平均得分")));	
					name=rs.getString("名称");
            }
			else {
				return ERROR;
			}

			sql= "select * from 设施信息 where 体育馆='"+name+"'";
			rs = stmt.executeQuery(sql);
			List<facility> tfaclist =new ArrayList<facility>();
			while(rs.next()){
				facility tfac=new facility();
				tfac.setFac(rs.getString("设施名称"));
				tfac.setIntroduction(rs.getString("简介"));
				tfaclist.add(tfac);
			}
			this.setFaclist(tfaclist);
			//获取所有比赛列表
			sql = "select * from 比赛信息 where 体育馆='"+name+"'";
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
