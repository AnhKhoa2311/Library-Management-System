package com.example.demo.Service;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import com.example.demo.Model.LoanCard;

public interface LoanCardService {
	public java.util.List<LoanCard> allLoanCards();
	public void addLoanCards(LoanCard loanCard);
}
