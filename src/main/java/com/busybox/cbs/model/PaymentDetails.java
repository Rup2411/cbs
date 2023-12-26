package com.busybox.cbs.model;

import com.busybox.cbs.model.enums.PaymentBy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PaymentDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private PaymentBy paymentBy;
	
	private String remarks;
	
	private boolean accountStatus;
	
	private boolean smsSend;
	
	private boolean debitCardIssue;
}
