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

public class findfacAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nameOfGym;
	private int facnum;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String finduser;
    private String findname;
    private int finddate;
    private int findtime;
    private int way;
    private String getgym;
    
	public String getGetgym() {
		return getgym;
	}

	public void setGetgym(String getgym) {
		this.getgym = getgym;
	}
    public String getFinduser() {
		return finduser;
	}

	public void setFinduser(String finduser) {
		this.finduser = finduser;
	}

	public String getFindname() {
		return findname;
	}

	public void setFindname(String findname) {
		this.findname = findname;
	}

	public int getFinddate() {
		return finddate;
	}

	public void setFinddate(int finddate) {
		this.finddate = finddate;
	}

	public int getFindtime() {
		return findtime;
	}

	public void setFindtime(int findtime) {
		this.findtime = findtime;
	}

	public int getWay() {
		return way;
	}

	public void setWay(int way) {
		this.way = way;
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
	public class result{
		private String resulttdate;
		private int resulttime;
		private String resultuser;
		private String resultfac;
		public String getResulttdate() {
			return resulttdate;
		}
		public void setResulttdate(String resulttdate) {
			this.resulttdate = resulttdate;
		}
		public int getResulttime() {
			return resulttime;
		}
		public void setResulttime(int resulttime) {
			this.resulttime = resulttime;
		}
		public String getResultuser() {
			return resultuser;
		}
		public void setResultuser(String resultuser) {
			this.resultuser = resultuser;
		}
		public String getResultfac() {
			return resultfac;
		}
		public void setResultfac(String resultfac) {
			this.resultfac = resultfac;
		}
		
	}
	private List<result> resultout = new ArrayList<result>();
	
	public List<result> getResultout() {
		return resultout;
	}

	public void setResultout(List<result> resultout) {
		this.resultout = resultout;
	}

	public String execute() throws Exception{
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
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String nn=this.getGetgym();
		this.setFacnum(0);
		this.setNameOfGym(nn);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			//查询部分
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			List<result> tout = new ArrayList<result>();
			String sql;
			if(way==1) {
				sql= "select * from 设施详细信息 where 体育馆='"+nn+"' and 设施='"+getFindname()+"'";
				System.out.println("a");
				System.out.println(getFindname());
			}
			else if(way==2) {
				 sql= "select * from 设施详细信息 where 体育馆='"+nn+"' and 日期='"+getFinddate()+"'";	
				 System.out.println("b");
				 System.out.println(getFinddate());
			}
			else if(way==3) {
				 sql= "select * from 设施详细信息 where 体育馆='"+nn+"' and 时间段='"+getFindtime()+"'";
				 System.out.println("c");
				 System.out.println(getFindtime());
			}
			else {
				sql= "select * from 设施详细信息 where 体育馆='"+nn+"' and 用户='"+getFinduser()+"'";
				System.out.println("d");
				System.out.println(getFinduser());
			}
			rs = stmt.executeQuery(sql);	
			while(rs.next()) {
				System.out.println("e");
				if(!rs.getString("用户").equals("可用")) {
					System.out.println("f");
					result tr=new result();
					tr.setResultfac(rs.getString("设施名称"));
					tr.setResulttime(rs.getInt("时间段"));
					tr.setResultuser(rs.getString("用户"));
					tr.setResulttdate(((this.getWeek()).get(rs.getInt("日期"))).getData());
					tout.add(tr);
				}
				
			}
			this.setResultout(tout);
			//输出部分
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement对象	
			sql= "select * from 设施信息 where 体育馆='"+nn+"'";
			rs = stmt.executeQuery(sql);
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
