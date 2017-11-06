package com;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.UserDao;  
  
public class RegisterAction extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String identity = request.getParameter("identity"); 
        String phone = request.getParameter("phone");  
        String rpsw = request.getParameter("rpsw");//得到表单输入的内容  
        if(username==null||username.trim().isEmpty()){  
            request.setAttribute("msg", "帐号不能为空");  
            request.getRequestDispatcher("/register2.jsp").forward(request, response);  
            return;  
        }
        if(email==null||email.trim().isEmpty()){  
            request.setAttribute("msg", "邮箱不能为空");  
            request.getRequestDispatcher("/register2.jsp").forward(request, response);  
            return;  
        }  
        if(identity==null||identity.trim().isEmpty()){  
            request.setAttribute("msg", "编号不能为空");  
            request.getRequestDispatcher("/register2.jsp").forward(request, response);  
            return;  
        }  
        if(phone==null||phone.trim().isEmpty()){  
            request.setAttribute("msg", "手机号不能为空");  
            request.getRequestDispatcher("/register2.jsp").forward(request, response);  
            return;  
        }  
        if(password==null||password.trim().isEmpty()){  
            request.setAttribute("msg", "密码不能为空");  
            request.getRequestDispatcher("/register2.jsp").forward(request, response);  
            return;  
        }  
        if(!password.equals(rpsw)){  
            request.setAttribute("msg", "两次输入的密码不同");  
            request.getRequestDispatcher("/regist.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        u.addUser(identity,username,email,phone,password);//调用addUser（）方法  
        request.setAttribute("msg", "恭喜："+identity+"，注册成功");  
        request.getRequestDispatcher("/index.jsp").forward(request, response);  
  
    }  
  
}  