package com.example.demo.Model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUserAccount implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserAccount userAccount;
	
	public SecurityUserAccount(UserAccount userAccount) {
		super();
		this.userAccount = userAccount;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userAccount.getEmail();
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userAccount.getPassword();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.stream(userAccount
                .getRole()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
