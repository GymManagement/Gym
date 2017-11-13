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
			int i=1;
			int flag=0;
			String sql="select * from ��ʩ��Ϣ";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("��ʩ����").equals(getName())) {
					flag=1;
					return LOGIN;
				}
				i++;
			}
			if(flag==0) {
				 sql = "INSERT INTO ��ʩ��Ϣ(���,��ʩ����,��������,������,ʱ���1,ʱ���2,ʱ���3) VALUES(?,?,?,?,?,?,?)";    				
		            PreparedStatement pst = conn.prepareStatement(sql);
				            pst.setInt(1,i);
				            pst.setString(2,getName());
				            pst.setInt(3, Integer.parseInt(getNum()));
				            pst.setString(4,un);
				            pst.setInt(5,Integer.parseInt(getNum()));
				            pst.setInt(6,Integer.parseInt(getNum()));
				            pst.setInt(7,Integer.parseInt(getNum()));
				            pst.executeUpdate();
			}
			i=1;
			sql="select * from ��ʩ��ϸ��Ϣ";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				i++;
			}
			PreparedStatement pst;
			for(int j=0;j<Integer.parseInt(getNum());j++) {
				 sql = "INSERT INTO ��ʩ��ϸ��Ϣ(���,����,������,ʱ���1,ʱ���2,ʱ���3,���Ʊ��) VALUES(?,?,?,?,?,?,?)";    				
		                    pst = conn.prepareStatement(sql);
				            pst.setInt(1,i+j);
				            pst.setString(2,getName());
				            pst.setString(3, un);
				            pst.setString(4,"����");
				            pst.setString(5,"����");
				            pst.setString(6,"����");
				            pst.setInt(7,j+1);
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
