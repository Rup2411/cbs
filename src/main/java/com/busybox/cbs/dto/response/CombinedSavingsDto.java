package com.busybox.cbs.dto.response;

import com.busybox.cbs.dto.PaymentDetailsDto;
import com.busybox.cbs.dto.SavingsDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinedSavingsDto {

	private SavingsDetailsDto savingsDetailsDto;
	
	private PaymentDetailsDto paymentDetailsDto; 
	
}
