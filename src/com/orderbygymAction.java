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
import com.orderAction.faconetime;
import com.scoreAction.facility;

public class orderbygymAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String gym;
	private String[] week=new String[8];
	private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String gymname;
    
	public String getGymname() {
		return gymname;
	}
	public void setGymname(String gymname) {
		this.gymname = gymname;
	}
	private int choose11;
    private int choose12;
    private int choose13;
    private int choose14;
    private int choose15;
    private int choose16;
    private int choose17;
    private int choose21;
    private int choose22;
    private int choose23;
    private int choose24;
    private int choose25;
    private int choose26;
    private int choose27;
    private int choose31;
    private int choose32;
    private int choose33;
    private int choose34;
    private int choose35;
    private int choose36;
    private int choose37;
    
	public int getChoose11() {
		return choose11;
	}
	public void setChoose11(int choose11) {
		this.choose11 = choose11;
	}
	public int getChoose12() {
		return choose12;
	}
	public void setChoose12(int choose12) {
		this.choose12 = choose12;
	}
	public int getChoose13() {
		return choose13;
	}
	public void setChoose13(int choose13) {
		this.choose13 = choose13;
	}
	public int getChoose14() {
		return choose14;
	}
	public void setChoose14(int choose14) {
		this.choose14 = choose14;
	}
	public int getChoose15() {
		return choose15;
	}
	public void setChoose15(int choose15) {
		this.choose15 = choose15;
	}
	public int getChoose16() {
		return choose16;
	}
	public void setChoose16(int choose16) {
		this.choose16 = choose16;
	}
	public int getChoose17() {
		return choose17;
	}
	public void setChoose17(int choose17) {
		this.choose17 = choose17;
	}
	public int getChoose21() {
		return choose21;
	}
	public void setChoose21(int choose21) {
		this.choose21 = choose21;
	}
	public int getChoose22() {
		return choose22;
	}
	public void setChoose22(int choose22) {
		this.choose22 = choose22;
	}
	public int getChoose23() {
		return choose23;
	}
	public void setChoose23(int choose23) {
		this.choose23 = choose23;
	}
	public int getChoose24() {
		return choose24;
	}
	public void setChoose24(int choose24) {
		this.choose24 = choose24;
	}
	public int getChoose25() {
		return choose25;
	}
	public void setChoose25(int choose25) {
		this.choose25 = choose25;
	}
	public int getChoose26() {
		return choose26;
	}
	public void setChoose26(int choose26) {
		this.choose26 = choose26;
	}
	public int getChoose27() {
		return choose27;
	}
	public void setChoose27(int choose27) {
		this.choose27 = choose27;
	}
	public int getChoose31() {
		return choose31;
	}
	public void setChoose31(int choose31) {
		this.choose31 = choose31;
	}
	public int getChoose32() {
		return choose32;
	}
	public void setChoose32(int choose32) {
		this.choose32 = choose32;
	}
	public int getChoose33() {
		return choose33;
	}
	public void setChoose33(int choose33) {
		this.choose33 = choose33;
	}
	public int getChoose34() {
		return choose34;
	}
	public void setChoose34(int choose34) {
		this.choose34 = choose34;
	}
	public int getChoose35() {
		return choose35;
	}
	public void setChoose35(int choose35) {
		this.choose35 = choose35;
	}
	public int getChoose36() {
		return choose36;
	}
	public void setChoose36(int choose36) {
		this.choose36 = choose36;
	}
	public int getChoose37() {
		return choose37;
	}
	public void setChoose37(int choose37) {
		this.choose37 = choose37;
	}
	public class facility{
    	public String name;
    	public int num;
    	public int timeregion;
    	public int date;
    	public int index;
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
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}

	public String[] getWeek() {
		return week;
	}

	public void setWeek(String[] week) {
		this.week = week;
	}
	class faconetime{
		public List<facility> onetime=new ArrayList<facility>();
		public void init() {
			System.out.println("长度为："+onetime.size());
		}
	}
	class orderit{
		private int index;
		private String user;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public int order(int i,int j) {
			try {
				String sql= "select * from 设施详细信息 where 体育馆='"+getGym()+"' and 时间段='"+i+"' and 日期='"+j+"'";				
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					if(rs.getString("用户").equals("可用")) {
						rs.updateString("用户",user);
						rs.updateRow();
						return 1;
					}
				}
				return 0;
			}catch (Exception e) {
				System.out.print("get data error in orderit!");
				e.printStackTrace();
				return -1;
			}
		}
	}
	public String execute() throws Exception{
		this.setGymname(getGym());
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");	
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		String un=(String)session.get("username");
		orderit[][] fac=new orderit[3][7];
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				fac[i][j]=new orderit();
				fac[i][j].setUser(un);
			}
		}
		fac[0][0].setIndex(this.getChoose11());
		fac[0][1].setIndex(this.getChoose12());
		fac[0][2].setIndex(this.getChoose13());
		fac[0][3].setIndex(this.getChoose14());
		fac[0][4].setIndex(this.getChoose15());
		fac[0][5].setIndex(this.getChoose16());
		fac[0][6].setIndex(this.getChoose17());
		fac[1][0].setIndex(this.getChoose21());
		fac[1][1].setIndex(this.getChoose22());
		fac[1][2].setIndex(this.getChoose23());
		fac[1][3].setIndex(this.getChoose24());
		fac[1][4].setIndex(this.getChoose25());
		fac[1][5].setIndex(this.getChoose26());
		fac[1][6].setIndex(this.getChoose27());
		fac[2][0].setIndex(this.getChoose31());
		fac[2][1].setIndex(this.getChoose32());
		fac[2][2].setIndex(this.getChoose33());
		fac[2][3].setIndex(this.getChoose34());
		fac[2][4].setIndex(this.getChoose35());
		fac[2][5].setIndex(this.getChoose36());
		fac[2][6].setIndex(this.getChoose37());
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				if(fac[i][j].getIndex()!=-1) {
					fac[i][j].order(i+1,j+1);
				}				
			}
		}
		faconetime[][] fac2=new faconetime[3][7];
		for(int i=0;i<3;i++) {
			for(int j=0;j<7;j++) {
				fac2[i][j]=new faconetime();
			}
		}

		try {
			for(int i=1;i<=3;i++) {
				for(int j=1;j<=7;j++) {
					String sql= "select * from 设施详细信息 where 体育馆='"+getGym()+"' and 时间段='"+i+"' and 日期='"+j+"'";				
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						if(rs.getString("用户").equals("可用")) {
							int flag=0;
							for(int t=0;t<fac2[i-1][j-1].onetime.size();t++) {
								if(fac2[i-1][j-1].onetime.get(t).name.equals(rs.getString("设施名称"))) {
									fac2[i-1][j-1].onetime.get(t).num++;
									flag=1;
								}
							}
							if(flag==0) {
								facility tfac=new facility();
								tfac.date=j;
								tfac.timeregion=i;
								tfac.name=rs.getString("设施名称");
								tfac.num=1;
								fac2[i-1][j-1].onetime.add(tfac);
							}
						}
					}
				}
			}
			this.setF11(fac2[0][0].onetime);
			this.setF12(fac2[0][1].onetime);
			this.setF13(fac2[0][2].onetime);
			this.setF14(fac2[0][3].onetime);
			this.setF15(fac2[0][4].onetime);
			this.setF16(fac2[0][5].onetime);
			this.setF17(fac2[0][6].onetime);
			this.setF21(fac2[1][0].onetime);
			this.setF22(fac2[1][1].onetime);
			this.setF23(fac2[1][2].onetime);
			this.setF24(fac2[1][3].onetime);
			this.setF25(fac2[1][4].onetime);
			this.setF26(fac2[1][5].onetime);
			this.setF27(fac2[1][6].onetime);
			this.setF31(fac2[2][0].onetime);
			this.setF32(fac2[2][1].onetime);
			this.setF33(fac2[2][2].onetime);
			this.setF34(fac2[2][3].onetime);
			this.setF35(fac2[2][4].onetime);
			this.setF36(fac2[2][5].onetime);
			this.setF37(fac2[2][6].onetime);
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
			this.setWeek(tempdate);
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error2!");
			e.printStackTrace();
			return ERROR;
		}
	}
     
}
