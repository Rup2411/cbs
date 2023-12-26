package com.busybox.cbs.model;

import com.busybox.cbs.model.enums.PaymentMethods;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private PaymentMethods paymentBy;
	
	private String remarks;
	
	private boolean accountStatus;
	
	private boolean smsSend;
	
	private boolean debitCardIssue;
}
