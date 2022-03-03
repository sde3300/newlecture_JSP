package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies =request.getCookies();							
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");											
		String op = request.getParameter("operator"); 									
		
		int v= 0;																		
		if(!v_.equals("")) v= Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {															
			 
			int x=0;														
			for(Cookie c : cookies)												
			if(c.getName().equals("value"))	{										
				x= Integer.parseInt(c.getValue());										
				break;													
				}
			
			int y = v;	
			
			String operator ="";												
			for(Cookie c : cookies)					
				if(c.getName().equals("op")){			
					operator= c.getValue();				
					break;									
					}
			int result=0;
			
			if(operator.equals("+"))			
				result = x+y;
			else
				result = x-y;
			response.getWriter().printf("result is %d", result);
		
		}
		// 값을 저장
		else {
//			application.setAttribute("value", v);										
//			application.setAttribute("op",op);  
			
//			session.setAttribute("value", v);										
//			session.setAttribute("op",op);  
			
			Cookie valueCookie= new Cookie("value", String.valueOf(v));								
			Cookie opCookie= new Cookie("op",op);
			valueCookie.setPath("/");
			opCookie.setPath("/");
			response.addCookie(valueCookie);							
			response.addCookie(opCookie);	
																		
		}	
	}
}