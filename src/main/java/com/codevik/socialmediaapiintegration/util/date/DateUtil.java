package com.codevik.socialmediaapiintegration.util.date;

import com.codevik.socialmediaapiintegration.exception.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static java.time.temporal.ChronoField.*;

@Slf4j
public class DateUtil {

  public static final String DATE_TIME_T_FORMAT = "yyyyMMdd'T'HHmmssSSS";
  public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd";
  private static final Date MAX_DATE;
  private static final DateTimeFormatter ISO_LOCAL_TIME = new DateTimeFormatterBuilder()
      .appendValue(HOUR_OF_DAY, 2)
      .appendLiteral(':')
      .appendValue(MINUTE_OF_HOUR, 2)
      .optionalStart()
      .appendLiteral(':')
      .appendValue(SECOND_OF_MINUTE, 2)
      .appendFraction(NANO_OF_SECOND, 3, 3, true)
      .parseStrict()
      .appendOffsetId()
      .toFormatter();

  private static final DateTimeFormatter ISO_8601_DATE_TIME_FORMAT = new DateTimeFormatterBuilder()
      .parseCaseInsensitive()
      .append(DateTimeFormatter.ISO_LOCAL_DATE)
      .appendLiteral('T')
      .append(ISO_LOCAL_TIME)
      .toFormatter();

  static {
    MAX_DATE = Date.from(
        LocalDate.of(9999, Month.DECEMBER, 31).atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  private DateUtil() {
  }

  // Method to validate whether the incoming String is as per ISO 8601 Format
  public static boolean validateDate(String input) {
    try {
      DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(input);
    } catch (DateTimeParseException ex) {
      log.error("Invalid date found", ex);
      return false;
    }
    return true;
  }

  public static boolean isValidDateOnly(String input, String dateFormat) {
    try {
      if (StringUtils.isNotBlank(input)) {
        SimpleDateFormat simpleDateFormat = getSimpleDateFormat(dateFormat);
        simpleDateFormat.parse(input);
        return true;
      }
    } catch (ParseException ex) {
      log.warn("Invalid date found {} ", input);
    }
    return false;
  }

  private static SimpleDateFormat getSimpleDateFormat(String dateFormat) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    simpleDateFormat.setLenient(false);
    return simpleDateFormat;
  }

  public static int getNumberOfDaysInAYear(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
  }


  public static Date getDateOnly(String date, String dateFormat) {
    if (date != null) {
      try {
        return getSimpleDateFormat(dateFormat).parse(date);
      } catch (ParseException ex) {
        log.warn("Invalid date to parse.", ex);
        throw new GenericException(ex);
      }
    }
    return null;
  }

  // Method to convert String to java.util.Date format
  public static Date toJavaDate(String inputString) {
    Date date = new Date();
    if (Objects.nonNull(inputString)) {
      date = Date.from(ZonedDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(inputString))
          .toInstant());
    }
    return date;
  }

  // Method to convert String to yyyy-MM-dd Date format
  public static Date toDate(String inputString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ISO_8601_DATE_FORMAT);
    Date date = null;
    if (StringUtils.isNotBlank(inputString)) {
      LocalDate localDate = LocalDate.parse(inputString, formatter);
      ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
      date = Date.from(zonedDateTime.toInstant());
    }
    return date;
  }

  /**
   * @param inputString should always be in UTC "2018-02-14T00:51:00Z"
   * @return Date
   */
  public static Date toDateFromISODateTime(String inputString) {
    Date date = null;
    if (StringUtils.isNotBlank(inputString)) {
      date = Date.from(Instant.parse(inputString));
    }
    return date;
  }

  /**
   * Convert inputString to UTC equivalent, then format using SimpleDateFormat, then Split date it
   * into date and time
   *
   * @return array of string (date and time string)
   */
  public static String[] getDateAndTime(String inputString) throws ParseException {
    // get inputString UTC format
    String utcString =
        ZonedDateTime.parse(inputString).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    // Apply required formatting
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
    Date requestDate = formatter.parse(utcString);
    String requestDateString = formatter.format(requestDate);
    // splitting date and time
    return requestDateString.split("T");
  }

  // method to get new Date
  public static Date getNewDate() {
    return new Date();
  }

  // method to test range of date
  public static boolean isWithinRange(Date startDate, Date endDate, Date testDate) {
    return testDate.after(startDate) && testDate.before(endDate);
  }

  public static String getISODateTime(Date date) {
    if (date != null) {
      return ISO_8601_DATE_TIME_FORMAT
          .format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
    return null;
  }

  public static Date getMaxDate() {
    return MAX_DATE;
  }

  /**
   * Format current date time so that output will look like 20160421T103035007
   *
   * @return array of string (date and time string)
   */
  public static String formatCurrentDateTime(String formatter) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_T_FORMAT);
    if (Objects.nonNull(formatter)) {
      dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
    }
    return now.format(dateTimeFormatter);
  }

  public static Date convertTimeValueToEndOfDay(Date date) {
    if (Objects.isNull(date)) {
      return null;
    }
    LocalDateTime endOfDay = dateToLocalDateTime(date).with(LocalTime.MAX);
    return localDateTimeToDate(endOfDay);
  }

  private static LocalDateTime dateToLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }

  private static Date localDateTimeToDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }


}
