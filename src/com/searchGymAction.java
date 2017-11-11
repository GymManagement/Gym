package com;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class searchGymAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nameOfGym;
	private String position;
	private String price;
	private String time;
	private String tag;
	private String score;
	private String tele;
	
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public class facility{
    	String name;
    	int num;
    	int time1;
    	int time2;
    	int time3;
    	
		public int getTime1() {
			return time1;
		}
		public void setTime1(int time1) {
			this.time1 = time1;
		}
		public int getTime2() {
			return time2;
		}
		public void setTime2(int time2) {
			this.time2 = time2;
		}
		public int getTime3() {
			return time3;
		}
		public void setTime3(int time3) {
			this.time3 = time3;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
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

	public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
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
			String sql= "select * from 所有体育馆 where 名称='"+getNameOfGym()+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
					setPosition(rs.getString("位置"));
					setPrice(rs.getString("价格"));
					setTime(rs.getString("时间"));
					setTag(rs.getString("标签"));
					setTele(rs.getString("联系电话"));
					setScore(String.valueOf(rs.getBigDecimal("平均得分")));	
            }
			else {
				return ERROR;
			}
			sql= "select * from 设施信息 where 体育馆='"+getNameOfGym()+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				facility tfac=new facility();
				tfac.setName(rs.getString("设施名称"));
				tfac.setNum( Integer.parseInt(rs.getString("可用数量")));
				tfac.setTime1(rs.getInt("时间段1"));
				tfac.setTime2(rs.getInt("时间段2"));
				tfac.setTime3(rs.getInt("时间段3"));
				faclist.add(tfac);
            }
			if(faclist.size()==0) {
				return ERROR;
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
