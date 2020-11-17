package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class UserUpdateServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String email_provider = request.getParameter("email_provider");
		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");
		String phone_first = request.getParameter("phone_first");
		String phone_second = request.getParameter("phone_second");
		String phone_third = request.getParameter("phone_third");
		UserVO vo = new UserVO(id, pw, name, email, email_provider, address, address_detail, phone_first, phone_second, phone_third, null);
		System.out.println(name);
		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(vo);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			vo.setPw("");
			session.setAttribute("vo", vo);
		}
		return result;
	}

}
