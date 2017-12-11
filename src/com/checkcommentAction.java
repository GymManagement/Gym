package com;
import java.sql.*;
import java.util.*;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.orderAction.facility;
public class checkcommentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private String getname;
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGetname() {
		return getname;
	}

	public void setGetname(String getname) {
		this.getname = getname;
	}
	public class order{
		private String user;
		private String comment;
		private String score;
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getScore() {
			return score;
		}
		public void setScore(String score) {
			this.score = score;
		}
		
	}
	private List<order> orderlist = new ArrayList<order>();
	
	public List<order> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<order> orderlist) {
		this.orderlist = orderlist;
	}

	public String execute() throws Exception{
		setName(getGetname());
			ActionContext ac=ActionContext.getContext();
			Map<String, Object> session=ac.getSession();
			String un=(String)session.get("username");
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
				String sql="select * from 评价评分 where 体育馆='"+getGetname()+"'";
				rs=stmt.executeQuery(sql);
				List<order> torderlist = new ArrayList<order>();
				while(rs.next()) {
					order torder=new order();
					torder.setComment(rs.getString("评价"));
					torder.setScore(String.valueOf(rs.getBigDecimal("评分")));
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
