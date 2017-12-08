package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.orderAction.facility;

public class gymplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String chooseGym;
	
	
	public String getChooseGym() {
		return chooseGym;
	}

	public void setChooseGym(String chooseGym) {
		this.chooseGym = chooseGym;
	}
//<s:select label="choosegym" list="gymname" name="chooseGym"/>
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private List<String> gymname =new ArrayList<String>();

	public List<String> getGymname() {
		return gymname;
	}

	public void setGymname(List<String> gymname) {
		this.gymname = gymname;
	}

	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		String un=(String)session.get("username");
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
			while (rs.next()){
				gymname.add(rs.getString("名称"));
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
