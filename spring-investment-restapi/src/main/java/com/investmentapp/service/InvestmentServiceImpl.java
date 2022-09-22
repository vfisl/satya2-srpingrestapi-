package com.investmentapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;

@Service
public class InvestmentServiceImpl implements IInvestmentService {

	
	IInvestmentRepository investmentRepository;
	@Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}
	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.save(investment);
		
	}
	@Override
	public void updateInvestment(Investment investment) throws PlanNotFoundException {
		investmentRepository.save(investment);
		
	}
	@Override
	public void deleteInvestment(int planID) {
		investmentRepository.deleteById(planID);
		
	}
	@Override
	public List<Investment> getByType(String type) {
		List<Investment>investments=investmentRepository.findByType(type);
		if(investments.isEmpty())
			throw new PlanNotFoundException("plan with this term not found");
		return investments;
	}
	@Override
	public List<Investment> getByPurpose(String purpose) {
		List<Investment>investments=investmentRepository.findByPurpose(purpose);
		if(investments.isEmpty()) {
			throw new PlanNotFoundException("plan with this term not found");
		}
		return investments;
	}
	@Override
	public List<Investment> getAll() {
		// TODO Auto-generated method stub
		return investmentRepository.findAll();
	}
	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		List<Investment>investments=investmentRepository.findByRiskAndTerm(risk, term);
		if(investments.isEmpty())
			throw new PlanNotFoundException("plan with this term not found");
		return investments;
	}
	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Investment getByID(int planId) throws PlanNotFoundException {
      return investmentRepository.findById(planId).orElseThrow(()->new PlanNotFoundException("invalid id"));
	}
	@Override
	@Transactional
	public void updateInvestmentAmount(int planId, double amount) {
		
		investmentRepository.updateInvestment(planId, amount);
	}

	
}
