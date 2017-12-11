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
import com.searchGymAction.game;

public class scoreAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String usercomment;
	private String userscore;
	private String gym;
	private String position;
	private String price;
	private String time;
	private String peoplenum;
	private String score;
	private String tele;
	private String name;
	private String getuser;
	private String setuser;
	
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
	public class game{
    	private String data;
        private String introduce;    
        private String location;
        private String name;
        private int index;
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
     
    }
    private List<game> gamelist = new ArrayList<game>();
    
	public List<game> getGamelist() {
		return gamelist;
	}

	public void setGamelist(List<game> gamelist) {
		this.gamelist = gamelist;
	}
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
	
	
	public String getPeoplenum() {
	return peoplenum;
}

public void setPeoplenum(String peoplenum) {
	this.peoplenum = peoplenum;
}

	public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

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
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		//this.setXxx((String)session.get("username"));
		String un=this.getGetuser();
		this.setSetuser(un);
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
				ni=rs.getInt("���");
			}
			ni++;
			BigDecimal bd=new BigDecimal(getUserscore());
			sql= "select * from �������� where �û��绰='"+un+"' and ������='"+getGym()+"'";				
			int flag=-1;	
			double oldscore=0;
			rs = stmt.executeQuery(sql);
				if(!rs.next()) {//����û�����
					sql = "INSERT INTO ��������(���,�û��绰,����,����,������) VALUES(?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, ni);
					pst.setString(2,un);
			        pst.setString(3,getUsercomment());
			        pst.setBigDecimal(4,bd);
			        pst.setString(5,getGym());
			        pst.executeUpdate();
			        flag=1;
				}
				else {//�޸��û�����
					System.out.println("�û��绰:"+rs.getString("�û��绰"));
					System.out.println("����:"+rs.getString("����"));
					oldscore=Double.valueOf(String.valueOf(rs.getBigDecimal("����")));
					sql= "update ��������  set ���� = ?,����=? where �û��绰 = ? and ������=?";
					PreparedStatement pst = conn.prepareStatement(sql);
			        pst.setString(1,getUsercomment());
			        pst.setBigDecimal(2,bd);
			        pst.setString(3,un);
			        pst.setString(4,getGym());
			        pst.executeUpdate();
			        flag=0;
				}
				conn = DriverManager.getConnection(url,"root","123456");
				stmt = conn.createStatement(); //����Statement����
	            sql= "select * from ���������� where ����='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {	
					double us=Double.valueOf(getUserscore());
					double ssum=Double.valueOf(String.valueOf(rs.getBigDecimal("ƽ���÷�")));
					if(flag==1) {
						//����û�����
						ssum=ssum*(rs.getInt("��������"))+us;
						ssum=ssum/((rs.getInt("��������"))+1);
						sql= "update ����������  set �������� = ?,ƽ���÷�=? where ���� = ?";
						PreparedStatement pst = conn.prepareStatement(sql);
						bd=new BigDecimal(ssum);
			            pst.setInt(1,(rs.getInt("��������"))+1);
			            pst.setBigDecimal(2,bd);
			            pst.setString(3,getGym()); 
			            pst.executeUpdate();
					}
					else {//�޸��û�����
						ssum=ssum*(rs.getInt("��������"))+us-oldscore;
						ssum=ssum/(rs.getInt("��������"));
						sql= "update ����������  set �������� = ?,ƽ���÷�=? where ���� = ?";
						PreparedStatement pst = conn.prepareStatement(sql);
						bd=new BigDecimal(ssum);
			            pst.setInt(1,rs.getInt("��������"));
			            pst.setBigDecimal(2,bd);
			            pst.setString(3,getGym()); 
			            pst.executeUpdate();
					}
						
						
	            }
				conn = DriverManager.getConnection(url,"root","123456");
				stmt = conn.createStatement(); //����Statement����
				//��ȡ������Ϣ
				sql= "select * from ���������� where ����='"+getGym()+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					setName(getGym());
					setPosition(rs.getString("λ��"));
					setPrice(rs.getString("�۸�"));
					setTime(rs.getString("ʱ��"));
					setTele(rs.getString("��ϵ�绰"));
					setScore(String.valueOf(rs.getBigDecimal("ƽ���÷�")));	
					setPeoplenum(String.valueOf(rs.getInt("��������")));
	            }
				else {
					return ERROR;
				}
				//��ȡ��ʩ��Ϣ
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
				sql = "select * from ������Ϣ where ������='"+getGym()+"'";
				rs=stmt.executeQuery(sql);
				List<game> tlist = new ArrayList<game>();
				while(rs.next()) {
					game tgame=new game();
					tgame.setData(rs.getString("ʱ��"));
					tgame.setIndex(rs.getInt("���"));
					tgame.setIntroduce(rs.getString("����"));
					tgame.setLocation(rs.getString("�ص�"));
					tgame.setName(rs.getString("����"));
					tlist.add(tgame);
				}
				this.setGamelist(tlist);
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
