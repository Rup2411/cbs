package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Duration {

	MONTHLY,
    QUARTERLY,
    HalfYearly,
    ANNUALLY;

    public static List<Duration> listOfNamePrefix() {
        return Arrays.asList(Duration.values());
    }
}
