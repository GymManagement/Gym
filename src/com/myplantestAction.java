package com;
import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class myplantestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String height;
	private String weight;
	private String testresult;
	private String suggestfreq;
	private String aimweight;
	private String changedweight;
	private String changedheight;
	private String setuser;
	private String getuser;
	
	public String getSetuser() {
		return setuser;
	}

	public void setSetuser(String setuser) {
		this.setuser = setuser;
	}

	public String getGetuser() {
		return getuser;
	}

	public void setGetuser(String getuser) {
		this.getuser = getuser;
	}
	
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
	

	public String getChangedweight() {
		return changedweight;
	}

	public void setChangedweight(String changedweight) {
		this.changedweight = changedweight;
	}



	public String getChangedheight() {
		return changedheight;
	}

	public void setChangedheight(String changedheight) {
		this.changedheight = changedheight;
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
	//	ActionContext ac=ActionContext.getContext();
	//	Map<String, Object> session=ac.getSession();
		 
		String un=this.getGetuser();
		this.setSetuser(un);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			System.out.println("�ٺٺ�");
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //����Statement����	
			String sql= "select * from ��ͨ�û�";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				if((rs.getString("�绰")).equals(un)) {
					sql= "update ��ͨ�û�  set ���� = ? where �绰 = ?";
					PreparedStatement pst = conn.prepareStatement(sql);
					BigDecimal bd=new BigDecimal(getChangedweight());
		            pst.setBigDecimal(1,bd);
		            pst.setString(2,un);
		            pst.executeUpdate();
		            sql= "update ��ͨ�û�  set ��� = ? where �绰 = ?";
					pst = conn.prepareStatement(sql);
					bd=new BigDecimal(getChangedheight());
		            pst.setBigDecimal(1,bd);
		            pst.setString(2,un);
		            pst.executeUpdate();
		            System.out.println("�ؿ�1");
			
		            
		            setWeight(getChangedweight());
					setHeight(getChangedheight());					
					setAimweight(rs.getBigDecimal("Ŀ������").toString());
					System.out.println("�ؿ�2");
					double bmi;
					bmi=(Double.valueOf(getChangedweight()))/(Double.valueOf(getChangedheight())*Double.valueOf(getChangedheight()));
					String r=null;
					int t;
					if(bmi<=18.4) {
						r="ƫ��";
						t=4;
					}
					else if(bmi>=18.5 && bmi<=23.9) {
						r="����";
						t=3;
					}
					else if(bmi>=24.0 && bmi<=27.9) {
						r="ƫ��";
						t=2;
					}
					else {
						r="����";
						t=1;
					}
					System.out.println("r:"+r+" t:"+t);
					setTestresult(r);
					setSuggestfreq(String.valueOf(t));
					System.out.println("�ؿ�3");
					sql= "update ��ͨ�û�  set ���� = ? where �绰 = ?";
					pst = conn.prepareStatement(sql);
		            pst.setString(1,r);
		            pst.setString(2,un);
		            pst.executeUpdate();
		            sql= "update ��ͨ�û�  set ���� = ? where �绰 = ?";
					pst = conn.prepareStatement(sql);
		            pst.setInt(1,t);
		            pst.setString(2,un);
		            pst.executeUpdate();
		            System.out.println("�ؿ�4");
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
