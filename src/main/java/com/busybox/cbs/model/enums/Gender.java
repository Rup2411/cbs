package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Gender {

	MALE,
	FEMALE;
	
	public static List<Gender> listOfNamePrefix() {
        return Arrays.asList(Gender.values());
    }
}
