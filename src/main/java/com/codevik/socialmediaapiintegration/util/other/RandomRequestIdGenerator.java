package com.codevik.socialmediaapiintegration.util.other;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class RandomRequestIdGenerator {
  private RandomRequestIdGenerator() {

  }

  public static final UUID getUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid;
  }

  /**
   * 
   * @param string prefix
   * @return string "prefix_UUID"
   */
  public static String generateRandomRequestId(String prefix) {

    return prefix.concat( String.valueOf(RandomRequestIdGenerator.getUUID()));

  }

}
