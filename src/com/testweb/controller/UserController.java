package com.testweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.service.UserJoinServiceImpl;
import com.testweb.user.service.UserLoginServiceImpl;
import com.testweb.user.service.UserService;
import com.testweb.user.service.UserUpdateServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}
	
	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		
		String command = uri.substring(conPath.length());
		
		UserService service;
		
		System.out.println(command);
		
		if(command.equals("/join.user")) {
			request.getRequestDispatcher("/user/user_join.jsp").forward(request, response);
			
		} else if(command.equals("/joinForm.user")) {
			
			service = new UserJoinServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("login.user");
			} else {
				request.setAttribute("msg", "회원가입에 실패.");
				request.getRequestDispatcher("join.user").forward(request, response);
			}
			
			
		} else if(command.equals("/login.user")) {
			request.getRequestDispatcher("/user/user_login.jsp").forward(request, response);
			
			
		} else if(command.equals("/loginForm.user")) {
			service = new UserLoginServiceImpl();
			int result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("mypage.user");
			} else {
				request.getRequestDispatcher("login.user").forward(request, response);
			}
			
			
		} else if(command.equals("/mypage.user")) {
			request.getRequestDispatcher("user/user_mypage.jsp").forward(request, response);
			
		} else if(command.equals("/mypageinfo.user")) {
			request.getRequestDispatcher("user/user_mypageinfo.jsp").forward(request, response);
			
		} else if(command.equals("/updateForm.user")) {
			service = new UserUpdateServiceImpl();
			
			int result = service.execute(request, response);
			
			if(result == 1) {
				request.getRequestDispatcher("mypage.user").forward(request, response);
			} else {
				request.setAttribute("msg", "정보수정에 실패하셨습니다.");
				request.getRequestDispatcher("mypage.user").forward(request, response);
			}
			
			
		}
		
		
		
		
		
	}

}
