package com;
//������Ա��¼
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.UserDao;  
  
public class LoginAction extends HttpServlet {  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        String identity = request.getParameter("identity");  
        String password = request.getParameter("password");  
        /*String verifyc  = request.getParameter("verifycode");
        String svc =(String) request.getSession().getAttribute("sessionverify");  
         
        if(!svc.equalsIgnoreCase(verifyc)){  
            request.setAttribute("msg", "��֤�����");  
            request.getRequestDispatcher("/index.jsp").forward(request, response);  
            return;  
        }  */
        String psw =new UserDao().findUsername(identity);
        if(psw ==null){  
            request.setAttribute("msg", "û������û���");  
            request.getRequestDispatcher("/login2.jsp").forward(request, response);  
            return ;
        }  
        if(psw!=null&&!psw.equals(password)){  
            request.setAttribute("msg", "����������������룡");  
            request.getRequestDispatcher("/login2.jsp").forward(request, response);  
            return;  
        }  
        if(psw.equals(password)){  
            request.setAttribute("msg", "�û���"+identity+",��ӭ����");  
            request.getRequestDispatcher("/idontknow.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
        }  
          
    }  
    
  
}  