package com;
import java.sql.Date;
import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

public class helloAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String setuser;
	private String getuser;
	
	public String getSetuser() {
		return setuser;
	}

	public void setSetuser(String setuser) {
		this.setuser = setuser;
	}

	public String getGetuser() {
		return getuser;
	}

	public void setGetuser(String getuser) {
		this.getuser = getuser;
	}

	public String execute() throws Exception{
		this.setSetuser(this.getGetuser());
	    return SUCCESS;
	}
     
}
