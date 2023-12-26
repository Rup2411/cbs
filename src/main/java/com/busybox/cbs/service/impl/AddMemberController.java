package com.busybox.cbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.Fees_SettingDetailsRepo;
import com.busybox.cbs.dao.MemberDetailsRepo;
import com.busybox.cbs.dao.NomineeDetailsRepo;
import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;

import jakarta.transaction.Transactional;

@Service
public class AddMemberController {
	
	@Autowired private MemberDetailsRepo memberDetailsRepo;
	@Autowired private Fees_SettingDetailsRepo fees_SettingDetailsRepo;
	@Autowired private NomineeDetailsRepo nomineeDetailsRepo;
	
	
	@Transactional
    public void createMemberWithDetails(MemberDetails memberDetails, 
                                        Fees_SettingDetails feesSettingDetails, 
                                        NomineeDetails nomineeDetails) {
        // Save MemberDetails first to generate the ID
		memberDetailsRepo.save(memberDetails);

        // Associate and save Fees_SettingDetails
        feesSettingDetails.setMapid(memberDetails);
        fees_SettingDetailsRepo.save(feesSettingDetails);

        // Associate and save NomineeDetails
        nomineeDetails.setMapid(memberDetails);
        nomineeDetailsRepo.save(nomineeDetails);
    }

}
