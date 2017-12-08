package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class LoginuserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    
    private User user;
    private UserDao userDao = new UserDaoImpl();
    private String xxx;
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public class allgym{
    	private int index;
    	private String name;
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    	
    }
    private List<allgym> gymlist =new ArrayList<allgym>();

    public List<allgym> getGymlist() {
		return gymlist;
	}
	public void setGymlist(List<allgym> gymlist) {
		this.gymlist = gymlist;
	}
	public String regist(){  
        UserDaoImpl dao = new UserDaoImpl();  
        int i = dao.userRegister(user);  
        if(i!=-1){  
            return SUCCESS;  
        }else{  
            return ERROR;  
        }  
    }  
    
    public String login(){  
        User psw = userDao.userLogin(user.getPhonenum(),user.getPassword());  
        if(psw==null){
            ActionContext.getContext().put("tip", getText("没有这个用户，请注册"));
            return ERROR;  
        }
        else if(!(psw.getPassword()).equals(user.getPassword())) {
           ActionContext.getContext().put("tip", getText("密码错误，请重新登录")); 
           return ERROR;
        }
        else{  
            ActionContext.getContext().put("tip", getText("success"));  
            ActionContext.getContext().put("username", user.getPhonenum()); 
            ActionContext ac=ActionContext.getContext();
    		Map<String, Object> session=ac.getSession();
    		session.put("username", user.getPhonenum());
    		this.setXxx(user.getPhonenum());
    		try {
    			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
    			System.out.println("Success loading Mysql Driver!");
    		}catch (Exception e) {
    			return ERROR;
    		}
    		try {
    			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
    			conn = DriverManager.getConnection(url,"root","123456");
    			stmt = conn.createStatement(); //创建Statement对象	
    			String sql= "select * from 所有体育馆";
    			rs = stmt.executeQuery(sql);
    			List<allgym> tgymlist =new ArrayList<allgym>();
    			while (rs.next()){
    				allgym tgym=new allgym();
    				tgym.setIndex(rs.getInt("编号"));
    				tgym.setName(rs.getString("名称"));
    				tgymlist.add(tgym);
                }
    			this.setGymlist(tgymlist);
    			System.out.println("个数："+gymlist.size());
    			System.out.println("t的name:"+tgymlist.get(0).name);
    			System.out.println("t的index:"+tgymlist.get(0).index);
    			System.out.println("name:"+(this.getGymlist()).get(0).name);
    			System.out.println("index:"+(this.getGymlist()).get(0).index);
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
    
   /* @Override  
    public void validate() {  
        //如果用户名为空或为空字符串，则添加错误信息  
        if(user.getPhonenum() == null||user.getPhonenum().trim().equals("")){  
            //添加表单效验错误信息  
            addFieldError("phonenum", "输入的电话不能为空");  
        }  
        //如果密码为空或为空字符串，则添加错误信息  
        if(user.getPassword()==null ||user.getPassword().trim().equals("")){  
            addFieldError("password", "输入的密码不能为空");  
        }
        
        if(user.getExercise()==null ||user.getExercise().trim().equals("")){  
            addFieldError("exercise", "输入的锻炼计划不能为空");  
        }
        if(user.getBody()==null ||user.getBody().trim().equals("")){  
            addFieldError("body", "输入的体型不能为空");  
        } 
        if(user.getEmail()==null ||user.getEmail().trim().equals("")){  
            addFieldError("password", "输入的邮箱不能为空");  
        } 
        if(user.getUsername()==null ||user.getUsername().trim().equals("")){  
            addFieldError("password", "输入的姓名不能为空");  
        }*/
       
   // }  
   

}
