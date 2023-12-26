package com.busybox.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busybox.cbs.dto.SavingPlanMasterDto;
import com.busybox.cbs.service.SavingPlanMasterService;

@RestController
@RequestMapping("/api")
public class SavingsPlanController {

	@Autowired
    SavingPlanMasterService savingPlanMasterService;

    @PostMapping("/createPlan")
    public ResponseEntity<SavingPlanMasterDto> createPlan(@RequestBody SavingPlanMasterDto savingPlanMasterDto) {
        
    	SavingPlanMasterDto createdPlan = savingPlanMasterService.createPlan(savingPlanMasterDto);
        
        return ResponseEntity.ok(createdPlan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SavingPlanMasterDto> updatePlan(@PathVariable long id, @RequestBody SavingPlanMasterDto savingPlanMasterDto) {
        
    	SavingPlanMasterDto updatedPlan = savingPlanMasterService.updatePlan(id, savingPlanMasterDto);
        
    	return ResponseEntity.ok(updatedPlan);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SavingPlanMasterDto> getPlanById(@PathVariable long id) {
        
    	SavingPlanMasterDto planDto = savingPlanMasterService.getPlanById(id);
        
    	return ResponseEntity.ok(planDto);
    }
}
