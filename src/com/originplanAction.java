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
import com.scoreAction.facility;

public class originplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String gym;
	private String[] date=new String[8];
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
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
    public class facility{
    	public String name;
    	public String timebegin;
    	public int date;
    	public String timeend;
    }
   
    private String[] timebegin=new String[5]; 
    private String[] timeend=new String[5]; 
	private String[][] fac=new String[5][7];
	private String[] showtimebegin=new String[5]; 
    private String[] showtimeend=new String[5]; 
	private String[][] showfac=new String[5][7];
	
	public String[] getShowtimebegin() {
		return showtimebegin;
	}

	public void setShowtimebegin(String[] showtimebegin) {
		this.showtimebegin = showtimebegin;
	}

	public String[] getShowtimeend() {
		return showtimeend;
	}

	public void setShowtimeend(String[] showtimeend) {
		this.showtimeend = showtimeend;
	}

	public String[][] getShowfac() {
		return showfac;
	}

	public void setShowfac(String[][] showfac) {
		this.showfac = showfac;
	}
	public String[] getTimebegin() {
		return timebegin;
	}
	public void setTimebegin(String[] timebegin) {
		this.timebegin = timebegin;
	}
	public String[] getTimeend() {
		return timeend;
	}
	public void setTimeend(String[] timeend) {
		this.timeend = timeend;
	}
	public String[][] getFac() {
		return fac;
	}
	public void setFac(String[][] fac) {
		this.fac = fac;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}

	public String[] getDate() {
		return date;
	}

	public void setDate(String[] date) {
		this.date = date;
	}
	class faconetime{
		public List<facility> onetime=new ArrayList<facility>();
		public void init() {
			System.out.println("长度为："+onetime.size());
		}
	}
	public String execute() throws Exception{
		//fac[0][0].init();
		//System.out.println("长："+fac[0][0].onetime.size());
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String un=this.getGetuser();
		this.setSetuser(un);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");	
			PreparedStatement pstmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
			int index=1;
			String sql= "select * from 健身计划";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				index=rs.getInt("编号");
			}
			index++;
			for(int i=0;i<5;i++) {
				for(int j=0;j<7;j++) {
					if(!fac[i][j].equals("") && !fac[i][j].equals(null)) {
						System.out.println("c");
						sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"' and 日期='"+j+"'";
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							System.out.println("a");
							rs.updateString("设施名称",(this.getFac())[i][j]);
							if(!(this.getTimebegin())[i].equals("") && !(this.getTimebegin())[i].equals(null))
								rs.updateString("开始时间", (this.getTimebegin())[i]);
							if(!(this.getTimeend())[i].equals("") && !(this.getTimeend())[i].equals(null))
								rs.updateString("结束时间", (this.getTimeend())[i]);
							rs.updateRow();
						}
						else {
							System.out.println("b");
				            sql = "INSERT INTO 健身计划(编号,开始时间,结束时间,设施名称,用户,时间段,日期) VALUES(?,?,?,?,?,?,?)";    
				            pstmt = conn.prepareStatement(sql);  
				            pstmt.setInt(1,index);
				            if(!(this.getTimebegin())[i].equals("") && !(this.getTimebegin())[i].equals(null))
				            	pstmt.setString(2,(this.getTimebegin())[i]);
				            else {
				            	sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"'";
								rs = stmt.executeQuery(sql);
								if(rs.next()) {
									pstmt.setString(2,rs.getString("开始时间"));
								}
								else {
									pstmt.setString(2,"暂无");
								}
				            }
				            if(!(this.getTimeend())[i].equals("") && !(this.getTimeend())[i].equals(null))
				            	pstmt.setString(3,(this.getTimeend())[i]);
				            else {
				            	sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"'";
								rs = stmt.executeQuery(sql);
								if(rs.next()) {
									pstmt.setString(3,rs.getString("结束时间"));
								}
								else {
									pstmt.setString(3,"暂无");
								}
				            }
				            
				            pstmt.setString(4, (this.getFac())[i][j]);  
				            pstmt.setString(5,un);
				            pstmt.setInt(6,i);
				            pstmt.setInt(7,j);
				            pstmt.executeUpdate();
				            System.out.println("e");
						}
					}
				}
			}
			for(int i=0;i<5;i++) {
				sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"'";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					if(!(this.getTimebegin())[i].equals("") && !(this.getTimebegin())[i].equals(null))
					{
						if(!rs.getString("开始时间").equals((this.getTimebegin())[i])) {
							rs.updateString("开始时间", (this.getTimebegin())[i]);
							rs.updateRow();
						}
					}
					if(!(this.getTimeend())[i].equals("") && !(this.getTimeend())[i].equals(null))
					{
						if(!rs.getString("结束时间").equals((this.getTimeend())[i])) {
							rs.updateString("结束时间", (this.getTimeend())[i]);
							rs.updateRow();
						}
					}
				}
			}
			//显示信息
			conn = DriverManager.getConnection(url,"root","123456");	
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
			String[][] tfac=new String[5][7];
			for(int i=0;i<5;i++) {
				for(int j=0;j<7;j++) {
					sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"' and 日期='"+j+"'";
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							 tfac[i][j]=rs.getString("设施名称");
						}
						else {
				            tfac[i][j]="暂无";
						}
				}
			}
			String[] tbegin=new String[5];
			String[] tend=new String[5];
			for(int i=0;i<5;i++) {
				sql= "select * from 健身计划 where 用户='"+un+"' and 时间段='"+i+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					tbegin[i]=rs.getString("开始时间");
					tend[i]=rs.getString("结束时间");
				}
			}
			this.setShowfac(tfac);
			this.setShowtimebegin(tbegin);
			this.setShowtimeend(tend);
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
			Date date1=new Date();
			String[] tempdate = new String[8];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			for(int i=0;i<8;i++) {
				calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
				date1=calendar.getTime(); //这个时间就是日期往后推一天的结果 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				tempdate[i]=formatter.format(date1);
			}						
			this.setDate(tempdate);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
			return ERROR;
		}
	}
     
}
