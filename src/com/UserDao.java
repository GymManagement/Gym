package com;  
  
import com.User;  
  
public interface UserDao {  
    //�û���½   
    public User userLogin(String phonenum,String password);  
    //�û�ע��  
    public int userRegister(User user);  
}  