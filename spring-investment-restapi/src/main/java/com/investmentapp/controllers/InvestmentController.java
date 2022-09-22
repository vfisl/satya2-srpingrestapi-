package com.investmentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;

//@RestController
public class InvestmentController {
	@Autowired
	IInvestmentService iInvestmentService;
	@PostMapping("/investments")
	void addInvestment(@RequestBody Investment investment)
	{
		iInvestmentService.addInvestment(investment);
	}
	@PutMapping("/investments")
	void updateInvestment(@RequestBody Investment  investmet)
	{
		iInvestmentService.updateInvestment(investmet);
	}
	@DeleteMapping("/investments/{planId}")
	void deleteInvestment(@PathVariable("planId") int planID)
	{
		iInvestmentService.deleteInvestment(planID);
	}
	@GetMapping("/investemnts/type/{type}")
	List<Investment> getByType(@PathVariable("type") String type)
	{
		return iInvestmentService.getByType(type);
	}
	@GetMapping("/investments/purpose/{purpose}")
	List<Investment> getByPurpose(@PathVariable("purpose") String purpose)
	{
		return iInvestmentService.getByPurpose(purpose);
	}
	//https://localhost:8080/investmetns
	@GetMapping("/investments")
	List<Investment> getAll()
	{
		return iInvestmentService.getAll();
	}
	//https://investments/
	@GetMapping("/investments/risk/{risk}/term/{term}")
	List<Investment> getByRiskAndTerm(@PathVariable("risk") String risk,@PathVariable("term") int term)
	{
		return iInvestmentService.getByRiskAndTerm(risk, term);
	}
	@GetMapping("investments/planId/{id}")
	Investment getByID(@PathVariable("id") int planId)
	{
		return iInvestmentService.getByID(planId);
	}

}
