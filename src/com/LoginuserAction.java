package com;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class LoginuserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    
    private User user;
    private UserDao userDao = new UserDaoImpl();
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
            return ERROR;  
        }else{  
            ActionContext.getContext().put("tip", getText("success"));  
            ActionContext.getContext().put("username", user.getPhonenum());  
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
