package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;


public class detailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	

	
	public class author{
		private int authorid;
		private String name;
		private int age;
		private String country;
		public int getAuthorid() {
			return authorid;
		}
		public void setAuthorid(int authorid) {
			this.authorid = authorid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
		
	}
	public class book{
		private int ISBN;
		private String title;
		private int authorID;
		private String publisher;
		private int publishdate;
		private float price;
		public int getISBN() {
			return ISBN;
		}
		public void setISBN(int iSBN) {
			ISBN = iSBN;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getAuthorID() {
			return authorID;
		}
		public void setAuthorID(int authorID) {
			this.authorID = authorID;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public int getPublishdate() {
			return publishdate;
		}
		public void setPublishdate(int publishdate) {
			this.publishdate = publishdate;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		
		
	}
	private book thetitle;
	private author theauthor;
	private int isbn;
	private Connection conn = null;
    private Statement stmt = null;
   // private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public book getThetitle() {
		return thetitle;
	}
	public void setThetitle(book thetitle) {
		this.thetitle = thetitle;
	}
	public author getTheauthor() {
		return theauthor;
	}
	public void setTheauthor(author theauthor) {
		this.theauthor = theauthor;
	}

	public String execute() throws Exception{
		  try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	int idnew=0;
		    	String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_yqzheng?characterEncoding=utf8&useSSL=false";
				conn = DriverManager.getConnection(url,"jnymxo1lm3","hh4jw2illii3m4i3ll5ijmxw300j451zlihh0jlm");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

		      System.out.println("Success connect Mysql server!");
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery("select * from book");
		                                                              //user 为你表的名称
				while(rs.next()) {
					if(rs.getInt("ISBN")==this.getIsbn()) {
						book bookinfo=new book();
						bookinfo.setAuthorID(rs.getInt("AuthorID"));
						bookinfo.setISBN(rs.getInt("ISBN"));
						bookinfo.setTitle(rs.getString("Title"));
						bookinfo.setPrice(rs.getFloat("Price"));
						bookinfo.setPublishdate(rs.getInt("PublishDate"));
						bookinfo.setPublisher(rs.getString("Publisher"));
						this.setThetitle(bookinfo);
						idnew=rs.getInt("AuthorID");

						System.out.println(rs.getInt("AuthorID"));
						break;				
					}					
				}
				rs = stmt.executeQuery("select * from author");
				while(rs.next()) {
					if(rs.getInt("authorid")==idnew) {
						author authornew = new author();
						authornew.setAge(rs.getInt("Age"));
						authornew.setAuthorid(rs.getInt("AuthorID"));
						authornew.setCountry(rs.getString("Country"));
						authornew.setName(rs.getString("Name"));
						this.setTheauthor(authornew);
						
					}
				}
				try {
				    if (rs!= null) {
				      rs.close();
				    }

				    if (stmt != null) {
				      stmt.close();
				    }

				    if (conn!= null) {
				      conn.close();
				    }
				  } catch (Exception e) {
					  System.out.print("get data error!");
				  }
		    }catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		return SUCCESS;
	}
     
}
