package com.testweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;


public class UserDAO {

	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		try {
			
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public int idCheck(String id) {
		String sql = "select * from users where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {		// 중복 없으면 false
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	public int join(UserVO vo) {
		int result = 0;
		String sql = "insert into users(id, pw, name, email, email_provider, phone_first, phone_second, phone_third, address, address_detail, regdate) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getEmail_provider());
			pstmt.setString(6, vo.getPhone_first());
			pstmt.setString(7, vo.getPhone_second());
			pstmt.setString(8, vo.getPhone_third());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, vo.getAddress_detail());
			pstmt.setString(11, null);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	public UserVO login(String id, String pw) {
		String sql = "select * from users where id=? and pw=?";
		UserVO vo = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {	// 값이 있음 로그인 성공
				vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setEmail(rs.getString("email"));
				vo.setEmail_provider(rs.getString("email_provider"));
				vo.setAddress(rs.getString("address"));
				vo.setAddress_detail(rs.getString("address_detail"));
				vo.setPhone_first(rs.getString("phone_first"));
				vo.setPhone_second(rs.getString("phone_second"));
				vo.setPhone_third(rs.getString("phone_third"));
				vo.setRegdate(rs.getString("regdate"));
				
				System.out.println(vo.toString());
				
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	
	public int update(UserVO vo) {
		String sql = "update users set pw=?, name=?, email=?, email_provider=?, phone_first=?, phone_second=?, phone_third=?, address=?, address_detail=? where id=?";
		int result = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmail_provider());
			pstmt.setString(5, vo.getPhone_first());
			pstmt.setString(6, vo.getPhone_second());
			pstmt.setString(7, vo.getPhone_third());
			pstmt.setString(8, vo.getAddress());
			pstmt.setString(9, vo.getAddress_detail());
			pstmt.setString(10, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
