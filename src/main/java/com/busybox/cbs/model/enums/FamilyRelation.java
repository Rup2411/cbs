package com.busybox.cbs.model.enums;

import java.util.Arrays;
import java.util.List;

public enum FamilyRelation {

	Father,
	Mother,
	Son,
	Daughter,
	Spouse,
	Husband,
	Wife,
	Brother,
	Sister,
	Daughter_In_law,
	Brother_in_Law,
	Grand_Daughter,
	Grand_Son,
	Other;
	
	public static List<FamilyRelation> listOfNamePrefix() {
        return Arrays.asList(FamilyRelation.values());
    }
	
}
