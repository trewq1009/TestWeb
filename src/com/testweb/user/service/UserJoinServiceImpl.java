package com.testweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserVO;

public class UserJoinServiceImpl implements UserService{

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
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.idCheck(id);
		
		if(result == 1) {
			return 1;
			
		} else {
			UserVO vo = new UserVO(id, pw, name, email, email_provider, phone_first, phone_second, phone_third, address, address_detail, null);
			return dao.join(vo);
			
		}
	}

}
