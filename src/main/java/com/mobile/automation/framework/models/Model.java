package com.mobile.automation.framework.models;

import lombok.extern.log4j.Log4j;

/**
 * @author Tomash Gombosh
 */
@Log4j
public class Model {

    protected boolean compareStringsWithLog(final String originalString, final String stringForComparison) {
        boolean stringsAreEquals = true;
        if (!originalString.equals(stringForComparison)) {
            stringsAreEquals = false;
            log.info("Values \"" + originalString + "\" and \"" + stringForComparison + "\" are not equals");
        }
        return stringsAreEquals;
    }

}
