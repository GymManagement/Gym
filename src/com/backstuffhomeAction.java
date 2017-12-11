package com;

import java.sql.*;
import java.util.Map;
import java.math.BigDecimal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import java.sql.Statement;


public class backstuffhomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String name;
	private String getgym;
	
	
	public String getGetgym() {
		return getgym;
	}


	public void setGetgym(String getgym) {
		this.getgym = getgym;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String execute() throws Exception{
		//ActionContext ac=ActionContext.getContext();
		//Map<String, Object> session=ac.getSession();
		String nn=this.getGetgym();
		this.setName(nn);
		return SUCCESS;
	}
}



