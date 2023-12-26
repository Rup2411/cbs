package com.busybox.cbs.dto.response;

import lombok.Data;

@Data
public class MemberResponseDto {

	private String Status;
	
	private String isSuccessfull;
	
	private String ErrorMessageIfAny;
}
