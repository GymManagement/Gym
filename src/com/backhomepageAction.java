package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.LoginuserAction.allgym;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.searchGymAction.facility;



public class backhomepageAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String xxx;
    
    public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
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
 
	public String execute() throws Exception{
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		this.setXxx((String)session.get("username"));
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			String url="jdbc:mysql://localhost:3306/体育馆基本信息?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","123456");
			stmt = conn.createStatement(); //创建Statement
			gymlist=new ArrayList<allgym>();
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
   


