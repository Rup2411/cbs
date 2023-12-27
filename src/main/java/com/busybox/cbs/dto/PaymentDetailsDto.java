package com.busybox.cbs.dto;


import com.busybox.cbs.model.enums.PaymentMethods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDto {

    private PaymentMethods paymentBy;
	
	private String remarks;
	
	private boolean accountStatus;
	
	private boolean smsSend;
	
	private boolean debitCardIssue;
}
