package com.testweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testweb.board.service.BoardService;
import com.testweb.board.service.ContentServiceImpl;
import com.testweb.board.service.DeleteServiceImpl;
import com.testweb.board.service.GetListServiceImpl;
import com.testweb.board.service.RegistServiceImpl;
import com.testweb.board.service.UpHitServiceImpl;
import com.testweb.board.service.UpdateServiceImpl;

// 1. 글 컨트롤러
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
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
		
		// 2. 요청 분기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
		
		// ************************************************************************************
		// MVC2에서는 기본적으로 forward이동을 사용하고, 다시컨트롤러를 태울때 Redirect를 사용한다
		
		
		// service부모타입 선언.
		BoardService service;
		
		if(command.equals("/bbs/list.board")) {		// 글 목록 요청
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			// 목록을 가지고 forward이동
			request.getRequestDispatcher("bbs.jsp").forward(request, response);
			
		} else if(command.equals("/bbs/writer.board")) {	// 글화면 요청
			
			request.getRequestDispatcher("bbs_writer.jsp").forward(request, response);
			
		} else if(command.equals("/bbs/regist.board")) {	// 글 등록 요청
			
			 service = new RegistServiceImpl();
			 service.execute(request, response);
			 
			 response.sendRedirect("list.board");	// 다시 컨트롤러를 태워보내는 형식
			
		} else if(command.equals("/bbs/content.board")) {		// 상세보기 이동
			// 조회수 관련 작업
			service = new UpHitServiceImpl();
			service.execute(request, response);
			
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
			
		} else if(command.equals("/bbs/modify.board")) {	// 수정화면 요청
			
			/*
			 *  1. ContentServiceImpl() 재활용 합니다.
			 *  2. 포워드 형식으로 board_modify.jsp로 이동
			 *  3. 화면에서는 태그안에 데이터 값을 출력
			 */
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);
			
			
		} else if(command.equals("/bbs/update.board")) {
			
			/*
			 *  1. UpdateSeriveImpl() 을 생성하고 execute()메서드 실행.
			 *  2. 서비스에서 bno. title, content를 받아서 DAO의 update() 메서드로 실행
			 *  3. update()는 sql문으로 수정을 진행
			 *  4. 컨트롤러에서는 페이지 이름을 content화면으로 이동.
			 *  
			 */
			
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("content.board?bno=" + request.getParameter("bno"));
			
		} else if(command.equals("/bbs/delete.board")) {
			
			/*
			 *  1. 화면에서 delete.board요청으로 필요한 값을 get방식으로 넘겨줍니다.
			 *  2. DeleteServiceImpl() 생성하고 dao의 delete()메서드 실행
			 *  3. 삭제 진행후에 목록페이지로 이동.
			 */
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			
			response.sendRedirect("list.board");
			
			
		}
		
		
	}

}
