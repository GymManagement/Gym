package com;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class deletemyorderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String getindex;
	
	public String getGetindex() {
		return getindex;
	}
	public void setGetindex(String getindex) {
		this.getindex = getindex;
	}
	public class order{
		private String gym;
		private String date;
		private String timeregion;
		private String facname;
		private String index;
		
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		public String getGym() {
			return gym;
		}
		public void setGym(String gym) {
			this.gym = gym;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTimeregion() {
			return timeregion;
		}
		public void setTimeregion(String timeregion) {
			this.timeregion = timeregion;
		}
		public String getFacname() {
			return facname;
		}
		public void setFacname(String facname) {
			this.facname = facname;
		}
		
	}
	private List<order> orderlist=new ArrayList<order>();
	
	public List<order> getOrderlist() {
		return orderlist;
	}



	public void setOrderlist(List<order> orderlist) {
		this.orderlist = orderlist;
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
		String un=(String)session.get("username");
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
		this.setName(un);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			//删除信息
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); 
			String sql= "delete from 设施详细信息 where 编号='"+Integer.parseInt(getGetindex())+"'";
			stmt.execute(sql);
			//显示信息
			stmt = conn.createStatement(); //创建Statement对象	
			sql= "select * from 设施详细信息 where 用户='"+un+"'";
			rs = stmt.executeQuery(sql);
			List<order> torderlist=new ArrayList<order>();
			while (rs.next()){
				order torder=new order();
				torder.setIndex(String.valueOf(rs.getInt("编号")));
				torder.setDate(tempdate[rs.getInt("日期")]);
				torder.setFacname(rs.getString("设施名称"));
				torder.setGym(rs.getString("体育馆"));
				if(rs.getInt("时间段")==1) {
					torder.setTimeregion("8:00~11:00");
				}
				else if(rs.getInt("时间段")==2) {
					torder.setTimeregion("12:00~15:00");
				}
				else {
					torder.setTimeregion("16:00~19:00");
				}
				torderlist.add(torder);
            }
			this.setOrderlist(torderlist);
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
