package com.model;

public class booking {
	
	private String BookName;
	private String Aouther;
	private String Availability;
	private String Bookid;
	private int copys;
    private String View;
    private int userid;
    private String username;
    private int cartitemid;
    private String systemdate;
    private int queueitemno;
    
    private int copycount;
    private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCopycount() {
		return copycount;
	}

	public void setCopycount(int copycount) {
		this.copycount = copycount;
	}

	public int getQueueitemno() {
		return queueitemno;
	}

	public void setQueueitemno(int queueitemno) {
		this.queueitemno = queueitemno;
	}

	public String getSystemdate() {
		return systemdate;
	}

	public void setSystemdate(String systemdate) {
		this.systemdate = systemdate;
	}

	public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getView(){
		return View;
	}
	
	public void setView(String View){
		this.View = View;
	}
	public String getBookid() {
		return Bookid;
	}
	public void setBookid(String bookid) {
		Bookid = bookid;
	}
	public int getCopys() {
		return copys;
	}
	public void setCopys(int copys) {
		this.copys = copys;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAouther() {
		return Aouther;
	}
	public void setAouther(String aouther) {
		Aouther = aouther;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	
	

}
