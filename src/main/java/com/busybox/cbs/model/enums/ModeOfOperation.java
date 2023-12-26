package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum ModeOfOperation {

	Single,
	Joint,
	Survivor;
	
	public static List<ModeOfOperation> listOfNamePrefix() {
        return Arrays.asList(ModeOfOperation.values());
    }
}
