package com.busybox.cbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.MemberDetailsRepo;
import com.busybox.cbs.dao.PaymentDetailsRepo;
import com.busybox.cbs.dao.SavingDetailsRepo;
import com.busybox.cbs.dao.SavingPlanMasterRepo;
import com.busybox.cbs.dto.PaymentDetailsDto;
import com.busybox.cbs.dto.SavingsDetailsDto;
import com.busybox.cbs.dto.response.CombinedSavingsDto;
import com.busybox.cbs.model.PaymentDetails;
import com.busybox.cbs.model.SavingDetails;
import com.busybox.cbs.service.SavingDetailsService;

@Service
public class SavingDetailsServiceImpl implements SavingDetailsService {

	
	@Autowired
	SavingDetailsRepo savingRepo;
	
	@Autowired
	MemberDetailsRepo memberRepo;
	
	@Autowired
	SavingPlanMasterRepo planRepo;
	
	@Autowired
	PaymentDetailsRepo paymentRepo;
	
	@Override
	public CombinedSavingsDto addSavingsAccount(SavingsDetailsDto savingDto, PaymentDetailsDto paymentDto) {

		SavingDetails savingDetails = convertToEntity(savingDto);
		PaymentDetails paymentDetails = paymentToEntity(paymentDto);
		
		SavingDetails savedSavingDetails = savingRepo.saveAndFlush(savingDetails);
		PaymentDetails savedPaymentDetails = paymentRepo.saveAndFlush(paymentDetails);
		
		SavingsDetailsDto savedSavingDto = convertToDto(savedSavingDetails);
		PaymentDetailsDto savedPaymentDto = paymentToDto(savedPaymentDetails);
		
		return new CombinedSavingsDto(savedSavingDto, savedPaymentDto);
	}

	@Override
	public SavingsDetailsDto updateSavingsAccount(long id, SavingsDetailsDto savingDto) {

		SavingDetails existingAccount = savingRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Not Found"));
		
		updateEntity(existingAccount, savingDto);
		
		existingAccount = savingRepo.saveAndFlush(existingAccount);
		
		return convertToDto(existingAccount);
	}

	@Override
	public SavingsDetailsDto getSavingsAccountById(long id) {

		SavingDetails savingDetails = savingRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Savings Account Not Found"));
		
		return convertToDto(savingDetails);
	}
	
	public void updateEntity(SavingDetails savingDetails, SavingsDetailsDto dto) {
		
		savingDetails.setOpeningDate(dto.getOpeningDate());
	    savingDetails.setSelectByMember(memberRepo.findById(dto.getMemberId()).orElse(null)); // Handle null appropriately
	    savingDetails.setMemberName(dto.getMemberName());
	    savingDetails.setDateofBirth(dto.getDateOfBirth());
	    savingDetails.setRelativeName(dto.getRelativeName());
	    savingDetails.setMobileNo(dto.getMobileNo());
	    savingDetails.setAddress(dto.getAddress());
	    savingDetails.setDistrict(dto.getDistrict());
	    savingDetails.setState(dto.getState());
	    savingDetails.setBranchName(dto.getBranchName());
	    savingDetails.setPinCode(dto.getPinCode());
	    savingDetails.setModeOfOperation(dto.getModeOfOperation());
	    savingDetails.setJointSurvivorCode(dto.getJointSurvivorCode());
	    savingDetails.setJointSurvivorName(dto.getJointSurvivorName());
	    savingDetails.setRelation(dto.getRelation());
	    savingDetails.setSelectPlan(planRepo.findById(dto.getPlanId()).orElse(null)); // Handle null appropriately
	    savingDetails.setOpeningAmount(dto.getOpeningAmount());
	    savingDetails.setAdvisorCollectorCode(dto.getAdvisorCollectorCode());
	    savingDetails.setAdvisorCollectorName(dto.getAdvisorCollectorName());
	    savingDetails.setOpeningFees(dto.getOpeningFees());
	}
	
	public SavingDetails convertToEntity(SavingsDetailsDto dto) {
	    
	    SavingDetails savingDetails = new SavingDetails();
	    
	    savingDetails.setOpeningDate(dto.getOpeningDate());
	    savingDetails.setSelectByMember(memberRepo.findById(dto.getMemberId()).orElse(null)); // Handle null appropriately
	    savingDetails.setMemberName(dto.getMemberName());
	    savingDetails.setDateofBirth(dto.getDateOfBirth());
	    savingDetails.setRelativeName(dto.getRelativeName());
	    savingDetails.setMobileNo(dto.getMobileNo());
	    savingDetails.setAddress(dto.getAddress());
	    savingDetails.setDistrict(dto.getDistrict());
	    savingDetails.setState(dto.getState());
	    savingDetails.setBranchName(dto.getBranchName());
	    savingDetails.setPinCode(dto.getPinCode());
	    savingDetails.setModeOfOperation(dto.getModeOfOperation());
	    savingDetails.setJointSurvivorCode(dto.getJointSurvivorCode());
	    savingDetails.setJointSurvivorName(dto.getJointSurvivorName());
	    savingDetails.setRelation(dto.getRelation());
	    savingDetails.setSelectPlan(planRepo.findById(dto.getPlanId()).orElse(null)); // Handle null appropriately
	    savingDetails.setOpeningAmount(dto.getOpeningAmount());
	    savingDetails.setAdvisorCollectorCode(dto.getAdvisorCollectorCode());
	    savingDetails.setAdvisorCollectorName(dto.getAdvisorCollectorName());
	    savingDetails.setOpeningFees(dto.getOpeningFees());
	    return savingDetails;
	}


	public static SavingsDetailsDto convertToDto(SavingDetails savingDetails) {
		
	    SavingsDetailsDto dto = new SavingsDetailsDto();
	    
	    dto.setOpeningDate(savingDetails.getOpeningDate());
	    dto.setMemberId(savingDetails.getSelectByMember().getId()); // Assuming MemberDetails has an getId() method
	    dto.setMemberName(savingDetails.getMemberName());
	    dto.setDateOfBirth(savingDetails.getDateofBirth());
	    dto.setRelativeName(savingDetails.getRelativeName());
	    dto.setMobileNo(savingDetails.getMobileNo());
	    dto.setAddress(savingDetails.getAddress());
	    dto.setDistrict(savingDetails.getDistrict());
	    dto.setState(savingDetails.getState());
	    dto.setBranchName(savingDetails.getBranchName());
	    dto.setPinCode(savingDetails.getPinCode());
	    dto.setModeOfOperation(savingDetails.getModeOfOperation());
	    dto.setJointSurvivorCode(savingDetails.getJointSurvivorCode());
	    dto.setJointSurvivorName(savingDetails.getJointSurvivorName());
	    dto.setRelation(savingDetails.getRelation());
	    dto.setPlanId(savingDetails.getSelectPlan().getId()); // Assuming SavingPlanMaster has an getId() method
	    dto.setOpeningAmount(savingDetails.getOpeningAmount());
	    dto.setAdvisorCollectorCode(savingDetails.getAdvisorCollectorCode());
	    dto.setAdvisorCollectorName(savingDetails.getAdvisorCollectorName());
	    dto.setOpeningFees(savingDetails.getOpeningFees());
	    return dto;
	}
	
	public PaymentDetails paymentToEntity(PaymentDetailsDto dto) {
		
		PaymentDetails entity = new PaymentDetails();
		
		entity.setPaymentBy(dto.getPaymentBy());
		entity.setRemarks(dto.getRemarks());
		entity.setDebitCardIssue(false);
		entity.setAccountStatus(true);
		entity.setSmsSend(true);
		
		return entity;
	}
	
	public PaymentDetailsDto paymentToDto(PaymentDetails entity) {
		
		PaymentDetailsDto dto = new PaymentDetailsDto();
		
		dto.setPaymentBy(entity.getPaymentBy());
		dto.setRemarks(entity.getRemarks());
		dto.setDebitCardIssue(false);
		dto.setAccountStatus(true);
		dto.setSmsSend(true);
		
		return dto;
	}

}
