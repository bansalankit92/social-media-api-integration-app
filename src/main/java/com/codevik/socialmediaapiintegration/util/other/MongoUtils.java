package com.codevik.socialmediaapiintegration.util.other;

import lombok.experimental.UtilityClass;
import org.springframework.web.client.RestTemplate;

/**
 * Created by imteyaz on 24/11/17
 */
@UtilityClass
public class MongoUtils {

  public static String buildMongoUri(String mongoURI, String decryptionUriStr) {
    String uriStr = mongoURI
        .substring(mongoURI.indexOf('\'') + 1, mongoURI.lastIndexOf('\''));
    uriStr = uriStr.replace("{cypher}", "");
    RestTemplate restTemplate = new RestTemplate();
    String decrypedStr = restTemplate
        .postForObject(decryptionUriStr,
            uriStr, String.class);
    return mongoURI.replace(uriStr, decrypedStr).replaceAll("'", "");
  }
}
