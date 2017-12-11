package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import com.gymdetailstuffAction.facility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class checkinfAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nowposition;
	private String nowprice;
	private String nowtime;
	private String nowscore;
	private int nowscorenum;
	private String nowtele;
	private String nowname;
	private String getgym;
	
	
	public String getNowposition() {
		return nowposition;
	}
	
	public String getGetgym() {
		return getgym;
	}

	public void setGetgym(String getgym) {
		this.getgym = getgym;
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
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	public String execute() throws Exception{
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String gn=this.getGetgym();
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //����Statement����	
			String sql= "select * from ���������� where ����='"+gn+"'";
			this.setNowname(gn);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
					setNowposition(rs.getString("λ��"));
					setNowprice(rs.getString("�۸�"));
					setNowtime(rs.getString("ʱ��"));
					setNowscorenum(rs.getInt("��������"));
					setNowtele(rs.getString("��ϵ�绰"));
					setNowscorenum(rs.getInt("��������"));
					setNowscore(String.valueOf(rs.getBigDecimal("ƽ���÷�")));	
            }
			else {
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



