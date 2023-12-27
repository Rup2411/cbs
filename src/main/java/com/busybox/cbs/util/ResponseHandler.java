package com.busybox.cbs.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseHandler {
	//Add a private constructor to hide the implicit public one.
	
	private static final String MESSAGE = "message";
    private static final String STATUS = "status";
    private static final String STATUS_MESSAGE = "status_message";
    private static final String DATA = "data";
    
	
	public ResponseHandler() {
	    throw new IllegalStateException("Utility class");
	}

	
	public static ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus status,String message ) {
		Map<String, Object> map = new LinkedHashMap<>();
		String statusMessage;
		if(status.value()==200 || status.value()==202 || status.value()==201)
		{
			statusMessage = "SUCCESS";
		}else  statusMessage = "FAILURE";
		map.put(MESSAGE, message);
		map.put(STATUS_MESSAGE, statusMessage);
		map.put(STATUS, status.value());
		map.put(DATA, responseObj);
		return new ResponseEntity<>(map, status);
	}

	public static ResponseEntity<Object> generateResponsepaginatedData(Page<?> paginatedData, HttpStatus status, String message) {
	    Map<String, Object> map = new LinkedHashMap<>();
	    String statusMessage;
	    if (status.value() == 200 || status.value() == 202 || status.value() == 201) {
	        statusMessage = "SUCCESS";
	    } else {
	        statusMessage = "FAILURE";
	    }

	    Map<String, Object> data = new LinkedHashMap<>();
	    data.put("content", paginatedData.getContent());
	    data.put("recordsCurrentPage", paginatedData.getNumber() + 1); // Current page index starts from 0, so adding 1
	    data.put("totalPages", paginatedData.getTotalPages());
	    data.put("totalRecords", paginatedData.getTotalElements());
	    data.put("currentPage", paginatedData.getNumber() + 1);

	    map.put(MESSAGE, message);
	    map.put(STATUS_MESSAGE, statusMessage);
	    map.put(STATUS, status.value());
	    map.put(DATA, data);

	    return new ResponseEntity<>(map, status);
	}

	
	public static ResponseEntity<Object> generateResponseWithHeaders(Object responseObj, HttpStatus status, String message, Map<String, String> customHeaders) {
        Map<String, Object> map = new LinkedHashMap<>();
        String statusMessage = (status.is2xxSuccessful()) ? "Success" : "Failure";

        map.put(MESSAGE, message);
        map.put(STATUS_MESSAGE, statusMessage);
        map.put(STATUS, status.value());
        map.put(DATA, responseObj);

        HttpHeaders headers = new HttpHeaders();
        customHeaders.forEach(headers::add); // Add custom headers

        return new ResponseEntity<>(map, headers, status);
    }
	
	public static ResponseEntity<Object> generateResponseWebHook( String decisionValue,HttpStatus status, String responseType) {
		Map<String, Object> map = new LinkedHashMap<>();
		Map<String, Object> validateResponse = new LinkedHashMap<>();
		validateResponse.put("decision", decisionValue);
		map.put(responseType, validateResponse);
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> generateResponseOfToken(Object responseObj, Object token,String name, HttpStatus status, String message) {
	    Map<String, Object> data = new LinkedHashMap<>();
	    data.put("PhoneNumber", responseObj);
	    data.put("token", token);
	    data.put("CustomerName", name);

	    String statusMessage = (status.value() == 200 || status.value() == 202 || status.value() == 201) ? "Success" : "Failure";

	    Map<String, Object> map = new LinkedHashMap<>();
	    map.put(MESSAGE, message);
	    map.put(STATUS_MESSAGE, statusMessage);
	    map.put(STATUS, status.value());
	    map.put(DATA, data);

	    return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> generateResponseList(List<Object> responseObj, HttpStatus status,String message ) {
		Map<String, Object> map = new LinkedHashMap<>();
		String statusMessage;
		if(status.value()==200 || status.value()==202 || status.value()==201)
		{
			statusMessage = "Success";
		}else  statusMessage = "Failure";
		
		
		map.put(MESSAGE, message);
		map.put(STATUS_MESSAGE, statusMessage);
		map.put(STATUS, status.value());
		map.put(DATA, responseObj);
		
		

		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> generateResponseList2(List<?> responseObj, HttpStatus status,String message) {
		Map<String, Object> map = new LinkedHashMap<>();
		String statusMessage;
		if(status.value()==200 || status.value()==202 || status.value()==201)
		{
			statusMessage = "Success";
		}else  statusMessage = "Failure";
		map.put(MESSAGE, message);
		map.put(STATUS_MESSAGE, statusMessage);
		map.put(STATUS_MESSAGE, status.value());
		map.put(DATA, responseObj);
		return new ResponseEntity<>(map, status);
	}
	
	public static ResponseEntity<Object> generateResponseForCustomerID(String responseObj, HttpStatus status, String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        String statusMessage;
		if(status.value()==200 || status.value()==202 || status.value()==201)
		{
			statusMessage = "Success";
		}else  statusMessage = "Failure";
        map.put(MESSAGE, message);
        map.put(STATUS_MESSAGE, statusMessage);
        map.put(STATUS, status.value());
        map.put("token:", responseObj);

        return new ResponseEntity<>(map, status);
    }
	
	    public static Map<String, Object> extractMapFromResponseEntity(ResponseEntity<?> responseEntity) {
	        Map<String, Object> responseMap = new LinkedHashMap<>();
	        responseMap.put("status_code", responseEntity.getStatusCode());
	        responseMap.put(STATUS_MESSAGE, responseEntity.getStatusCode().is2xxSuccessful() ? "Success" : "Failure");
	        responseMap.put(DATA, responseEntity.getBody());
	        return responseMap;
	    }

		public static ResponseEntity<Object> generateResponse2(Integer pageNumber, Integer pageSize, Object allLogsPagewise, HttpStatus status, String message) {
		    Map<String, Object> response = new LinkedHashMap<>();
		    
		    String statusMessage;
		    if(status.value()==200)
		    {
		    statusMessage = "Success";
		    }else  statusMessage = "Failure";
		    response.put(STATUS_MESSAGE, statusMessage);
		    response.put("pageNumber", pageNumber);
		    response.put("pageSize", pageSize);
		    response.put(DATA, allLogsPagewise);
		    response.put(MESSAGE, message);
		    return new ResponseEntity<>(response, status);
		}
		
		public static ResponseEntity<?> generateResponseForMessageandstatus(String status,String message) {
			 HttpStatus httpStatus;
			   if ("success".equalsIgnoreCase(status)) {
			       httpStatus = HttpStatus.OK;
			   } else if ("failure".equalsIgnoreCase(status)) {
			       httpStatus = HttpStatus.NOT_FOUND; 
			   } else {
			       httpStatus = HttpStatus.BAD_REQUEST; 
			   }
			   Map<String, Object> map = new LinkedHashMap<>();
			   map.put(MESSAGE, message);
			   map.put(STATUS, httpStatus.value());
			   map.put(STATUS_MESSAGE, status);
			   return new ResponseEntity<>(map, httpStatus);
			}
}  