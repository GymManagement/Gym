package com;
import com.opensymphony.xwork2.ActionSupport;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SearchAction extends ActionSupport {
	public class book{
		private String booktitle;
		private int isbn;
		public String getBooktitle() {
			return booktitle;
		}
		public void setBooktitle(String booktitle) {
			this.booktitle = booktitle;
		}
		public int getIsbn() {
			return isbn;
		}
		public void setIsbn(int isbn) {
			this.isbn = isbn;
		}
		

	}
	private Connection conn = null;
    private Statement stmt = null;
   // private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
	private static final long serialVersionUID = 1L;
	private String authorname;
	private String[] authornum=new String[100];
	private List<book> booklist=new ArrayList<book>();

	

	public String[] getAuthornum() {
		return authornum;
	}
	public void setAuthornum(String[] authornum) {
		this.authornum = authornum;
	}
	public List<book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<book> booklist) {
		this.booklist = booklist;
	}
	
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String execute() throws Exception{
		System.out.print(authorname);
		try {
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e) {
			return ERROR;
		}
		try {
			int flag=0;
			String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_yqzheng?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url,"jnymxo1lm3","hh4jw2illii3m4i3ll5ijmxw300j451zlihh0jlm");
			stmt = conn.createStatement(); //创建Statement对象
			String sql= "select * from author";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("name").equals(authorname)) {
					authornum[flag]=rs.getString("authorid");
					flag++;
				}
			}
			sql= "select * from book";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				for(int i=0;i<flag;i++) {
					if(rs.getString("authorid").equals(authornum[i])) {
						book tbook=new book();
						tbook.setBooktitle(rs.getString("title"));
						tbook.setIsbn(rs.getInt("isbn"));
						booklist.add(tbook);	
					}
				}
			}
			if(booklist.size()==0) {
				return SUCCESS;
			}

			try {
	            if (rs!= null) {
	              rs.close();
	            }

	            if (stmt != null) {
	              stmt.close();
	            }

	            if (conn != null) {
	              conn.close();
	            }
	          } catch (Exception e) {
	        	  System.out.print("get data error!");
	          }
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
			return ERROR;
		}
		

			
	}
     
}