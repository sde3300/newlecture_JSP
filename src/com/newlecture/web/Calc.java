package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 이때 빈 문자열이 오거나 or 진짜 담긴 값이 오는 경우 발생
		String x_ = request.getParameter("x"); 
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");			
		
		int x= 0;
		int y= 0;
		int result=0;				
		
		if(!x_.equals("")) x= Integer.parseInt(x_);
		if(!y_.equals("")) y= Integer.parseInt(y_);
		
		if(op.equals("덧셈"))			
			result = x + y;
		else				
			result = x - y;
		
		response.getWriter().printf("result is %d\n", result);
		
	}
}
