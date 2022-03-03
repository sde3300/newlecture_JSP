package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 어플리케이션 저장소 : ServletContext
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies(); // 쿠키를 읽을 때 request 사용

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;

		if (!v_.equals(""))
			v = Integer.parseInt(v_);

		// 계산을 위한 조건 설정
		if (op.equals("=")) {

			// x = 담은 값을 가져와 x에 저장(꺼내서 사용)
			// int x = (Integer)application.getAttribute("value");
			// int x = (Integer)session.getAttribute("value");

			int x = 0;
			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}

			int y = v;
			// operator = 담은 값을 가져와 operator에 저장(꺼내서 사용)
			// String operator = (String)application.getAttribute("op");
			// String operator = (String) session.getAttribute("op");

			String operator = "";
			for (Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}

			int result = 0;

			if (operator.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}

			response.getWriter().printf("result is %d\n", result);
		}
		// 저장을 위한 조건 설정
		// 오퍼레이터 입력이 덧셈 또는 뺄셈인 경우, 그냥 값 저장만 진행
		else {
			// application.setAttribute("value", v);
			// application.setAttribute("op", op);

			// session.setAttribute("value", v);
			// session.setAttribute("op", op);

			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			//valueCookie.setPath("/");   // 모든 경로 
			//opCookie.setPath("/");      // 모든 경로
			//valueCookie.setPath("/add");  // add라는 url 요청 시
			//opCookie.setPath("/add");     // add라는 url 요청 시
			valueCookie.setPath("/calc2");  // calc2라는 url 요청 시
			opCookie.setPath("/calc2");     // calc2라는 url 요청 시
			valueCookie.setMaxAge(24*60*60);	// 만료날짜 지정 (초단위로 지정, 60은 1분)
						
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}

	}

}