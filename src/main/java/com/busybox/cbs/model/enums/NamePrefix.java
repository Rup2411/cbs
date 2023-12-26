package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;


public enum NamePrefix {

	Mr,
	Ms,
	Mrs,
	Smt,
	Md;
	
	public static List<NamePrefix> listOfNamePrefix() {
        return Arrays.asList(NamePrefix.values());
    }
}
