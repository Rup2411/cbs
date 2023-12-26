package com.busybox.cbs.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.busybox.cbs.exception.ValidationException;
import com.busybox.cbs.model.enums.FamilyRelation;
import com.busybox.cbs.model.enums.Gender;
import com.busybox.cbs.model.enums.MaritalStatus;
import com.busybox.cbs.model.enums.NamePrefix;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class MemberDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(mappedBy = "model1", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Fees_SettingDetails model2;

    @OneToOne(mappedBy = "model1", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private NomineeDetails model3;
	
	private boolean verifyWith;
	private LocalDateTime registrationDate;
	private NamePrefix namePrefix;
	
	private String memberName;
	private String relativeName;
	private FamilyRelation Relativerelation;
	
	private Gender gender;
	private LocalDateTime dateofBirth;
	private MaritalStatus maritalStatus;
	
	private String Address;
	private String district ;
	private String state ;
	
	private String branchName;
	
	private String pinCode;
	private String aadharNumber;
	private String panNumber;
	private String voterNumber;
	private String mobileNo;
	private String emailId;

	private String Occupation;
	private String Education;
	
	private String introMemberCode;
	private String introMemberName;
	private String photoWithAadhar;
	// Date time created on/ updated on
	@JsonIgnore
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime CreatedOn; 
    @JsonIgnore
    private String CreatedBy;
    
    @JsonIgnore
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime UpdatedOn;
    
    @JsonIgnore
    private String UpdatedBy;
	
	public void setPinCode(String pinCode) {
        if (!pinCode.matches("\\d{6}")) {
            throw new ValidationException("Pin Code should be exactly 6 digits");
        }
        this.pinCode = pinCode;
    }

    public void setAadharNumber(String aadharNumber) {
        if (!aadharNumber.matches("^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$")) {
            throw new ValidationException("Aadhar Number should be 12 digits and not start with 0 or 1");
        }
        this.aadharNumber = aadharNumber;
    }

    public void setPanNumber(String panNumber) {
        if (!panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            throw new ValidationException("PAN Number should be 5 uppercase letters followed by 4 digits and an uppercase letter");
        }
        this.panNumber = panNumber;
    }

    public void setVoterNumber(String voterNumber) {
        if (!voterNumber.matches("[A-Z]{1}[A-Z0-9]{8}[0-9]{1}")) {
            throw new ValidationException("Voter Number should start with an uppercase letter, followed by 8 alphanumeric characters, and end with a digit");
        }
        this.voterNumber = voterNumber;
    }

    public void setMobileNo(String mobileNo) {
        if (!mobileNo.matches("[6789]\\d{9}")) {
            throw new ValidationException("Mobile Number should be 10 digits and start with 6, 7, 8, or 9");
        }
        this.mobileNo = mobileNo;
    }

    public void setEmailId(String emailId) {
        if (!emailId.matches("\\S+@\\S+\\.\\S+")) {
            throw new ValidationException("Email ID is not valid");
        }
        this.emailId = emailId;
    }
}
