package com.busybox.cbs.service;

import org.springframework.stereotype.Component;

import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.dto.response.MemberResponseDto;
// response
@Component
public interface MemberDeatilsService {

	public MemberResponseDto addMembersFinal(MemberRequestDto memberRequestDto);
}
