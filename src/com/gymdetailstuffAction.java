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

public class gymdetailstuffAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String position;
	private String price;
	private String time;
	private String tag;
	private String score;
	private String tele;
	private String nameOfGym;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
		this.nameOfGym = nameOfGym;
	}

	public class facility{
    	int fac;
    	int date;
    	int timereigon;
    	String user;
		public int getFac() {
			return fac;
		}
		public void setFac(int fac) {
			this.fac = fac;
		}
		public int getDate() {
			return date;
		}
		public void setDate(int date) {
			this.date = date;
		}
		public int getTimereigon() {
			return timereigon;
		}
		public void setTimereigon(int timereigon) {
			this.timereigon = timereigon;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
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


	private List<facility> faclist =new ArrayList<facility>();
	
	
	public List<facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<facility> faclist) {
		this.faclist = faclist;
	}

	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
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
			String sql= "select * from ���������� where ����='"+(String)session.get("gym")+"'";
			this.setNameOfGym((String)session.get("gym"));
			rs = stmt.executeQuery(sql);
			if(rs.next()){
					setPosition(rs.getString("λ��"));
					setPrice(rs.getString("�۸�"));
					setTime(rs.getString("ʱ��"));
					setTag(rs.getString("��ǩ"));
					setTele(rs.getString("��ϵ�绰"));
					setScore(String.valueOf(rs.getBigDecimal("ƽ���÷�")));	
            }
			else {
				return ERROR;
			}
			int[] in=new int [500];
			int x=0;
			sql= "select * from ��ʩ��Ϣ where ������='"+(String)session.get("gym")+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				in[x]=rs.getInt("���");
				x++;
			}
			for(int i=0;i<x;i++) {
				sql= "select * from ��ʩ��ϸ��Ϣ where ��ʩ='"+in[i]+"'";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					facility tfac=new facility();
					tfac.setDate(rs.getInt("����"));
					tfac.setFac(rs.getInt("��ʩ"));
					tfac.setUser(rs.getString("�û�"));
					tfac.setTimereigon(rs.getInt("ʱ���"));
					faclist.add(tfac);
	            }
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
