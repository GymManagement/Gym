package com;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class LoginstuffAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    
    private Stuff stuff;
    private StuffDao stuffDao = new StuffDaolmpl();
    private String name;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public String regist(){  
        StuffDaolmpl dao = new StuffDaolmpl();  
        int i = dao.stuffRegister(stuff);  
        if(i!=-1){  
            return SUCCESS;  
        }else{  
            return ERROR;  
        }  
    }  
    
    public String login(){  
    	ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		session.put("gym", stuff.getGym());
		this.setName((String)session.get("gym"));
        Stuff psw = stuffDao.stuffLogin(stuff.getIdentity(),stuff.getPassword(),stuff.getGym());  
        if(psw==null){
            ActionContext.getContext().put("tip", "没有这个工作人员，请注册");
            return ERROR;  
        }
     /*   if(psw!=null && !psw.equals(user.getPassword())) {
           ActionContext.getContext().put("tip", getText("密码错误，请重新登录")); 
           return ERROR;
        }*/
        else{  
            ActionContext.getContext().put("tip", getText("success"));  
            ActionContext.getContext().put("identity", stuff.getPhonenum());  
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
