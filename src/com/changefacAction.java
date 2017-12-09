package com;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class changefacAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nameOfGym;
	private int facnum;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String newname;
    private String newnum;
    private String newintroduce;
    
    public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewnum() {
		return newnum;
	}

	public void setNewnum(String newnum) {
		this.newnum = newnum;
	}

	public String getNewintroduce() {
		return newintroduce;
	}

	public void setNewintroduce(String newintroduce) {
		this.newintroduce = newintroduce;
	}

	public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
		this.nameOfGym = nameOfGym;
	}
	
	public int getFacnum() {
		return facnum;
	}

	public void setFacnum(int facnum) {
		this.facnum = facnum;
	}

	public class facility{
    	private String facname;
    	private int index;
    	private int num;
    	private int available;
    	private String introduce;
		public String getFacname() {
			return facname;
		}
		public void setFacname(String facname) {
			this.facname = facname;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public int getAvailable() {
			return available;
		}
		public void setAvailable(int available) {
			this.available = available;
		}
    	
    }
	private List<facility> facnow =new ArrayList<facility>();


	public List<facility> getFacnow() {
		return facnow;
	}

	public void setFacnow(List<facility> facnow) {
		this.facnow = facnow;
	}
	public class weekday{
		private int index;
		private String data;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		
	}
	private List<weekday> week =new ArrayList<weekday>();

	public List<weekday> getWeek() {
		return week;
	}

	public void setWeek(List<weekday> week) {
		this.week = week;
	}

	public String execute() throws Exception{
		int flag=-1;
		Date date1=new Date();
		List<weekday> tempdate = new ArrayList<weekday>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		for(int i=0;i<8;i++) {
			weekday tw=new weekday();
			calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
			date1=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			tw.setData(formatter.format(date1));
			tw.setIndex(i);
			tempdate.add(tw);
		}					
		this.setWeek(tempdate);
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		String nn=(String)session.get("gym");
		this.setFacnum(0);
		this.setNameOfGym(nn);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
			System.out.println("Success loading Mysql Driverthis!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
			//������Ϣ
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//����Statement����	
			String sql= "select * from ��ʩ��Ϣ";
			rs = stmt.executeQuery(sql);
			System.out.println("a");
			int sumnum=1;//��ʩ��Ϣ������
			while(rs.next()) {
				sumnum=rs.getInt("���");
			}
			sumnum++;
			int deletenum=0;//��ȡɾ������
			int[][] ordernum=new int[3][7];//��ȡ���豸���Ԥ������
			for(int i=0;i<3;i++) {
				for(int j=0;j<7;j++) {
					ordernum[i][j]=0;
				}
			}
			int maxnum=0;//���Ԥ������
			sql= "select * from ��ʩ��ϸ��Ϣ where ������='"+nn+"' and ��ʩ����='"+getNewname()+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(!(rs.getString("�û�").equals("����")))
					ordernum[rs.getInt("ʱ���")-1][rs.getInt("����")-1]++;
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<7;j++) {
					if(maxnum<ordernum[i][j])
						maxnum=ordernum[i][j];
				}
			}
			System.out.println("���Ԥ��������"+maxnum);
			sql= "select * from ��ʩ��Ϣ where ������='"+nn+"' and ��ʩ����='"+getNewname()+"'";
			rs = stmt.executeQuery(sql);
			int index=0;
			if(rs.next()){//�������ʩ���ѯ�Ƿ�ɸ����Ҹ�����Ϣ��������ɸ��ģ�����input
				System.out.println("b");
				if(!getNewnum().equals("") && !getNewnum().equals(null)) {
					if(maxnum>Integer.parseInt(getNewnum())) {//Ԥ���������ڸ��ĵ�����
						System.out.println("c");
						addActionError("��������С���û���Ԥ������");
						return INPUT;
					}
				}
				
				
				index=rs.getInt("���");
				if(getNewnum().equals("") || getNewnum().equals(null)) {
					System.out.println("d");
					rs.updateString("���", this.getNewintroduce());			
					rs.updateRow();
				}
				else if(getNewintroduce().equals("") || getNewintroduce().equals(null)) {
					System.out.println("e");
					deletenum=rs.getInt("��������")-Integer.parseInt(getNewnum());
					rs.updateInt("��������", Integer.parseInt(getNewnum()));					
					rs.updateRow();
				}
				else {
					System.out.println("f");
					deletenum=rs.getInt("��������")-Integer.parseInt(getNewnum());
					rs.updateInt("��������", Integer.parseInt(getNewnum()));
					rs.updateString("���", this.getNewintroduce());			
					rs.updateRow();
				}
				flag=0;
            }
			else {//û�������ʩ����������ʩ��Ϣ
				System.out.println("g");
				sql = "INSERT INTO ��ʩ��Ϣ(���,��ʩ����,��������,������,���) VALUES(?,?,?,?,?)";    				
	            PreparedStatement pst = conn.prepareStatement(sql);
			    pst.setInt(1,sumnum);
			    pst.setString(2,getNewname());
			    pst.setInt(3,Integer.parseInt(getNewnum()));
	            pst.setString(4,nn);
	            pst.setString(5,getNewintroduce());
	            pst.executeUpdate();
	            flag=1;
			}
			//���²���Ϊ���ģ���ӣ���ɾ������ʩ��ϸ��Ϣ������
			if(flag==0) {//������Ϣ����Ҫɾ������Ϣ����0
				if(deletenum>0) {
					System.out.println("h");
					for(int i=1;i<=3;i++) {
						for(int j=1;j<=7;j++) {
							for(int k=0;k<deletenum;k++) {
								sql="delete from ��ʩ��ϸ��Ϣ where ��ʩ����='"+getNewname()+"' and ������='"+nn+"' and �û�='����' and ʱ���='"+i+"' and ����='"+j+"' limit 1";
								stmt.executeUpdate(sql);
							}								
						}
					}	
				}
				else if(deletenum<0) {//������Ϣ����Ҫ��ӵ���ʩ��ϸ��Ϣ
					int i=1;
					sql="select * from ��ʩ��ϸ��Ϣ";
					rs=stmt.executeQuery(sql);
					while(rs.next()) {
						i=rs.getInt("���");
					}
					i++;
					deletenum=0-deletenum;
					for(int j=0;j<deletenum;j++) {		
						System.out.println("m");
						for(int m=1;m<=7;m++) {
							for(int n=1;n<=3;n++) {
								PreparedStatement pst;
								sql = "INSERT INTO ��ʩ��ϸ��Ϣ(���,��ʩ,����,ʱ���,�û�,������,��ʩ����) VALUES(?,?,?,?,?,?,?)";    				
			                    pst = conn.prepareStatement(sql);
					            pst.setInt(1,i);
					            pst.setInt(2,index);
					            pst.setInt(3,m);
					            pst.setInt(4,n);
					            pst.setString(5,"����");			
					            pst.setString(6,nn);
					            pst.setString(7, getNewname());
					            pst.executeUpdate();
					            i++;
							}
							
						}
						 
					}
				}
			}
			if(flag==1) {//�����������Ϣ
				System.out.println("k");
				int i=1;
				sql="select * from ��ʩ��ϸ��Ϣ";
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					i=rs.getInt("���");
				}
				i++;
				for(int j=0;j<Integer.parseInt(getNewnum());j++) {		
					System.out.println("m");
					for(int m=1;m<=7;m++) {
						for(int n=1;n<=3;n++) {
							PreparedStatement pst;
							sql = "INSERT INTO ��ʩ��ϸ��Ϣ(���,��ʩ,����,ʱ���,�û�,������,��ʩ����) VALUES(?,?,?,?,?,?,?)";    				
		                    pst = conn.prepareStatement(sql);
				            pst.setInt(1,i);
				            pst.setInt(2,sumnum);
				            pst.setInt(3,m);
				            pst.setInt(4,n);
				            pst.setString(5,"����");			
				            pst.setString(6,nn);
				            pst.setString(7, getNewname());
				            pst.executeUpdate();
				            i++;
						}
						
					}
					 
				}
			}
			
			//չʾ��Ϣ
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql= "select * from ��ʩ��Ϣ where ������='"+nn+"'";
			rs = stmt.executeQuery(sql);
			this.setFacnum(0);
			while(rs.next()){
				facility tfac=new facility();
				tfac.setFacname(rs.getString("��ʩ����"));
				tfac.setIndex(rs.getInt("���"));
				tfac.setNum(rs.getInt("��������"));
				tfac.setIntroduce(rs.getString("���"));
				this.setFacnum(this.getFacnum()+1);
				facnow.add(tfac);
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
