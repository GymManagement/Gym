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
    		this.setXxx((String)session.get("username"));
            return SUCCESS;  
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
