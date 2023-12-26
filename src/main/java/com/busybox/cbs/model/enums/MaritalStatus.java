package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum MaritalStatus {

	Married,
	Seperated,
	Divorced, 
	Widowed,
	Unmarried,
	Single;
	
	public static List<MaritalStatus> listOfNamePrefix() {
        return Arrays.asList(MaritalStatus.values());
    }
}
