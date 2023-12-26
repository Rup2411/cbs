package com.busybox.cbs.dto;

import com.busybox.cbs.model.enums.Duration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingPlanMasterDto {

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

