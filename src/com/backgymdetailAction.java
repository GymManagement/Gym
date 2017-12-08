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

import com.gymdetailstuffAction.facility;
import com.opensymphony.xwork2.ActionSupport;

public class backgymdetailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
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

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
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
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //����Statement����	
			String sql= "select * from ���������� where ����='"+getGym()+"'";
			
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				setGym(getGym());
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

			sql= "select * from ��ʩ��Ϣ where ������='"+getGym()+"'";
			rs = stmt.executeQuery(sql);
			List<facility> tfaclist =new ArrayList<facility>();
			while(rs.next()){
				facility tfac=new facility();
				tfac.setFac(rs.getString("��ʩ����"));
				tfac.setIntroduction(rs.getString("���"));
				tfaclist.add(tfac);
			}
			this.setFaclist(tfaclist);
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
