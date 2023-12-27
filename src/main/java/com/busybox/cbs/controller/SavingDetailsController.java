package com.busybox.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busybox.cbs.dto.SavingsDetailsDto;
import com.busybox.cbs.dto.response.CombinedSavingsDto;
import com.busybox.cbs.service.SavingDetailsService;

@RestController
@RequestMapping("/api/account")
public class SavingDetailsController {

	@Autowired
	SavingDetailsService savingService;
	
	
	@PostMapping("/create")
	ResponseEntity<?> addSavingsAccount(@RequestBody CombinedSavingsDto dto){
		
		CombinedSavingsDto savedAccount = savingService.addSavingsAccount(dto.getSavingsDetailsDto(), dto.getPaymentDetailsDto());
		
		return ResponseEntity.ok(savedAccount);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<?> updateAccount(@PathVariable long id, @RequestBody SavingsDetailsDto savingDto){
		
		SavingsDetailsDto updatedAccount = savingService.updateSavingsAccount(id, savingDto);
		
		return ResponseEntity.ok(updatedAccount);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<?> getSavingsAccountById(@PathVariable long id){
		
		SavingsDetailsDto savingsAccount = savingService.getSavingsAccountById(id);
		
		return ResponseEntity.ok(savingsAccount);
	}
	
}
