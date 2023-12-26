package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum FamilyRelation {

	FATHER,
	MOTHER,
	SON,
	DAUGHTER,
	SPOUSE,
	HUSBAND,
	WIFE,
	BROTHER,
	SISTER,
	DAUGHTER_IN_LAW,
	BROTHER_IN_LAW,
	GRAND_DAUGHTER,
	GRAND_SON,
	OTHER;
	
	public static List<FamilyRelation> listOfNamePrefix() {
        return Arrays.asList(FamilyRelation.values());
    }
	
}
