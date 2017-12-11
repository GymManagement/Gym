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
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;
import com.searchGymAction.facility;
import com.searchGymAction.game;

public class scoreAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String usercomment;
	private String userscore;
	private String gym;
	private String position;
	private String price;
	private String time;
	private String peoplenum;
	private String score;
	private String tele;
	private String name;
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
private List<facility> faclist =new ArrayList<facility>();
	
	
	public String getPeoplenum() {
	return peoplenum;
}

public void setPeoplenum(String peoplenum) {
	this.peoplenum = peoplenum;
}

	public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

	public List<facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<facility> faclist) {
		this.faclist = faclist;
	}
	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}



	public String getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}

	public String getUserscore() {
		return userscore;
	}

	public void setUserscore(String userscore) {
		this.userscore = userscore;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	public String execute() throws Exception{
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		//this.setXxx((String)session.get("username"));
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
			String sql= "select * from 评价评分";				
			rs = stmt.executeQuery(sql);
			int ni=1;
			while(rs.next()) {
				ni=rs.getInt("序号");
			}
			ni++;
			BigDecimal bd=new BigDecimal(getUserscore());
			sql= "select * from 评价评分 where 用户电话='"+un+"' and 体育馆='"+getGym()+"'";				
			int flag=-1;	
			double oldscore=0;
			rs = stmt.executeQuery(sql);
				if(!rs.next()) {//添加用户评价
					sql = "INSERT INTO 评价评分(序号,用户电话,评价,评分,体育馆) VALUES(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, ni);
					pst.setString(2,un);
			        pst.setString(3,getUsercomment());
			        pst.setBigDecimal(4,bd);
			        pst.setString(5,getGym());
			        pst.executeUpdate();
			        flag=1;
				}
				else {//修改用户评价
					System.out.println("用户电话:"+rs.getString("用户电话"));
					System.out.println("评价:"+rs.getString("评价"));
					oldscore=Double.valueOf(String.valueOf(rs.getBigDecimal("评分")));
					sql= "update 评价评分  set 评价 = ?,评分=? where 用户电话 = ? and 体育馆=?";
					PreparedStatement pst = conn.prepareStatement(sql);
			        pst.setString(1,getUsercomment());
			        pst.setBigDecimal(2,bd);
			        pst.setString(3,un);
			        pst.setString(4,getGym());
			        pst.executeUpdate();
			        flag=0;
				}
				conn = DriverManager.getConnection(url,"root","123456");
				stmt = conn.createStatement(); //创建Statement对象
	            sql= "select * from 所有体育馆 where 名称='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {	
					double us=Double.valueOf(getUserscore());
					double ssum=Double.valueOf(String.valueOf(rs.getBigDecimal("平均得分")));
					if(flag==1) {
						//添加用户评价
						ssum=ssum*(rs.getInt("评价人数"))+us;
						ssum=ssum/((rs.getInt("评价人数"))+1);
						sql= "update 所有体育馆  set 评价人数 = ?,平均得分=? where 名称 = ?";
						PreparedStatement pst = conn.prepareStatement(sql);
						bd=new BigDecimal(ssum);
			            pst.setInt(1,(rs.getInt("评价人数"))+1);
			            pst.setBigDecimal(2,bd);
			            pst.setString(3,getGym()); 
			            pst.executeUpdate();
					}
					else {//修改用户评价
						ssum=ssum*(rs.getInt("评价人数"))+us-oldscore;
						ssum=ssum/(rs.getInt("评价人数"));
						sql= "update 所有体育馆  set 评价人数 = ?,平均得分=? where 名称 = ?";
						PreparedStatement pst = conn.prepareStatement(sql);
						bd=new BigDecimal(ssum);
			            pst.setInt(1,rs.getInt("评价人数"));
			            pst.setBigDecimal(2,bd);
			            pst.setString(3,getGym()); 
			            pst.executeUpdate();
					}
						
						
	            }
				conn = DriverManager.getConnection(url,"root","123456");
				stmt = conn.createStatement(); //创建Statement对象
				//获取基本信息
				sql= "select * from 所有体育馆 where 名称='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					setName(getGym());
					setPosition(rs.getString("位置"));
					setPrice(rs.getString("价格"));
					setTime(rs.getString("时间"));
					setTele(rs.getString("联系电话"));
					setScore(String.valueOf(rs.getBigDecimal("平均得分")));	
					setPeoplenum(String.valueOf(rs.getInt("评价人数")));
	            }
				else {
					return ERROR;
				}
				//获取设施信息
				sql= "select * from 设施信息 where 体育馆='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				List<facility> tfaclist =new ArrayList<facility>();
				while(rs.next()){
					facility tfac=new facility();
					tfac.setFac(rs.getString("设施名称"));
					tfac.setIntroduction(rs.getString("简介"));
					tfaclist.add(tfac);
				}
				this.setFaclist(tfaclist);
				sql = "select * from 比赛信息 where 体育馆='"+getGym()+"'";
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
