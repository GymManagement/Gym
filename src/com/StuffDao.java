package com;  
  
import com.Stuff;  
  
public interface StuffDao {  
    //�û���½   
    public Stuff stuffLogin(String identity,String password,String gym);  
    //�û�ע��  
    public int stuffRegister(Stuff stuff);  
}  