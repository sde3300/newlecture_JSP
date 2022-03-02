package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String temp = request.getParameter("cnt");	// temp에 값을 받음
		
		int cnt= 100;							// 기본값은 100
		if(temp != null && !temp.equals(""))	// temp가 null이 아니고 tmep값이 ("")이 아니면 (빈문자열이오면 인트형으로 못바꾸기 때문) cnt를 temp로 바꿈
			cnt = Integer.parseInt(temp);
		
		for(int i=0; i<cnt; i++)				
			out.println((i+1)+" : 안녕 servlet!!<br/>");

	}
}
