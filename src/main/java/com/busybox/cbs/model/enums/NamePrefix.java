package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;


public enum NamePrefix {

	MR,
	MS,
	MRS,
	SMT,
	MD;
	
	public static List<NamePrefix> listOfNamePrefix() {
        return Arrays.asList(NamePrefix.values());
    }
}
