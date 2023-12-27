package com.busybox.cbs.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.dto.response.MemberResponseDto;
import com.busybox.cbs.model.MemberDetails;
// response
@Component
public interface MemberDeatilsService {

	public MemberResponseDto addMembersFinal(MemberRequestDto memberRequestDto);
	
	
	public List<MemberDetails> findAllMembers();


	public List<BigInteger> getAllPublicId();


	public Optional<MemberDetails> getMerchantById(BigInteger publicId);
}
