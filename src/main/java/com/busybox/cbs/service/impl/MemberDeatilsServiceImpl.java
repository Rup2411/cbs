package com.busybox.cbs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.MemberDetailsRepo;
import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.dto.response.MemberResponseDto;
import com.busybox.cbs.exception.DeatilsNullOrMissingException;
import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;
import com.busybox.cbs.service.MemberDeatilsService;
import com.busybox.cbs.service.ProjectService;
import com.busybox.cbs.service.impl.helper.MemberDetailsAddHelper;

@Service
public class MemberDeatilsServiceImpl implements ProjectService<MemberRequestDto, Long>,
												 MemberDeatilsService 
												 {
	@Autowired private AddMember addMember;
	@Autowired private MemberDetailsAddHelper memberDetailsAddHelper;
	
	
	
	
	@Override
	public List<MemberRequestDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MemberRequestDto> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public MemberResponseDto addMembersFinal(MemberRequestDto memberRequestDto) {

		memberRequestDto.validateAndExtractDetails(
		        memberDetails -> memberDetailsAddHelper.validateAllInfoRequired(memberDetails, 
		                                                                       memberRequestDto.getNomineeDetails(), 
		                                                                       memberRequestDto.getFees_SettingDetails()),
		        nomineeDetails -> {}, 
		        fees_SettingDetails -> {} 
		    );
	    try {
	        addMember.saveMemberWithDetails(
	            memberRequestDto.getMemberDetails(),
	            memberRequestDto.getNomineeDetails(),
	            memberRequestDto.getFees_SettingDetails()
	        );
	        return new MemberResponseDto("Success", "Yes", null);

	    } catch (Exception e) {
	        return new MemberResponseDto("Failure", "No", e.getMessage());
	    }
	}

	@Override
	public void create(MemberRequestDto entity) {
	    if (entity == null) throw new DeatilsNullOrMissingException("Member Details Missing", "");
	    addMembersFinal(entity);
	}


	@Override
	public MemberRequestDto update(Long id, MemberRequestDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<MemberRequestDto> findAllPaginated(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberRequestDto> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
