package com;

import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class gyminfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
 //   private String newname;
    private String newposition;
    private String newprice;
    private String newtime;
    private String newtele;
    private String nowposition;
	private String nowprice;
	private String nowtime;
	private String nowscore;
	private int nowscorenum;
	private String nowtele;
	private String nowname;
	
	
	public String getNowposition() {
		return nowposition;
	}
	public void setNowposition(String nowposition) {
		this.nowposition = nowposition;
	}
	public String getNowprice() {
		return nowprice;
	}
	public void setNowprice(String nowprice) {
		this.nowprice = nowprice;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	public String getNowscore() {
		return nowscore;
	}
	public void setNowscore(String nowscore) {
		this.nowscore = nowscore;
	}
	public int getNowscorenum() {
		return nowscorenum;
	}
	public void setNowscorenum(int nowscorenum) {
		this.nowscorenum = nowscorenum;
	}
	public String getNowtele() {
		return nowtele;
	}
	public void setNowtele(String nowtele) {
		this.nowtele = nowtele;
	}
	public String getNowname() {
		return nowname;
	}
	public void setNowname(String nowname) {
		this.nowname = nowname;
	}
	/*public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}*/

	public String getNewposition() {
		return newposition;
	}

	public void setNewposition(String newposition) {
		this.newposition = newposition;
	}

	public String getNewprice() {
		return newprice;
	}

	public void setNewprice(String newprice) {
		this.newprice = newprice;
	}

	public String getNewtime() {
		return newtime;
	}

	public void setNewtime(String newtime) {
		this.newtime = newtime;
	}

	public String getNewtele() {
		return newtele;
	}

	public void setNewtele(String newtele) {
		this.newtele = newtele;
	}

	public String execute() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("成功加载MySQL驱动程序");
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			ActionContext ac=ActionContext.getContext();
			Map<String, Object> session=ac.getSession();
			String nn=(String)session.get("gym");
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //创建Statement对象	
		/*	String sql="select * from 所有体育馆 where 名称='"+getNewname()+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("该体育馆名已被占用");
				return INPUT;
			}*/
			String sql="select * from 所有体育馆 where 名称='"+nn+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
			/*	if(!(getNewname().equals(null))) {
					rs.updateString("名称", getNewname());
					rs.updateRow();
				}	*/				
				if(!(getNewposition().equals(null)) && !(getNewposition().equals(""))) {
					rs.updateString("位置", getNewposition());
					rs.updateRow();
				}					
			}
			sql="select * from 所有体育馆 where 名称='"+nn+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {			
				if(!(getNewprice().equals(null)) && !(getNewprice().equals(""))) {
					rs.updateString("价格", getNewprice());
					rs.updateRow();
				}
			}
			sql="select * from 所有体育馆 where 名称='"+nn+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(!(getNewtele().equals(null)) && !(getNewtele().equals(""))) {
					rs.updateString("联系电话", getNewtele());
					rs.updateRow();
				}
			}
			sql="select * from 所有体育馆 where 名称='"+nn+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(!(getNewtime().equals(null)) && !(getNewtime().equals(""))) {
					rs.updateString("时间", getNewtime());
					rs.updateRow();
				}
			}
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//创建Statement对象	
			sql= "select * from 所有体育馆 where 名称='"+(String)session.get("gym")+"'";
			this.setNowname((String)session.get("gym"));
			rs = stmt.executeQuery(sql);
			if(rs.next()){
					setNowposition(rs.getString("位置"));
					setNowprice(rs.getString("价格"));
					setNowtime(rs.getString("时间"));
					setNowscorenum(rs.getInt("评价人数"));
					setNowtele(rs.getString("联系电话"));
					setNowscore(String.valueOf(rs.getBigDecimal("平均得分")));	
					setNowscorenum(rs.getInt("评价人数"));
            }
			else {
				return ERROR;
			}
					/*sql= "update 所有体育馆  set 价格=?,位置=?,时间=?,设施种类=?,名称=? where 名称 ='"+(String)session.get("gym")+"'";
					PreparedStatement pst = conn.prepareStatement(sql);
		            pst.setString(1,getPrice());
		            pst.setString(2,getAddress());
		            pst.setString(3,getTime());
		            pst.setString(4,getKind());
		            pst.setString(5,getName());
		            pst.executeUpdate();*/
			/*if(flag==0) {
				sql = "INSERT INTO 所有体育馆(编号,名称,价格,位置,时间,设施种类,标签,平均得分,联系电话,评价人数) VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setInt(1,i);
	            pst.setString(2,getName());
	            pst.setString(3,getPrice());
	            pst.setString(4,getAddress());
	            pst.setString(5,getTime());
	            pst.setString(6,getKind());
	            pst.setString(7,getTag());
	            BigDecimal bd=new BigDecimal(0);
	            pst.setBigDecimal(8,bd);
	            pst.setString(9,getTele());
	            pst.setInt(10,0);
	            pst.executeUpdate();
			}*/
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



