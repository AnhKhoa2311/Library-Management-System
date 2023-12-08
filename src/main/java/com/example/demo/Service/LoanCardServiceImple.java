package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.LoanCard;
import com.example.demo.Repository.LoanCardRepository;

@Service
public class LoanCardServiceImple implements LoanCardService {
	@Autowired
	protected LoanCardRepository loanCardsRepository;
	@Override
	public List<LoanCard> allLoanCards() {
		return loanCardsRepository.findAll();
	}
	@Override
	public void addLoanCards(LoanCard loanCard) {
		// TODO Auto-generated method stub
		loanCardsRepository.save(loanCard);
	}

}
