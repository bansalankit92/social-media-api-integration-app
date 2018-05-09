package com.codevik.socialmediaapiintegration.util.other;

import lombok.experimental.UtilityClass;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by imteyaz on 8/11/17
 */
@UtilityClass
public class CharUtils {

  public static byte[] charArrayToByteArray(char[] chars) {
    CharBuffer charBuffer = CharBuffer.wrap(chars);
    ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
    byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
        byteBuffer.position(), byteBuffer.limit());
    Arrays.fill(charBuffer.array(), '\u0000');
    Arrays.fill(byteBuffer.array(), (byte) 0);
    return bytes;
  }

}