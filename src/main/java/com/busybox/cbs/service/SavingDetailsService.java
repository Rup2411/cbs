package com.busybox.cbs.service;

import com.busybox.cbs.dto.PaymentDetailsDto;
import com.busybox.cbs.dto.SavingsDetailsDto;
import com.busybox.cbs.dto.response.CombinedSavingsDto;

public interface SavingDetailsService {

	CombinedSavingsDto addSavingsAccount(SavingsDetailsDto savingDto, PaymentDetailsDto paymentDto);
	
	SavingsDetailsDto updateSavingsAccount(long id, SavingsDetailsDto savingDto);
	
	SavingsDetailsDto getSavingsAccountById(long id);
}
