package com;
import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class facinumAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String num;
	private String name;

	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;


	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		String un=(String)session.get("gym");
		int innum=0;
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
			int i=1;
			int flag=0;
			String sql="select * from 设施信息";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("设施名称").equals(getName())) {
					flag=1;
					return LOGIN;
				}
				i++;
			}
			innum=i;
			if(flag==0) {
				 //sql = "INSERT INTO 设施信息(编号,设施名称,可用数量,体育馆,时间段11,时间段21,时间段31,时间段41,时间段51,时间段61,时间段71,时间段12,时间段22,时间段32,时间段42,时间段52,时间段62,时间段72,时间段13,时间段23,时间段33,时间段43,时间段53,时间段63,时间段73) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    				
				 sql = "INSERT INTO 设施信息(编号,设施名称,可用数量,体育馆) VALUES(?,?,?,?)";    				
		            PreparedStatement pst = conn.prepareStatement(sql);
				            pst.setInt(1,i);
				            pst.setString(2,getName());
				            pst.setInt(3, Integer.parseInt(getNum()));
				            pst.setString(4,un);
				         /*   pst.setInt(5,Integer.parseInt(getNum()));
				            pst.setInt(6,Integer.parseInt(getNum()));
				            pst.setInt(7,Integer.parseInt(getNum()));
				            pst.setInt(8,Integer.parseInt(getNum()));
				            pst.setInt(9,Integer.parseInt(getNum()));
				            pst.setInt(10,Integer.parseInt(getNum()));
				            pst.setInt(11,Integer.parseInt(getNum()));
				            pst.setInt(12,Integer.parseInt(getNum()));
				            pst.setInt(13,Integer.parseInt(getNum()));
				            pst.setInt(14,Integer.parseInt(getNum()));
				            pst.setInt(15,Integer.parseInt(getNum()));
				            pst.setInt(16,Integer.parseInt(getNum()));
				            pst.setInt(17,Integer.parseInt(getNum()));
				            pst.setInt(18,Integer.parseInt(getNum()));
				            pst.setInt(19,Integer.parseInt(getNum()));
				            pst.setInt(20,Integer.parseInt(getNum()));
				            pst.setInt(21,Integer.parseInt(getNum()));
				            pst.setInt(22,Integer.parseInt(getNum()));
				            pst.setInt(23,Integer.parseInt(getNum()));
				            pst.setInt(24,Integer.parseInt(getNum()));
				            pst.setInt(25,Integer.parseInt(getNum()));*/
				            pst.executeUpdate();
			}
			i=1;
			sql="select * from 设施详细信息";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				i++;
			}
			int k=0;
			for(int j=0;j<Integer.parseInt(getNum());j++) {			
				for(int m=1;m<=7;m++) {
					for(int n=1;n<=3;n++) {
						PreparedStatement pst;
						sql = "INSERT INTO 设施详细信息(编号,设施,日期,时间段,用户,体育馆,设施名称) VALUES(?,?,?,?,?,?,?)";    				
	                    pst = conn.prepareStatement(sql);
			            pst.setInt(1,i+j+k);
			            pst.setInt(2,innum);
			            pst.setInt(3,m);
			            pst.setInt(4,n);
			            pst.setString(5,"可用");			
			            pst.setString(6,un);
			            pst.setString(7, getName());
			            pst.executeUpdate();
			            k++;
					}
					
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
