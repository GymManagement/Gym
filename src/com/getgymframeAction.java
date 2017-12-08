package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LoginuserAction.allgym;
import com.opensymphony.xwork2.ActionSupport;


public class getgymframeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public class allgym{
    	private int index;
    	private String name;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    	
    }
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private List<allgym> gymlist =new ArrayList<allgym>();

    public List<allgym> getGymlist() {
		return gymlist;
	}
	public void setGymlist(List<allgym> gymlist) {
		this.gymlist = gymlist;
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
			String sql= "select * from 所有体育馆";
			rs = stmt.executeQuery(sql);
			List<allgym> tgymlist =new ArrayList<allgym>();
			while (rs.next()){
				allgym tgym=new allgym();
				tgym.setIndex(rs.getInt("编号"));
				tgym.setName(rs.getString("名称"));
				tgymlist.add(tgym);
	        }
			this.setGymlist(tgymlist);
			System.out.println("个数："+gymlist.size());
			System.out.println("t的name:"+tgymlist.get(0).name);
			System.out.println("t的index:"+tgymlist.get(0).index);
			System.out.println("name:"+(this.getGymlist()).get(0).name);
			System.out.println("index:"+(this.getGymlist()).get(0).index);
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
