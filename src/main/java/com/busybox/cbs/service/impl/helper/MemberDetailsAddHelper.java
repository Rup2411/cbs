package com.busybox.cbs.service.impl.helper;

import org.springframework.stereotype.Component;
import com.busybox.cbs.exception.DeatilsNullOrMissingException;
import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;

@Component
public class MemberDetailsAddHelper {

    public void validateAllInfoRequired(MemberDetails memberDetails, NomineeDetails nomineeDetails,
                                        Fees_SettingDetails fees_SettingDetails) {
        // Validate each entity
        if (!isMemberDetailsValid(memberDetails)) {
            throw new DeatilsNullOrMissingException("Member Details are incomplete or missing");
        }
        if (!isNomineeDetailsValid(nomineeDetails)) {
            throw new DeatilsNullOrMissingException("Nominee Details are incomplete or missing");
        }
        if (!isFeesSettingDetailsValid(fees_SettingDetails)) {
            throw new DeatilsNullOrMissingException("Fees Setting Details are incomplete or missing");
        }
    }

    private boolean isMemberDetailsValid(MemberDetails details) throws DeatilsNullOrMissingException {
        if (details == null) {
            throw new DeatilsNullOrMissingException("Member Details are required");
        }
        
        if (details.getRegistrationDate() == null) {
            throw new DeatilsNullOrMissingException("Registration Date is required");
        }
        if (details.getMemberName() == null) {
        	throw new DeatilsNullOrMissingException("Member Name is required");
        }
        if (details.getDateofBirth() == null) {
        	throw new DeatilsNullOrMissingException("Date Of Birth is required");
        }
        if (details.getAddress() == null) {
        	throw new DeatilsNullOrMissingException("Address is required");
        }
        if (details.getDistrict() == null) {
        	throw new DeatilsNullOrMissingException("District is required");
        }
        if (details.getState() == null) {
        	throw new DeatilsNullOrMissingException("State is required");
        }
        if (details.getBranchName() == null) {
        	throw new DeatilsNullOrMissingException("Branch Name is required");
        }
        if (details.getPinCode() == null) {
        	throw new DeatilsNullOrMissingException("Pincode is required");
        }
        if (details.getAadharNumber() == null) {
        	throw new DeatilsNullOrMissingException("Aadhar Number is required");
        }
        if (details.getMobileNo() == null) {
        	throw new DeatilsNullOrMissingException("Mobile Number is required");
        }
        return true;
    }


    private boolean isNomineeDetailsValid(NomineeDetails details) {
    	if (details == null) {
            throw new DeatilsNullOrMissingException("Nominee Details are required");
        }
    	
    	if (details.getName()== null) {
        	throw new DeatilsNullOrMissingException("Nominee Name is required");
        }
    	return true;
    }

    private boolean isFeesSettingDetailsValid(Fees_SettingDetails details) {
    	if (details == null) {
            throw new DeatilsNullOrMissingException("Fees Setting Details are required");
        }
    	
    	if (details.getMemberFees()== null) {
        	throw new DeatilsNullOrMissingException("Member Fees is required");
        }
    	if (details.getShareAlortedFrom()== null) {
    		throw new DeatilsNullOrMissingException("Share Alorted From is required");
    	}
    	if (details.getNoOfShares()== null) {
    		throw new DeatilsNullOrMissingException("Number of Shares are required");
    	}
    	if (details.getMemberFees()== null) {
    		throw new DeatilsNullOrMissingException("Nominee Name is required");
    	}
    	if (details.getShareAmount()== null) {
    		throw new DeatilsNullOrMissingException("Share Amount is required");
    	}
    	
    	return true;
    }
}
