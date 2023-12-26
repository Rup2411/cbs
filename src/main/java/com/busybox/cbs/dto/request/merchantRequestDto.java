package com.busybox.cbs.dto.request;

import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;

import lombok.Data;

@Data
public class merchantRequestDto {

	private MemberDetails memberDetails;
	
	private NomineeDetails nomineeDetails;
	
	private Fees_SettingDetails fees_SettingDetails;


}
