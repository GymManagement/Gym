package com;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String xxx;
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	public String execute() throws Exception{
	    return SUCCESS;
	}
     
}
