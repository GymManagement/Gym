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
public class deleteplanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String chooseGym;
	private String[] date=new String[8];
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String[] showtimebegin=new String[5]; 
    private String[] showtimeend=new String[5]; 
	private String[][] showfac=new String[5][7];
	private String day;
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

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

	public String[] getDate() {
		return date;
	}

	public void setDate(String[] date) {
		this.date = date;
	}

	public String getChooseGym() {
		return chooseGym;
	}

	public void setChooseGym(String chooseGym) {
		this.chooseGym = chooseGym;
	}

	public String execute() throws Exception{
		
			System.out.println(getDay());
			Date date1=new Date();
			String[] tempdate = new String[8];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			for(int i=0;i<8;i++) {
				calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
				date1=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				tempdate[i]=formatter.format(date1);
			}						
			this.setDate(tempdate);
			ActionContext ac=ActionContext.getContext();
			Map<String, Object> session=ac.getSession();
			String un=(String)session.get("username");
			try {
				Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
				System.out.println("Success loading Mysql Driver!");
			}catch (Exception e) {
				return ERROR;
			}
			try {
				String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
				conn = DriverManager.getConnection(url,"root","123456");	
				PreparedStatement pstmt = null;
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
				String sql="delete from ����ƻ� where �û�='"+un+"' and ����='"+Integer.parseInt(getDay())+"'";
				stmt.execute(sql);
				conn = DriverManager.getConnection(url,"root","123456");	
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
				String[][] tfac=new String[5][7];
				for(int i=0;i<5;i++) {
					for(int j=0;j<7;j++) {
						sql= "select * from ����ƻ� where �û�='"+un+"' and ʱ���='"+i+"' and ����='"+j+"'";
							rs = stmt.executeQuery(sql);
							if(rs.next()) {
								 tfac[i][j]=rs.getString("��ʩ����");
							}
							else {
					            tfac[i][j]="����";
							}
					}
				}
				String[] tbegin=new String[5];
				String[] tend=new String[5];
				for(int i=0;i<5;i++) {
					sql= "select * from ����ƻ� where �û�='"+un+"' and ʱ���='"+i+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						tbegin[i]=rs.getString("��ʼʱ��");
						tend[i]=rs.getString("����ʱ��");
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
				
			return SUCCESS;
		  } catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
			return ERROR;
		  } 
	}
}
