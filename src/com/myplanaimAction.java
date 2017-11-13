package com;
import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class myplanaimAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String height;
	private String weight;
	private String testresult;
	private String suggestfreq;
	private String aimweight;
	private String changedaimweight;
	
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
	public String getChangedaimweight() {
		return changedaimweight;
	}

	public void setChangedaimweight(String changedaimweight) {
		this.changedaimweight = changedaimweight;
	}

	public String getAimweight() {
		return aimweight;
	}

	public void setAimweight(String aimweight) {
		this.aimweight = aimweight;
	}

	public String getTestresult() {
		return testresult;
	}

	public void setTestresult(String testresult) {
		this.testresult = testresult;
	}

	public String getSuggestfreq() {
		return suggestfreq;
	}

	public void setSuggestfreq(String suggestfreq) {
		this.suggestfreq = suggestfreq;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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
			String sql= "select * from 普通用户";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				if((rs.getString("电话")).equals(un)) {
					
					sql= "update 普通用户  set 目标体重 = ? where 电话 = ?";
					PreparedStatement pst = conn.prepareStatement(sql);
					BigDecimal bd=new BigDecimal(getChangedaimweight());
		            pst.setBigDecimal(1,bd);
		            pst.setString(2,un);
		            pst.executeUpdate();
		            
		            setWeight((rs.getBigDecimal("体重")).toString());
					setHeight(rs.getBigDecimal("身高").toString());
					setTestresult(rs.getString("体型"));
					setAimweight(getChangedaimweight());
					setSuggestfreq(String.valueOf(rs.getInt("周期")));
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
