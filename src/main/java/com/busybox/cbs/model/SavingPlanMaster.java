package com.busybox.cbs.model;

import com.busybox.cbs.model.enums.Duration;

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
public class SavingPlanMaster {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String schemeName;
    private float annualROI;
    private double minOpeningAmount;
    private double monthlyAvgBalance;
    private double lockInBalance;
    private double smsCharges;
    private Duration smsInterval;
    private int freeIFSCCollectionPerMonth;
    private int freeTransfersPerMonth;
    private double singleTransactionLimit;
    private double dailyMaxLimit;
    private double weeklyMaxLimit;
    private double monthlyMaxLimit;
    private double serviceCharges;
    private Duration serviceInterval;
    private double cardCharge;
    private double cardLimitMonthly;
    private double cardTotalLimitYearly;

}
