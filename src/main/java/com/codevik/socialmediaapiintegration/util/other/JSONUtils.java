package com.codevik.socialmediaapiintegration.util.other;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JSONUtils {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  public static String objectToJsonString(Object object) throws JsonProcessingException {
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    return objectMapper.writeValueAsString(object);
  }

}
