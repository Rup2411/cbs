package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum PaymentBy {

	Cash,
	Check,
	Online,
	Neft;
	
	public static List<PaymentBy> listOfNamePrefix() {
        return Arrays.asList(PaymentBy.values());
    }
}
