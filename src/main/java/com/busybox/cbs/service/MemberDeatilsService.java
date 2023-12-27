package com.busybox.cbs.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.dto.response.MemberResponseDto;
import com.busybox.cbs.model.MemberDetails;
// response
@Component
public interface MemberDeatilsService {

	public MemberResponseDto addMembersFinal(MemberRequestDto memberRequestDto);
	
	
	public List<MemberDetails> findAllMembers();
}
