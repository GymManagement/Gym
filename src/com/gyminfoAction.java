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
    private String name;
    private String address;
    private String price;
    private String kind;
    private String time;
    private String tag;
    private String tele;
    
    public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			String sql="select * from 所有体育馆";
			rs = stmt.executeQuery(sql);
			int flag=0;
			int i=1;
			while (rs.next()){
				if(rs.getString("名称").equals(getName())) {
					flag=1;
					ActionContext ac=ActionContext.getContext();
					Map<String, Object> session=ac.getSession();
					sql= "update 所有体育馆  set 价格=?,位置=?,时间=?,设施种类=?,名称=? where 名称 ='"+(String)session.get("gym")+"'";
					PreparedStatement pst = conn.prepareStatement(sql);
		            pst.setString(1,getPrice());
		            pst.setString(2,getAddress());
		            pst.setString(3,getTime());
		            pst.setString(4,getKind());
		            pst.setString(5,getName());
		            pst.executeUpdate();
		            break;
				}	
				i++;
			}
			if(flag==0) {
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



