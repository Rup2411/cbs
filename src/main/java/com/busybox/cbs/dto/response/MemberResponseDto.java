package com.busybox.cbs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {

	private String Status;
	
	private String isSuccessfull;
	
	private String ErrorMessageIfAny;
}
