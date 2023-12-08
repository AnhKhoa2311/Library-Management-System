package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.SecurityUserAccount;
import com.example.demo.Model.Student;
import com.example.demo.Model.UserAccount;
import com.example.demo.Repository.UserAccountRepository;

@Service
public class UserAccountServiceImple implements UserAccountService, UserDetailsService {
	@Autowired
	protected UserAccountRepository userAccountRepo;
	
	protected BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserAccount createAccount(UserAccount account) {
		return userAccountRepo.save(account);
	}
	
	// CANCEL authenticateUserAccount METHOD, USE THE loadByUsername METHOD
	@Override
	public boolean authenticateUserAccount(UserAccount account) {
		if(userAccountRepo.authenticateAccount(account.getEmail(), pwEncoder.encode(account.getPassword())) > 0) {
			return true;
		}
		return false;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserAccount userAccount = userAccountRepo.findUserByEmail(email);
		if(userAccount == null) {
			throw new UsernameNotFoundException("Don't have email: " + email + " in database!");
		}
		UserDetails userDetails = User.builder()
				.username(email)
				.password(userAccount.getPassword())
				.roles(userAccount.getRole())
				.build();
		return userDetails;
	}

	@Override
	public UserAccount getUserAccountInformation(String email) {
		return userAccountRepo.findUserByEmail(email);
	}

	@Override
	public Student getInformations(long id) {
		return userAccountRepo.getInformations(id);
	}
	
}
