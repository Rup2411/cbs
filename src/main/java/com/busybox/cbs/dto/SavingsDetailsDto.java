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

	private long savingId;
    private LocalDateTime openingDate;
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
    private double openingAmount;
    private String advisorCollectorCode;
    private String advisorCollectorName;
    private double openingFees;
    
    // Add references to MemberDetails and SavingPlanMaster if needed
    // private MemberDetailsDto memberDetails;
    // private SavingPlanMasterDto savingPlan;

    // Fields from PaymentDetails
    private long paymentId;
    private PaymentMethods paymentBy;
    private String remarks;
    private boolean accountStatus;
    private boolean smsSend;
    private boolean debitCardIssue;
}
