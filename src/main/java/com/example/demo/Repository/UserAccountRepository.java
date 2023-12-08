package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.SecurityUserAccount;
import com.example.demo.Model.Student;
import com.example.demo.Model.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
	@Query("SELECT COUNT(uc) FROM UserAccount uc WHERE uc.email = ?1 AND uc.password = ?2")
	Integer authenticateAccount(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT uc FROM UserAccount uc WHERE uc.email = ?1")
	UserAccount findUserByEmail(@Param("username") String email); 
	@Query("SELECT st FROM Student st WHERE st.account.id = ?1")
	Student getInformations(@Param("id") long id);
}
