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
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;
import com.searchGymAction.facility;

public class scoreAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String usercomment;
	private String userscore;
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
private List<facility> faclist =new ArrayList<facility>();
	
	
	public List<facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<facility> faclist) {
		this.faclist = faclist;
	}
	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}



	public String getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}

	public String getUserscore() {
		return userscore;
	}

	public void setUserscore(String userscore) {
		this.userscore = userscore;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		//this.setXxx((String)session.get("username"));
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
			String sql= "select * from ��������";				
			rs = stmt.executeQuery(sql);
			int ni=1;
			while(rs.next()) {
				ni++;
			}
			sql= "select * from �������� where �û��绰='"+(String)session.get("username")+"' and ������='"+getGym()+"'";				
				rs = stmt.executeQuery(sql);
				if(!rs.next()) {
					System.out.println("����û�����0");
					sql = "INSERT INTO ��������(���,�û��绰,����,����,������) VALUES(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, ni);
					pst.setString(2,(String)session.get("username"));
			        pst.setString(3,getUsercomment());
			        BigDecimal bd=new BigDecimal(getUserscore());
			        pst.setBigDecimal(4,bd);
			        pst.setString(5,getGym());
			        pst.executeUpdate();
			        System.out.println("����û�����");
				}
				else {
					System.out.println("�޸��û�����0");
					System.out.println("�û��绰:"+rs.getString("�û��绰"));
					System.out.println("����:"+rs.getString("����"));
					sql= "update ��������  set ���� = ?,����=? where �û��绰 = ? and ������=?";
					PreparedStatement pst = conn.prepareStatement(sql);
			        pst.setString(1,getUsercomment());
			        BigDecimal bd=new BigDecimal(getUserscore());
			        pst.setBigDecimal(2,bd);
			        pst.setString(3,(String)session.get("username"));
			        pst.setString(4,getGym());
			        pst.executeUpdate();
			        System.out.println("�޸��û�����");
				}
				conn = DriverManager.getConnection(url,"root","123456");
				stmt = conn.createStatement(); //����Statement����
	            sql= "select * from ���������� where ����='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				if(!rs.next()) {
					return ERROR;
				}
				else {					
						setPosition(rs.getString("λ��"));
						setPrice(rs.getString("�۸�"));
						setTime(rs.getString("ʱ��"));
						setTag(rs.getString("��ǩ"));
						setTele(rs.getString("��ϵ�绰"));
						double us=Double.valueOf(getUserscore());
						double ssum=Double.valueOf(String.valueOf(rs.getBigDecimal("ƽ���÷�")));
						ssum=ssum*(rs.getInt("��������"))+us;
						ssum=ssum/((rs.getInt("��������"))+1);
						setScore(String.valueOf(ssum));							
						sql= "update ����������  set �������� = ?,ƽ���÷�=? where ���� = ?";
						PreparedStatement pst = conn.prepareStatement(sql);
						BigDecimal bd=new BigDecimal(ssum);
			            pst.setInt(1,(rs.getInt("��������"))+1);
			            pst.setBigDecimal(2,bd);
			            pst.setString(3,getGym()); 
			            pst.executeUpdate();
	            }
				sql= "select * from ��ʩ��Ϣ where ������='"+getGym( )+"'";
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
