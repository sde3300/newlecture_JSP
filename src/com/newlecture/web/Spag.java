package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
	
		String result;
		
		if(num % 2 == 0) 
			result = "짝수";
		else 
			result = "홀수";
		
		request.setAttribute("result", result);
		
		// redirect 새로 요청할 때
		// forward 일을 이어갈 때
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}
