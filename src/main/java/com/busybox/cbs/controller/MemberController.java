package com.busybox.cbs.controller;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busybox.cbs.dto.request.MemberRequestDto;
import com.busybox.cbs.dto.response.MemberResponseDto;
import com.busybox.cbs.exception.CustomException;
import com.busybox.cbs.exception.DeatilsNullOrMissingException;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.service.MemberDeatilsService;
import com.busybox.cbs.service.ProjectService;
import com.busybox.cbs.util.ResponseHandler;


@RestController
@RequestMapping("api/member")
public class MemberController {

	private final ProjectService<MemberRequestDto, Long> projectService; 
	private final MemberDeatilsService memberDetailsService;

    @Autowired
    public MemberController(MemberDeatilsService memberDetailsService,ProjectService<MemberRequestDto, Long> projectService) {
        this.memberDetailsService = memberDetailsService;
        this.projectService = projectService;
    }
    
	@GetMapping("hello")
	public String hello() {return "hello";}
    
	 @PostMapping("/add")
	    public ResponseEntity<MemberResponseDto> addMember(@RequestBody MemberRequestDto memberRequestDto) {
	        try {
	            MemberResponseDto response = memberDetailsService.addMembersFinal(memberRequestDto);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            // Handle different exceptions if necessary
	            return ResponseEntity.badRequest().body(new MemberResponseDto("Failure", "No", e.getMessage()));
	        }
	    }
	 
	 @PostMapping("/create")
	 public ResponseEntity<String> createMember(@RequestBody MemberRequestDto memberRequestDto) {
	     try {
	    	 projectService.create(memberRequestDto);
	         return ResponseEntity.status(HttpStatus.CREATED).body("Member created successfully");
	     } catch (DeatilsNullOrMissingException e) {
	         return ResponseEntity.badRequest().body("Member creation failed: " + e.getMessage());
	     }
	 }
	 
	 @GetMapping("getall/details")
	 public ResponseEntity<?> getAllMerchantDetails(){
		 try {
			 List<?> response = projectService.getAll();
		return ResponseHandler.generateResponse(response, HttpStatus.OK, "Data fetched");
		 } catch (Exception e) {
			 return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Failed to load data");
		}
	 }
	 
	 @GetMapping("getall")
	 public ResponseEntity<?> getAllMerchants(){
		 try {
			 List<?> response = memberDetailsService.findAllMembers();
			 return ResponseHandler.generateResponse(response, HttpStatus.OK, "Data fetched");
		 } catch (Exception e) {
			 return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Failed to load data");
		 }
	 }
	 
	 @GetMapping("get/public-id")
	 public ResponseEntity<?> getAllPublicId(){
		 try {
			List<BigInteger> ids=  memberDetailsService.getAllPublicId();
			Map<String, List<BigInteger>> response = new HashMap<>(Collections.singletonMap("Public-ID", ids));

			return ResponseHandler.generateResponse(response, HttpStatus.OK, "Api Fetched Successfully");
		 } catch (Exception e) {
		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Error occurred while fetching public IDs");
		 }
	 }

	 @GetMapping("get/details-by/{publicId}")
	 public ResponseEntity<?> getOnlyMemberById(@PathVariable long publicId){
		 try {
			 MemberRequestDto memberRequestDto= projectService.getById(publicId).orElseThrow(()-> new CustomException("Failed To Load Data"));
		return ResponseHandler.generateResponse(memberRequestDto, HttpStatus.OK, "Api fetched Successfully");
		 } catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Error occurred while fetching Data");
		}
	 }
	 
	 @GetMapping("get/member-by/{publicId}")
	 public ResponseEntity<?> getAllDetailsById(@PathVariable BigInteger publicId){
		 try {
			 MemberDetails memberRequestDto= memberDetailsService.getMerchantById(publicId)
					    .orElseThrow(() -> new CustomException("Failed to load data of " + publicId + " from database"));
		return ResponseHandler.generateResponse(memberRequestDto, HttpStatus.OK, "Data Fetched from server");
		 } catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, "Error occurred while fetching Data");
		}
	 }
	 
}
