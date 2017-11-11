package com;  
  
import com.Stuff;  
  
public interface StuffDao {  
    //用户登陆   
    public Stuff stuffLogin(String identity,String password,String gym);  
    //用户注册  
    public int stuffRegister(Stuff stuff);  
}  