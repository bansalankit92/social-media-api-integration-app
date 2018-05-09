package com.codevik.socialmediaapiintegration.util.other;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by mohammad on 2/3/17.
 */
public class NumberUtil {

    private NumberUtil() {
    }

    public static boolean isPositive(String string) {
        boolean flag = false;
        if (StringUtils.isNumeric(string) && Integer.parseInt(string) > 0) {
            flag = true;
        }
        return flag;
    }

}
