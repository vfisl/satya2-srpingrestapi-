package com.investmentapp.controllers;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;

@RestController
public class InvestmentResponseController {
	@Autowired
	IInvestmentService iInvestmentService;
	@PostMapping("/investments")
	public ResponseEntity<String> addInvestment(@RequestBody Investment investment)
	{
		
		iInvestmentService.addInvestment(investment);
		return ResponseEntity.accepted().body("updated");
	}
	@PutMapping("/investments")
	void updateInvestment(@RequestBody Investment  investmet)
	{
		iInvestmentService.updateInvestment(investmet);
	}
	@DeleteMapping("/investments/{planId}")
	public ResponseEntity<Void> deleteInvestment(@PathVariable("planId") int planID)
	{
		
		iInvestmentService.deleteInvestment(planID);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping("/investemnts/type")
	ResponseEntity< List<Investment>> getByType(@RequestParam ("type") String type)
	{
		List<Investment>investments=iInvestmentService.getByType(type);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "All investment by risk and term");
		headers.add("info", "Investment rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
	}
	@GetMapping("/investments/purpose/{purpose}")
	ResponseEntity< List<Investment>> getByPurpose(@PathVariable("purpose") String purpose)
	{

		List<Investment>investments=iInvestmentService.getByPurpose(purpose);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "All investment by risk and term");
		headers.add("info", "Investment rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
	}
	//https://localhost:8080/investmetns
	@GetMapping("/investments")
	ResponseEntity< List<Investment>> getAll()
	{
		List<Investment>investmentvs=iInvestmentService.getAll();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "getting investments");
		headers.add("info", "collecting data from db");
		ResponseEntity<List<Investment>>responseEntity=new ResponseEntity<List<Investment>>(investmentvs, headers, HttpStatus.OK);
		return responseEntity;
	}
	//https://investments/
	@GetMapping("/investments/risk/{risk}/term/{term}")
	ResponseEntity < List<Investment>> getByRiskAndTerm(@PathVariable("risk") String risk,@PathVariable("term") int term)
	{
		List<Investment>investments=iInvestmentService.getByRiskAndTerm(risk, term);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "All investment by risk and term");
		headers.add("info", "Investment rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);
	}
	@GetMapping("investments/planId/{id}")
	 ResponseEntity<Investment>  getByID(@PathVariable("id") int planId)
	{
		Investment investment=iInvestmentService.getByID(planId);
		HttpHeaders headres=new HttpHeaders();
		headres.add("desc","getting one innvestment by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headres).body(investment);
	}
	@GetMapping("/investments/planID/{id}/amount/{amount}")
	ResponseEntity <Void> updateInvestmet(@PathVariable("id") int planId,@PathVariable("amount") double amount)
	{
		iInvestmentService.updateInvestmentAmount(planId, amount);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
