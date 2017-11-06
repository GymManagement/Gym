package com;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import com.opensymphony.xwork2.ActionSupport;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.ServletActionContext;

import com.Guest;  
  
public class Register2Action extends ActionSupport {  
  
    private static final long serialVersionUID = 1L;  
  
    public String execute() throws Exception{ 
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String body = request.getParameter("body"); 
        String time = request.getParameter("time"); 
        String phone = request.getParameter("phone");  
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String aim = request.getParameter("aim");
        String exercise = request.getParameter("exercise");
        String rpsw = request.getParameter("rpsw");//�õ������������  
        if(username==null||username.trim().isEmpty()){  
            request.setAttribute("msg", "��������Ϊ��");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return ERROR;
        }
        if(email==null||email.trim().isEmpty()){  
            request.setAttribute("msg", "���䲻��Ϊ��");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return ERROR;  
        }  
        if(body==null||body.trim().isEmpty()){  
            request.setAttribute("msg", "���Ͳ���Ϊ��");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return ERROR;  
        }  
        if(phone==null||phone.trim().isEmpty()){  
            request.setAttribute("msg", "�ֻ��Ų���Ϊ��");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return ERROR;  
        }  
        if(password==null||password.trim().isEmpty()){  
            request.setAttribute("msg", "���벻��Ϊ��");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return ERROR;  
        }  

        if(!password.equals(rpsw)){  
            request.setAttribute("msg", "������������벻ͬ");  
            request.getRequestDispatcher("/regist.jsp").forward(request, response);  
            return ERROR;  
        }  
        Guest u = new Guest();  
        int aimi = Integer.valueOf(aim).intValue();
        int heighti = Integer.valueOf(height).intValue();
        int weighti = Integer.valueOf(weight).intValue();
        u.addUser(phone,username,email,password,body,time,aimi,heighti,weighti,exercise);//����addUser��������  
        request.setAttribute("msg", "��ϲ��"+username+"��ע��ɹ�");  
        request.getRequestDispatcher("/index.jsp").forward(request, response);  
        return SUCCESS;
  
    }  
  
}  