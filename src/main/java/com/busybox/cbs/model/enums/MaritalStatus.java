package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum MaritalStatus {

	MARRIED,
	SEPERATED,
	DIVORCED, 
	WIDOWED,
	UNMARRIED,
	SINGLE;
	
	public static List<MaritalStatus> listOfNamePrefix() {
        return Arrays.asList(MaritalStatus.values());
    }
}
