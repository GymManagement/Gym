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
            ActionContext.getContext().put("tip", getText("û������û�����ע��"));
            return ERROR;  
        }
        else if(!(psw.getPassword()).equals(user.getPassword())) {
           ActionContext.getContext().put("tip", getText("������������µ�¼")); 
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
    			Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
    			System.out.println("Success loading Mysql Driver!");
    		}catch (Exception e) {
    			return ERROR;
    		}
    		try {
    			String url="jdbc:mysql://localhost:3306/�����ݻ�����Ϣ?characterEncoding=utf8&useSSL=false";
    			conn = DriverManager.getConnection(url,"root","123456");
    			stmt = conn.createStatement(); //����Statement����	
    			String sql= "select * from ����������";
    			rs = stmt.executeQuery(sql);
    			List<allgym> tgymlist =new ArrayList<allgym>();
    			while (rs.next()){
    				allgym tgym=new allgym();
    				tgym.setIndex(rs.getInt("���"));
    				tgym.setName(rs.getString("����"));
    				tgymlist.add(tgym);
                }
    			this.setGymlist(tgymlist);
    			System.out.println("������"+gymlist.size());
    			System.out.println("t��name:"+tgymlist.get(0).name);
    			System.out.println("t��index:"+tgymlist.get(0).index);
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
        //����û���Ϊ�ջ�Ϊ���ַ���������Ӵ�����Ϣ  
        if(user.getPhonenum() == null||user.getPhonenum().trim().equals("")){  
            //��ӱ�Ч�������Ϣ  
            addFieldError("phonenum", "����ĵ绰����Ϊ��");  
        }  
        //�������Ϊ�ջ�Ϊ���ַ���������Ӵ�����Ϣ  
        if(user.getPassword()==null ||user.getPassword().trim().equals("")){  
            addFieldError("password", "��������벻��Ϊ��");  
        }
        
        if(user.getExercise()==null ||user.getExercise().trim().equals("")){  
            addFieldError("exercise", "����Ķ����ƻ�����Ϊ��");  
        }
        if(user.getBody()==null ||user.getBody().trim().equals("")){  
            addFieldError("body", "��������Ͳ���Ϊ��");  
        } 
        if(user.getEmail()==null ||user.getEmail().trim().equals("")){  
            addFieldError("password", "��������䲻��Ϊ��");  
        } 
        if(user.getUsername()==null ||user.getUsername().trim().equals("")){  
            addFieldError("password", "�������������Ϊ��");  
        }*/
       
   // }  
   

}
