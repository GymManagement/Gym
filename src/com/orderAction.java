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

public class orderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//private int gym;
	private String gymname;
	private String[] week=new String[8];
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
	public String getGymname() {
		return gymname;
	}

	public void setGymname(String gymname) {
		this.gymname = gymname;
	}
	
	public class facility{
    	private String name;
    	private int num;
    	private int timeregion;
    	private int date;
    	private int index;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getTimeregion() {
			return timeregion;
		}
		public void setTimeregion(int timeregion) {
			this.timeregion = timeregion;
		}
		public int getDate() {
			return date;
		}
		public void setDate(int date) {
			this.date = date;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
    	
    	
    }
    private List<facility> f11 =new ArrayList<facility>();
    private List<facility> f12 =new ArrayList<facility>();
    private List<facility> f13 =new ArrayList<facility>();
    private List<facility> f14 =new ArrayList<facility>();
    private List<facility> f15 =new ArrayList<facility>();
    private List<facility> f16 =new ArrayList<facility>();
    private List<facility> f17 =new ArrayList<facility>();
    private List<facility> f21 =new ArrayList<facility>();
    private List<facility> f22 =new ArrayList<facility>();
    private List<facility> f23 =new ArrayList<facility>();
    private List<facility> f24 =new ArrayList<facility>();
    private List<facility> f25 =new ArrayList<facility>();
    private List<facility> f26 =new ArrayList<facility>();
    private List<facility> f27 =new ArrayList<facility>();
    private List<facility> f31 =new ArrayList<facility>();
    private List<facility> f32 =new ArrayList<facility>();
    private List<facility> f33 =new ArrayList<facility>();
    private List<facility> f34 =new ArrayList<facility>();
    private List<facility> f35 =new ArrayList<facility>();
    private List<facility> f36 =new ArrayList<facility>();
    private List<facility> f37 =new ArrayList<facility>();
    
    

	public List<facility> getF11() {
		return f11;
	}

	public void setF11(List<facility> f11) {
		this.f11 = f11;
	}

	public List<facility> getF12() {
		return f12;
	}

	public void setF12(List<facility> f12) {
		this.f12 = f12;
	}

	public List<facility> getF13() {
		return f13;
	}

	public void setF13(List<facility> f13) {
		this.f13 = f13;
	}

	public List<facility> getF14() {
		return f14;
	}

	public void setF14(List<facility> f14) {
		this.f14 = f14;
	}

	public List<facility> getF15() {
		return f15;
	}

	public void setF15(List<facility> f15) {
		this.f15 = f15;
	}

	public List<facility> getF16() {
		return f16;
	}

	public void setF16(List<facility> f16) {
		this.f16 = f16;
	}

	public List<facility> getF17() {
		return f17;
	}

	public void setF17(List<facility> f17) {
		this.f17 = f17;
	}

	public List<facility> getF21() {
		return f21;
	}

	public void setF21(List<facility> f21) {
		this.f21 = f21;
	}

	public List<facility> getF22() {
		return f22;
	}

	public void setF22(List<facility> f22) {
		this.f22 = f22;
	}

	public List<facility> getF23() {
		return f23;
	}

	public void setF23(List<facility> f23) {
		this.f23 = f23;
	}

	public List<facility> getF24() {
		return f24;
	}

	public void setF24(List<facility> f24) {
		this.f24 = f24;
	}

	public List<facility> getF25() {
		return f25;
	}

	public void setF25(List<facility> f25) {
		this.f25 = f25;
	}

	public List<facility> getF26() {
		return f26;
	}

	public void setF26(List<facility> f26) {
		this.f26 = f26;
	}

	public List<facility> getF27() {
		return f27;
	}

	public void setF27(List<facility> f27) {
		this.f27 = f27;
	}

	public List<facility> getF31() {
		return f31;
	}

	public void setF31(List<facility> f31) {
		this.f31 = f31;
	}

	public List<facility> getF32() {
		return f32;
	}

	public void setF32(List<facility> f32) {
		this.f32 = f32;
	}

	public List<facility> getF33() {
		return f33;
	}

	public void setF33(List<facility> f33) {
		this.f33 = f33;
	}

	public List<facility> getF34() {
		return f34;
	}

	public void setF34(List<facility> f34) {
		this.f34 = f34;
	}

	public List<facility> getF35() {
		return f35;
	}

	public void setF35(List<facility> f35) {
		this.f35 = f35;
	}

	public List<facility> getF36() {
		return f36;
	}

	public void setF36(List<facility> f36) {
		this.f36 = f36;
	}

	public List<facility> getF37() {
		return f37;
	}

	public void setF37(List<facility> f37) {
		this.f37 = f37;
	}



	public String[] getWeek() {
		return week;
	}

	public void setWeek(String[] week) {
		this.week = week;
	}
	class faconetime{
		private List<facility> onetime=new ArrayList<facility>();
		
		public List<facility> getOnetime() {
			return onetime;
		}

		public void setOnetime(List<facility> onetime) {
			this.onetime = onetime;
		}
		public int create(int i,int j) {
			try {
				Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			}catch (Exception e) {
				return 0;
			}
			try {
				String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
				conn = DriverManager.getConnection(url,"root","123456");	
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
				String sql= "select * from 设施详细信息 where 体育馆='"+getGymname()+"' and 时间段='"+i+"' and 日期='"+j+"'";				
				rs = stmt.executeQuery(sql);
				onetime=new ArrayList<facility>();
				System.out.print("a");
				while(rs.next()) {
					System.out.print("b");
					if((rs.getString("用户")).equals("可用")) {
						System.out.print("c");
						int flag=0;
						for(int t=0;t<onetime.size();t++) {
							if((onetime.get(t).getName()).equals(rs.getString("设施名称"))) {
								onetime.get(t).setNum(onetime.get(t).getNum()+1);
								System.out.print("d");
								flag=1;
							}
						}
						if(flag==0) {
							System.out.print("e");
							facility tfac=new facility();
							tfac.setDate(j);
							tfac.setTimeregion(i);
							tfac.setName(rs.getString("设施名称"));
							tfac.setNum(1);
							tfac.setIndex(rs.getInt("编号"));
							onetime.add(tfac);
						}
					}
				}
				System.out.print("\n");
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
				return 1;
			} catch (Exception e) {
				System.out.print("get data error2!");
				e.printStackTrace();
				return 0;
			}
		}
	}
	public String execute() throws Exception{
		faconetime[][] fac=new faconetime[3][7];
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				fac[i][j]=new faconetime();
				fac[i][j].create(i+1, j+1);
			}
		}
		this.setF11(fac[0][0].getOnetime());
		this.setF12(fac[0][1].getOnetime());
		this.setF13(fac[0][2].getOnetime());
		this.setF14(fac[0][3].getOnetime());
		this.setF15(fac[0][4].getOnetime());
		this.setF16(fac[0][5].getOnetime());
		this.setF17(fac[0][6].getOnetime());
		this.setF21(fac[1][0].getOnetime());
		this.setF22(fac[1][1].getOnetime());
		this.setF23(fac[1][2].getOnetime());
		this.setF24(fac[1][3].getOnetime());
		this.setF25(fac[1][4].getOnetime());
		this.setF26(fac[1][5].getOnetime());
		this.setF27(fac[1][6].getOnetime());
		this.setF31(fac[2][0].getOnetime());
		this.setF32(fac[2][1].getOnetime());
		this.setF33(fac[2][2].getOnetime());
		this.setF34(fac[2][3].getOnetime());
		this.setF35(fac[2][4].getOnetime());
		this.setF36(fac[2][5].getOnetime());
		this.setF37(fac[2][6].getOnetime());
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
		this.setWeek(tempdate);
		return SUCCESS;
		
			
	}
     
}
