package com.esgreport.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.entity.Bank;
import com.esgreport.repository.BankRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/banks")
public class BanksController {
	
	@Autowired
	BankRepository bankRepository;
	
	@GetMapping(value="/getbanks", produces = MediaType.ALL_VALUE)
	public String getBanks () {
		
		return "bankRepository.findAll()";
	}
	
	@GetMapping(value ="/getbank/{bankName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBankByName(@PathVariable String bankName) {
		return bankRepository.findByName(bankName);
	}
	
	@GetMapping(value ="/getbank/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Bank> getBankById(@PathVariable Long id){
		return bankRepository.findById(id);
	}
}