package com;

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
    		this.setXxx((String)session.get("username"));
            return SUCCESS;  
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
