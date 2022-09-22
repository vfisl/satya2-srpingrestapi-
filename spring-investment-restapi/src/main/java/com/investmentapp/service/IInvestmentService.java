package com.investmentapp.service;

import java.util.List;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;

public interface IInvestmentService {

	
	void addInvestment(Investment investment);
	void updateInvestment(Investment  investmet)throws PlanNotFoundException;
	void deleteInvestment(int planID);
	List<Investment> getByType(String type);
	List<Investment> getByPurpose(String purpose);
	List<Investment> getAll();
	List<Investment> getByRiskAndTerm(String risk,int term);
	double calculateMaturity(Investment investment);
	Investment getByID(int planId)throws PlanNotFoundException;
	void updateInvestmentAmount(int planId,double amount);
	
}
