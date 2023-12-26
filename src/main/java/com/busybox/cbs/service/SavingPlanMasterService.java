package com.busybox.cbs.service;

import com.busybox.cbs.dto.SavingPlanMasterDto;

public interface SavingPlanMasterService {

	SavingPlanMasterDto createPlan(SavingPlanMasterDto savingPlanMasterDto);
	
	SavingPlanMasterDto updatePlan(long id, SavingPlanMasterDto savingPlanMasterDto);
	
	SavingPlanMasterDto getPlanById(long id);
}
