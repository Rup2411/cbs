package com.busybox.cbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.SavingPlanMasterRepo;
import com.busybox.cbs.dto.SavingPlanMasterDto;
import com.busybox.cbs.model.SavingPlanMaster;
import com.busybox.cbs.service.SavingPlanMasterService;

@Service
public class ServicePlanMasterImpl implements SavingPlanMasterService {

	
	@Autowired
	SavingPlanMasterRepo planRepo;
	
	@Override
    public SavingPlanMasterDto createPlan(SavingPlanMasterDto savingPlanMasterDto) {
        SavingPlanMaster entity = toEntity(savingPlanMasterDto);
        entity = planRepo.saveAndFlush(entity);
        return toDTO(entity);
    }

	@Override
    public SavingPlanMasterDto updatePlan(long id, SavingPlanMasterDto savingPlanMasterDto) {
        SavingPlanMaster existingEntity = planRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Plan not found")); // Replace with a custom exception if necessary
        updateEntity(existingEntity, savingPlanMasterDto);
        existingEntity = planRepo.saveAndFlush(existingEntity);
        return toDTO(existingEntity);
    }

    @Override
    public SavingPlanMasterDto getPlanById(long id) {
        SavingPlanMaster entity = planRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Plan not found")); // Replace with a custom exception
        return toDTO(entity);
    }
    
    private void updateEntity(SavingPlanMaster entity, SavingPlanMasterDto dto) {
        // Set fields from DTO to entity, excluding ID
        entity.setSchemeName(dto.getSchemeName());
        entity.setAnnualROI(dto.getAnnualROI());
        entity.setMinOpeningAmount(dto.getMinOpeningAmount());
        entity.setMonthlyAvgBalance(dto.getMonthlyAvgBalance());
        entity.setLockInBalance(dto.getLockInBalance());
        entity.setSmsCharges(dto.getSmsCharges());
        entity.setSmsInterval(dto.getSmsInterval());
        entity.setFreeIFSCCollectionPerMonth(dto.getFreeIFSCCollectionPerMonth());
        entity.setFreeTransfersPerMonth(dto.getFreeTransfersPerMonth());
        entity.setSingleTransactionLimit(dto.getSingleTransactionLimit());
        entity.setDailyMaxLimit(dto.getDailyMaxLimit());
        entity.setWeeklyMaxLimit(dto.getWeeklyMaxLimit());
        entity.setMonthlyMaxLimit(dto.getMonthlyMaxLimit());
        entity.setServiceCharges(dto.getServiceCharges());
        entity.setServiceInterval(dto.getServiceInterval());
        entity.setCardCharge(dto.getCardCharge());
        entity.setCardLimitMonthly(dto.getCardLimitMonthly());
        entity.setCardTotalLimitYearly(dto.getCardTotalLimitYearly());
        // ... other field updates
    }

	public static SavingPlanMaster toEntity(SavingPlanMasterDto dto) {
        SavingPlanMaster entity = new SavingPlanMaster();
        entity.setSchemeName(dto.getSchemeName());
        entity.setAnnualROI(dto.getAnnualROI());
        entity.setMinOpeningAmount(dto.getMinOpeningAmount());
        entity.setMonthlyAvgBalance(dto.getMonthlyAvgBalance());
        entity.setLockInBalance(dto.getLockInBalance());
        entity.setSmsCharges(dto.getSmsCharges());
        entity.setSmsInterval(dto.getSmsInterval());
        entity.setFreeIFSCCollectionPerMonth(dto.getFreeIFSCCollectionPerMonth());
        entity.setFreeTransfersPerMonth(dto.getFreeTransfersPerMonth());
        entity.setSingleTransactionLimit(dto.getSingleTransactionLimit());
        entity.setDailyMaxLimit(dto.getDailyMaxLimit());
        entity.setWeeklyMaxLimit(dto.getWeeklyMaxLimit());
        entity.setMonthlyMaxLimit(dto.getMonthlyMaxLimit());
        entity.setServiceCharges(dto.getServiceCharges());
        entity.setServiceInterval(dto.getServiceInterval());
        entity.setCardCharge(dto.getCardCharge());
        entity.setCardLimitMonthly(dto.getCardLimitMonthly());
        entity.setCardTotalLimitYearly(dto.getCardTotalLimitYearly());
        // ... set other fields
        return entity;
     }
	
	public static SavingPlanMasterDto toDTO(SavingPlanMaster entity) {
		SavingPlanMasterDto dto = new SavingPlanMasterDto();
        dto.setSchemeName(entity.getSchemeName());
        dto.setAnnualROI(entity.getAnnualROI());
        dto.setMinOpeningAmount(entity.getMinOpeningAmount());
        dto.setMonthlyAvgBalance(entity.getMonthlyAvgBalance());
        dto.setLockInBalance(entity.getLockInBalance());
        dto.setSmsCharges(entity.getSmsCharges());
        dto.setSmsInterval(entity.getSmsInterval());
        dto.setFreeIFSCCollectionPerMonth(entity.getFreeIFSCCollectionPerMonth());
        dto.setFreeTransfersPerMonth(entity.getFreeTransfersPerMonth());
        dto.setSingleTransactionLimit(entity.getSingleTransactionLimit());
        dto.setDailyMaxLimit(entity.getDailyMaxLimit());
        dto.setWeeklyMaxLimit(entity.getWeeklyMaxLimit());
        dto.setMonthlyMaxLimit(entity.getMonthlyMaxLimit());
        dto.setServiceCharges(entity.getServiceCharges());
        dto.setServiceInterval(entity.getServiceInterval());
        dto.setCardCharge(entity.getCardCharge());
        dto.setCardLimitMonthly(entity.getCardLimitMonthly());
        dto.setCardTotalLimitYearly(entity.getCardTotalLimitYearly());
        // ... set other fields
        return dto;
    }
}
