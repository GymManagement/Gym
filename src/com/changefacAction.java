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
			calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
			date1=calendar.getTime(); //这个时间就是日期往后推一天的结果 
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
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driverthis!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			//更改信息
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//创建Statement对象	
			String sql= "select * from 设施信息";
			rs = stmt.executeQuery(sql);
			System.out.println("a");
			int sumnum=1;//设施信息总数量
			while(rs.next()) {
				sumnum=rs.getInt("编号");
			}
			sumnum++;
			int deletenum=0;//获取删除数量
			int[][] ordernum=new int[3][7];//获取该设备最大预定人数
			for(int i=0;i<3;i++) {
				for(int j=0;j<7;j++) {
					ordernum[i][j]=0;
				}
			}
			int maxnum=0;//最大预订人数
			sql= "select * from 设施详细信息 where 体育馆='"+nn+"' and 设施名称='"+getNewname()+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(!(rs.getString("用户").equals("可用")))
					ordernum[rs.getInt("时间段")-1][rs.getInt("日期")-1]++;
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<7;j++) {
					if(maxnum<ordernum[i][j])
						maxnum=ordernum[i][j];
				}
			}
			System.out.println("最大预订人数："+maxnum);
			sql= "select * from 设施信息 where 体育馆='"+nn+"' and 设施名称='"+getNewname()+"'";
			rs = stmt.executeQuery(sql);
			int index=0;
			if(rs.next()){//有这个设施则查询是否可更改且更改信息，如果不可更改，返回input
				System.out.println("b");
				if(!getNewnum().equals("") && !getNewnum().equals(null)) {
					if(maxnum>Integer.parseInt(getNewnum())) {//预订人数大于更改的数量
						System.out.println("c");
						addActionError("更改数量小于用户已预定数量");
						return INPUT;
					}
				}
				
				
				index=rs.getInt("编号");
				if(getNewnum().equals("") || getNewnum().equals(null)) {
					System.out.println("d");
					rs.updateString("简介", this.getNewintroduce());			
					rs.updateRow();
				}
				else if(getNewintroduce().equals("") || getNewintroduce().equals(null)) {
					System.out.println("e");
					deletenum=rs.getInt("可用数量")-Integer.parseInt(getNewnum());
					rs.updateInt("可用数量", Integer.parseInt(getNewnum()));					
					rs.updateRow();
				}
				else {
					System.out.println("f");
					deletenum=rs.getInt("可用数量")-Integer.parseInt(getNewnum());
					rs.updateInt("可用数量", Integer.parseInt(getNewnum()));
					rs.updateString("简介", this.getNewintroduce());			
					rs.updateRow();
				}
				flag=0;
            }
			else {//没有这个设施，添加这个设施信息
				System.out.println("g");
				sql = "INSERT INTO 设施信息(编号,设施名称,可用数量,体育馆,简介) VALUES(?,?,?,?,?)";    				
	            PreparedStatement pst = conn.prepareStatement(sql);
			    pst.setInt(1,sumnum);
			    pst.setString(2,getNewname());
			    pst.setInt(3,Integer.parseInt(getNewnum()));
	            pst.setString(4,nn);
	            pst.setString(5,getNewintroduce());
	            pst.executeUpdate();
	            flag=1;
			}
			//以下部分为更改，添加，或删除‘设施详细信息’表部分
			if(flag==0) {//更改信息且需要删除的信息大于0
				if(deletenum>0) {
					System.out.println("h");
					for(int i=1;i<=3;i++) {
						for(int j=1;j<=7;j++) {
							for(int k=0;k<deletenum;k++) {
								sql="delete from 设施详细信息 where 设施名称='"+getNewname()+"' and 体育馆='"+nn+"' and 用户='可用' and 时间段='"+i+"' and 日期='"+j+"' limit 1";
								stmt.executeUpdate(sql);
							}								
						}
					}	
				}
				else if(deletenum<0) {//更改信息且需要添加到设施详细信息
					int i=1;
					sql="select * from 设施详细信息";
					rs=stmt.executeQuery(sql);
					while(rs.next()) {
						i=rs.getInt("编号");
					}
					i++;
					deletenum=0-deletenum;
					for(int j=0;j<deletenum;j++) {		
						System.out.println("m");
						for(int m=1;m<=7;m++) {
							for(int n=1;n<=3;n++) {
								PreparedStatement pst;
								sql = "INSERT INTO 设施详细信息(编号,设施,日期,时间段,用户,体育馆,设施名称) VALUES(?,?,?,?,?,?,?)";    				
			                    pst = conn.prepareStatement(sql);
					            pst.setInt(1,i);
					            pst.setInt(2,index);
					            pst.setInt(3,m);
					            pst.setInt(4,n);
					            pst.setString(5,"可用");			
					            pst.setString(6,nn);
					            pst.setString(7, getNewname());
					            pst.executeUpdate();
					            i++;
							}
							
						}
						 
					}
				}
			}
			if(flag==1) {//还是在添加信息
				System.out.println("k");
				int i=1;
				sql="select * from 设施详细信息";
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					i=rs.getInt("编号");
				}
				i++;
				for(int j=0;j<Integer.parseInt(getNewnum());j++) {		
					System.out.println("m");
					for(int m=1;m<=7;m++) {
						for(int n=1;n<=3;n++) {
							PreparedStatement pst;
							sql = "INSERT INTO 设施详细信息(编号,设施,日期,时间段,用户,体育馆,设施名称) VALUES(?,?,?,?,?,?,?)";    				
		                    pst = conn.prepareStatement(sql);
				            pst.setInt(1,i);
				            pst.setInt(2,sumnum);
				            pst.setInt(3,m);
				            pst.setInt(4,n);
				            pst.setString(5,"可用");			
				            pst.setString(6,nn);
				            pst.setString(7, getNewname());
				            pst.executeUpdate();
				            i++;
						}
						
					}
					 
				}
			}
			
			//展示信息
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql= "select * from 设施信息 where 体育馆='"+nn+"'";
			rs = stmt.executeQuery(sql);
			this.setFacnum(0);
			while(rs.next()){
				facility tfac=new facility();
				tfac.setFacname(rs.getString("设施名称"));
				tfac.setIndex(rs.getInt("编号"));
				tfac.setNum(rs.getInt("可用数量"));
				tfac.setIntroduce(rs.getString("简介"));
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
