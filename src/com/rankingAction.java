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

public class rankingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
    public class gymscore{
    	private String score;
    	private String name;
    	private String num;
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
			String sql= "select * from ����������";
			rs = stmt.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				System.out.println("������");
				gymscore tgym=new gymscore();
				tgym.setName(rs.getString("����"));
				tgym.setScore(String.valueOf(rs.getBigDecimal("ƽ���÷�")));
				tgym.setNum(String.valueOf(rs.getInt("��������")));
				int k=0;
				for(int j=0;j<i;j++) {
					if(Double.valueOf((gymlist.get(j)).score)>Double.valueOf(tgym.score)) {
						k=j+1;
					}
				}
				gymlist.add(k,tgym);
				System.out.println("����һ��������");
				i++;
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
