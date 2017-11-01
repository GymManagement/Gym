package com;
import com.opensymphony.xwork2.ActionSupport;

public class searchGymAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nameOfGym;
	
	public String getNameOfGym() {
		return nameOfGym;
	}

	public void setNameOfGym(String nameOfGym) {
		this.nameOfGym = nameOfGym;
	}

	public String execute() throws Exception{
	    return SUCCESS;
	}
     
}
