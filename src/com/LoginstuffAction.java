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
            ActionContext.getContext().put("tip", "û�����������Ա����ע��");
            return ERROR;  
        }
     /*   if(psw!=null && !psw.equals(user.getPassword())) {
           ActionContext.getContext().put("tip", getText("������������µ�¼")); 
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
