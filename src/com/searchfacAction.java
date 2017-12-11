package com;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.print.Printable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

public class searchfacAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String setuser;
	private String getuser;
	
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
    public class gymscore{
    	private String score;
    	private String name;
    	private String num;
    	private int index;
    	
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getScore() {
			return score;
		}
		public void setScore(String score) {
			this.score = score;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}		
    	
    }
    private List<gymscore> gymlist=new ArrayList<gymscore>();
    
	public List<gymscore> getGymlist() {
		return gymlist;
	}

	public void setGymlist(List<gymscore> gymlist) {
		this.gymlist = gymlist;
	}
	private String facneed;
	
	public String getFacneed() {
		return facneed;
	}

	public void setFacneed(String facneed) {
		this.facneed = facneed;
	}

	public String execute() throws Exception{
		this.setSetuser(this.getGetuser());
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
			List<String> right=new ArrayList<String>();
			String sql= "select * from 设施信息";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("设施名称").equals(this.getFacneed())) {
					right.add(rs.getString("体育馆"));
					break;
				}
			}
			sql= "select * from 所有体育馆";
			rs = stmt.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				System.out.println("体育馆");
				gymscore tgym=new gymscore();
				tgym.setName(rs.getString("名称"));
				tgym.setScore(String.valueOf(rs.getBigDecimal("平均得分")));
				tgym.setNum(String.valueOf(rs.getInt("评价人数")));
				tgym.setIndex(rs.getInt("编号"));
				int k=0;
				for(int j=0;j<i;j++) {
					if(Double.valueOf((gymlist.get(j)).score)>Double.valueOf(tgym.score)) {
						k=j+1;
					}
				}
				if(right.contains(rs.getString("名称"))) {
					gymlist.add(k,tgym);
					i++;
				}
				
				System.out.println("加了一个体育馆");
				
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
