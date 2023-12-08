package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Student;
import com.example.demo.Model.UserAccount;

public interface UserAccountService {
	public UserAccount createAccount(UserAccount account);
	public boolean authenticateUserAccount(UserAccount account);
	public UserAccount getUserAccountInformation(String email);
	public Student getInformations(long id);
}
