package com.busybox.cbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.Fees_SettingDetailsRepo;
import com.busybox.cbs.dao.MemberDetailsRepo;
import com.busybox.cbs.dao.NomineeDetailsRepo;
import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.exception.CustomException;
import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;

import jakarta.transaction.Transactional;

@Service
public class AddMember {
	
	@Autowired private MemberDetailsRepo memberDetailsRepo;
	@Autowired private Fees_SettingDetailsRepo fees_SettingDetailsRepo;
	@Autowired private NomineeDetailsRepo nomineeDetailsRepo;
	
	
	@Transactional
    public void saveMemberWithDetails(MemberDetails memberDetails, 
                                        NomineeDetails nomineeDetails,
                                        Fees_SettingDetails feesSettingDetails ) {
		try {

			memberDetailsRepo.save(memberDetails);

	        feesSettingDetails.setMapid(memberDetails);
	        fees_SettingDetailsRepo.save(feesSettingDetails);

	        nomineeDetails.setMapid(memberDetails);
	        nomineeDetailsRepo.save(nomineeDetails);
//	        return null;
	    
		} catch (Exception e) {
			throw new CustomException("Internal Server Error");
		}
	}

}
