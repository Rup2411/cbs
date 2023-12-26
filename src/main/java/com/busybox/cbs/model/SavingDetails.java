package com.busybox.cbs.model;

import java.time.LocalDateTime;

import com.busybox.cbs.model.enums.FamilyRelation;
import com.busybox.cbs.model.enums.ModeOfOperation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SavingDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime openingDate = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private MemberDetails selectByMember;
	
	private String memberName;
    private LocalDateTime dateofBirth;
    private String relativeName;
    private String mobileNo;
    private String Address;
	private String district ;
	private String state ;
	
	private String branchName;
    private String pinCode;
    
    private ModeOfOperation modeOfOperation;
    
    private String jointSurvivorCode;
    private String jointSurvivorName;
    
    private FamilyRelation relation;
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private SavingPlanMaster selectPlan;
    
    private double openingAmount;
    private String advisorCollectorCode;
    private String advisorCollectorName;
    private double openingFees;

    
}
