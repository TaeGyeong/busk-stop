package com.buskstop.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.buskstop.dao.UserDao;
import com.buskstop.vo.User;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// ID CHECK
		String id= authentication.getName();
		User user = dao.selectUserById(id);
		if(user==null) {
			throw new UsernameNotFoundException("ID를 확인해주세요.");
		}
		
		// PASSWORD CHECK
		String password = (String)authentication.getCredentials();
		if(!encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("비밀번호를 확인해주세요.");
		}
		
		

		
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}
	
	
}
