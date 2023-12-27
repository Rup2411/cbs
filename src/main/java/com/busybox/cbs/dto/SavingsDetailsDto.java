package com.busybox.cbs.dto;

import java.time.LocalDateTime;

import com.busybox.cbs.model.enums.FamilyRelation;
import com.busybox.cbs.model.enums.ModeOfOperation;
import com.busybox.cbs.model.enums.PaymentMethods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingsDetailsDto {

	private long id;
    private LocalDateTime openingDate;
    
    
    private long memberId; // Corresponds to selectByMember in SavingDetails
    private String memberName;
    private LocalDateTime dateOfBirth;
    private String relativeName;
    private String mobileNo;
    private String address;
    private String district;
    private String state;
    private String branchName;
    private String pinCode;
    private ModeOfOperation modeOfOperation;
    private String jointSurvivorCode;
    private String jointSurvivorName;
    private FamilyRelation relation;
    
    
    private long planId; // Corresponds to selectPlan in SavingDetails
    private double openingAmount;
    private String advisorCollectorCode;
    private String advisorCollectorName;
    private double openingFees;
}
