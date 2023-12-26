package com.busybox.cbs.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.busybox.cbs.model.enums.FamilyRelation;
import com.busybox.cbs.model.enums.NomineeKYCType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class NomineeDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String Name;
	private FamilyRelation nomineeRelation;
	private String Address;
	private String kycNumber;
	private String MobileNumber;
	private String Age;
	private NomineeKYCType kycType;
	
	
	
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
}
