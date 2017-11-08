package com;  
  
import com.User;  
  
public interface UserDao {  
    //用户登陆   
    public User userLogin(String phonenum,String password);  
    //用户注册  
    public int userRegister(User user);  
}  