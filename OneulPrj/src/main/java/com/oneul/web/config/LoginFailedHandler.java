package com.oneul.web.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailedHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		
			if (exception instanceof AuthenticationServiceException) {
				request.setAttribute("loginFailMsg", "존재하지 않는 사용자입니다.");
			
			} else if(exception instanceof BadCredentialsException) {
				request.setAttribute("loginFailMsg", "아이디 또는 비밀번호가 틀립니다.");
			}
			
			// 로그인 페이지로 다시 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
	}

}
