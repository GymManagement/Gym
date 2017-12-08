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
			innum=i;
			if(flag==0) {
				 //sql = "INSERT INTO ��ʩ��Ϣ(���,��ʩ����,��������,������,ʱ���11,ʱ���21,ʱ���31,ʱ���41,ʱ���51,ʱ���61,ʱ���71,ʱ���12,ʱ���22,ʱ���32,ʱ���42,ʱ���52,ʱ���62,ʱ���72,ʱ���13,ʱ���23,ʱ���33,ʱ���43,ʱ���53,ʱ���63,ʱ���73) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    				
				 sql = "INSERT INTO ��ʩ��Ϣ(���,��ʩ����,��������,������) VALUES(?,?,?,?)";    				
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
			sql="select * from ��ʩ��ϸ��Ϣ";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				i++;
			}
			int k=0;
			for(int j=0;j<Integer.parseInt(getNum());j++) {			
				for(int m=1;m<=7;m++) {
					for(int n=1;n<=3;n++) {
						PreparedStatement pst;
						sql = "INSERT INTO ��ʩ��ϸ��Ϣ(���,��ʩ,����,ʱ���,�û�,������,��ʩ����) VALUES(?,?,?,?,?,?,?)";    				
	                    pst = conn.prepareStatement(sql);
			            pst.setInt(1,i+j+k);
			            pst.setInt(2,innum);
			            pst.setInt(3,m);
			            pst.setInt(4,n);
			            pst.setString(5,"����");			
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
