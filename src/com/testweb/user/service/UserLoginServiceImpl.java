package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class UserLoginServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			result = 1;
		}
		
		return result;
	}

}
