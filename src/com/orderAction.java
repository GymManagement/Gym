package com;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scoreAction.facility;

public class orderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private String timeorder;
	private int num;
	private String gym;
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
private List<facility> faclist =new ArrayList<facility>();
	
	
	public List<facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<facility> faclist) {
		this.faclist = faclist;
	}
	public String getTimeorder() {
		return timeorder;
	}

	public void setTimeorder(String timeorder) {
		this.timeorder = timeorder;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String execute() throws Exception{
		
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //创建Statement对象	
			String sql= "select * from 设施信息 where 体育馆='"+getGym()+"' and 设施名称='"+getName()+"'";			
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				int tnum;
				if(getTimeorder().equals("时间段1")) {
					sql= "update 设施信息  set 时间段1= ? where 体育馆='"+getGym()+"' and 设施名称='"+getName()+"'";
					PreparedStatement pst = conn.prepareStatement(sql);
					tnum=rs.getInt("时间段1");
		            pst.setInt(1,tnum-1);
		            pst.executeUpdate();
		            System.out.println("这时时间段1");
				}
				else if(getTimeorder().equals("时间段2")) {
					sql= "update 设施信息  set 时间段2= ? where 体育馆='"+getGym()+"' and 设施名称='"+getName()+"'";
					PreparedStatement pst = conn.prepareStatement(sql);
					tnum=rs.getInt("时间段2");
		            pst.setInt(1,tnum-1);
		            pst.executeUpdate();
		            System.out.println("这时时间段2");
				}
				else {
					sql= "update 设施信息  set 时间段3= ? where 体育馆='"+getGym()+"' and 设施名称='"+getName()+"'";
					PreparedStatement pst = conn.prepareStatement(sql);
					tnum=rs.getInt("时间段3");
		            pst.setInt(1,tnum-1);
		            pst.executeUpdate();
		            System.out.println("这时时间段3");
				}
				
            }
			else {
				return ERROR;
			}
			int flag=0;
			sql= "select * from 设施详细信息 where 体育馆='"+getGym()+"' and 名称='"+getName()+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(getTimeorder().equals("时间段1")) {
					if((rs.getString("时间段1").equals("可用"))) {
						rs.updateString("时间段1",(String)session.get("username"));
						rs.updateRow();
						System.out.println("更新了时间段1");
						flag=1;
						break;
					}
				}
				else if(getTimeorder().equals("时间段2")) {
					if((rs.getString("时间段2").equals("可用"))) {
						rs.updateString("时间段2",(String)session.get("username"));
						rs.updateRow();
						System.out.println("更新了时间段2");
						flag=1;
						break;
					}
				}
				else {
					if((rs.getString("时间段3").equals("可用"))) {
						rs.updateString("时间段3",(String)session.get("username"));
						rs.updateRow();
						System.out.println("更新了时间段3");
						flag=1;
						break;
					}
				}
			/*	if((rs.getString(getTime())).equals("可用")) {
					rs.updateString(getTime(),(String)session.get("username"));
				}*/
				if(flag==0) {
					return ERROR;
				}
			}
			sql= "select * from 所有体育馆 where 名称='"+getGym()+"'";
			rs = stmt.executeQuery(sql);
			if(!rs.next()) {
				return ERROR;
			}
			else {					
				setPosition(rs.getString("位置"));
				setPrice(rs.getString("价格"));
				setTime(rs.getString("时间"));
				setTag(rs.getString("标签"));
				setTele(rs.getString("联系电话"));
				setScore(String.valueOf(rs.getBigDecimal("平均得分")));
            }
			sql= "select * from 设施信息 where 体育馆='"+getGym()+"'";
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
