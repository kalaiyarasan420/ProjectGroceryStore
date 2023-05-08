package com.EducationalLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EducationalLoan.model.LoanApplicationModel;
import com.EducationalLoan.service.LoanApplicationService;

@RestController
public class LoanApplicationController {

	@Autowired
	LoanApplicationService loanSer;
	
	@GetMapping(value="/fetchLoan")
	public List<LoanApplicationModel> getAllLoan()
	{
		return loanSer.getAllLoan();
	}
	
	@PostMapping(value="/saveLoan")
	public LoanApplicationModel saveLoan(@RequestBody LoanApplicationModel a)
	{
		return loanSer.saveLoan(a);
		
	}
	
	@PutMapping(value="/updateLoan/{loanId}")
	public LoanApplicationModel updateLoan(@RequestBody LoanApplicationModel a, @PathVariable int loanId)
	{
		return loanSer.updateLoan(a,loanId);
		
	}
	
	@DeleteMapping("/deleteLoan/{loanId}")
	public void deleteLoan(@PathVariable("loanId") int loanId)
	{
		loanSer.deleteLoan(loanId);
		
	}
	
	@GetMapping(value="/getLoanById/{loanId}")
	public LoanApplicationModel getLoanById(@PathVariable("loanId") int loanId)
	{
		return loanSer.getLoanById(loanId);
		
	}
	
	@PutMapping(value="/updateLoanById/{loanId}")
	public LoanApplicationModel updateLoanById(@RequestBody LoanApplicationModel a, @PathVariable int loanId)
	{
		return loanSer.updateLoanById(a,loanId);
		
	}
}
