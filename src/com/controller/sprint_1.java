//due books fine
//notification
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Addbook;
import com.model.Addpayment;
import com.model.register_GS;
import com.service.check_login;
import com.service.check_loginCredential;
import com.service.dueBooksService;


@Controller
public class sprint_1{

@RequestMapping("/dueBooks")
public void gg(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException, IOException, ParseException
{
	
	HttpSession session = request.getSession();
	register_GS obj = (register_GS) session.getAttribute("currentSessionUser");
	String username = obj.getUsername();
	
	dueBooksService due = new dueBooksService();
	List<Addpayment> al = new ArrayList<Addpayment>();
	al = due.showDueBook(username);
	String x = "";
	
	if(al == null) {
		x = "no records";
	}
	else {
		for(Addpayment records : al) {
			int val = 100;
			
			String sdueDate = records.getDue_date();
			Date dueDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdueDate);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String cdate = dateFormat.format(date);
			
			Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(cdate);  
			    
			long diffInMillies = currentDate.getTime() - dueDate.getTime();
			
			long diffDays = diffInMillies / (24 * 60 * 60 * 1000);
			
			String duepay = "";
			
			int different = records.getDiff();
			
			if(different > 0){
				duepay = "You dont have any fine";
				System.out.println("Hello: " + different);
			}
			else{
				duepay = "Due: " + different * val + "Rs/=";
				System.out.println("Hello2: " + different);
			}
			
			x = x + records.getBookno() + "  -->  " + duepay + "<br/>";
		}
	}
	
	//System.out.println(x);
	PrintWriter out =  respond.getWriter();
	String link = "http://localhost:8081/Ransi/showduebooks.jsp?msg=" + x;
	respond.sendRedirect(link);
}

@RequestMapping("/login")
public ModelAndView login(HttpServletRequest request,HttpServletResponse respond)throws ClassNotFoundException, SQLException
{
	String uname = request.getParameter("username");
	String password = request.getParameter("password");
	
	ModelAndView mv = new ModelAndView();
	
	register_GS obj2 = new register_GS();
	
	obj2.setUsername(uname);
	obj2.setPassword(password);
	
	check_loginCredential lc = new check_loginCredential();
	boolean result = lc.loginUserService(obj2);
	System.out.println(result);
	//-------------------------
	//Get if user or admin
	register_GS obj3 = new register_GS();
	
	obj3.setUsername(uname);
	obj3.setPassword(password);

	check_login cl  = new check_login();
	String check = cl.check_login(obj3);
	
	//----------------------------
	
	if(result == true && check.equals("Admin"))
	{
		//recordLoginTime LT = new recordLoginTime();
		//LT.logingRecord(uname);
		
		HttpSession session = request.getSession(true);  
		
		
		 
        session.setAttribute("currentSessionUser",obj3); 
       
        
   
        //Pass daily attendance!!!!
       // getEmployeeService ES= new getEmployeeService();
		//ArrayList search_list = ES.searchEmployeeNames();

		//search4Service US = new search4Service();//Create Search4 service object
		//ArrayList search_list2 = US.getDailyStatus();
		
		mv.setViewName("links.jsp");//logged-in Admin page  
		
	}
	else if(result == true && check.equals("User"))
	{
		//recordLoginTime LT = new recordLoginTime();
		//LT.logingRecord(uname); 
        
		HttpSession session = request.getSession(true);  
        session.setAttribute("currentSessionUser",obj3); 
       
		mv.setViewName("links.jsp");//logged-in User page    
	}
	else
	{
		String erorr = "Eneter Correct Credentials!!";
		mv.addObject("result",erorr);
		mv.setViewName("LoginError.jsp");
	}
	
	return mv;
}

@RequestMapping("/notify")
public void notify(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException, IOException, ParseException
{
	
	HttpSession session = request.getSession();
	register_GS obj = (register_GS) session.getAttribute("currentSessionUser");
	String username = obj.getUsername();
	
	dueBooksService due = new dueBooksService();
	List<Addpayment> al = due.notify(username);
	String x = "";
	
	if(al == null) {
		x = "no records";
	}
	else {
		for(Addpayment records : al) {
			String sdueDate = records.getDue_date();
			Date dueDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdueDate);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String cdate = dateFormat.format(date);
			
			Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(cdate);  
			    
			long diffInMillies = currentDate.getTime() - dueDate.getTime();
			
			long diffDays = diffInMillies / (24 * 60 * 60 * 1000);
			
			int different = records.getDiff();
			
			String duepaymsg = "";
			
			if((different <= 2) && (different >= 0)){
				System.out.println(different);
				duepaymsg = "Warning: You have to return the book within the next two days, else you will be fined!!!";
				x = x + records.getBookno() + "  -->  " + duepaymsg + ", due date --> " + records.getDue_date() + "<br/>";
			}
			else{
				x = x + "";
			}
		}
	}
	
	System.out.println(x);
	PrintWriter out =  respond.getWriter();
	String link = "http://localhost:8081/Ransi/notify.jsp?msg=" + x;
	respond.sendRedirect(link);
}

@RequestMapping("/returnBook")
public void returnBook(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException, IOException, ParseException{
	dueBooksService due = new dueBooksService();
	List<Addpayment> al = due.showAllBooks();
	HttpSession session = request.getSession();
	session.setAttribute("booksPayList", al);
	respond.sendRedirect("returnBook.jsp");
}

@RequestMapping("/addPayment")
public void addPayment(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException, IOException, ParseException{
	int id = Integer.parseInt(request.getParameter("id"));
	int diff = Integer.parseInt(request.getParameter("diff"));
	dueBooksService due = new dueBooksService();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String cdate = dateFormat.format(date);
	float pay = 0;
	if(diff > 0) {
		pay = diff * 100;
	}
	System.out.println(diff);
	System.out.println(pay);
	due.addPayment(id, pay, cdate);
	System.out.println(id + ", " + pay + ", " + cdate);
	respond.sendRedirect("returnBookSucc.jsp");
}

}
