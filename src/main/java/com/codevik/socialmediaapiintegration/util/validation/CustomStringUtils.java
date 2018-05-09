package com.codevik.socialmediaapiintegration.util.validation;

import com.codevik.socialmediaapiintegration.util.appconstants.AppConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class CustomStringUtils {

  private CustomStringUtils() {
  }

  public static boolean isStringValidBoolean(String string) {

    return StringUtils.isNotBlank(string) && (AppConstants.TRUE.equalsIgnoreCase(string)
        || AppConstants.FALSE.equalsIgnoreCase(string));

  }

  public static Object returnNAIfNull(Object object) {
    return Objects.nonNull(object) ? object : AppConstants.NA;
  }

}
