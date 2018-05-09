package com.codevik.socialmediaapiintegration.util.appconstants;

/**
 * Created by Ruturaj on 19-12-2016.
 */

public class ErrorMessages {

  public static final String RECORD_NOT_FOUND = "Record not found";
  public static final String INTERNAL_SERVER_ERROR = "Something went wrong";
  public static final String HTTP_SERVER_ERROR_EXCEPTION =
      "Http server error exception for requestId: {} with error: {}";
  public static final String SOAP_FAULT_SUPPLIER_ENDPOINT =
      "Soap Fault Exception at Supplier Endpoint for requestId: {} with error: {}";
  public static final String ERROR_INFO_UNSUPPORTED_METHOD =
      " method is not supported for this request. Supported " + "methods are ";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String RULE_ID_MISSING = "RuleId is mandatory in url";
  public static final String BULK_REQUEST_ID_MISSING = "BulkRequestId is mandatory in url";
  public static final String INVALID_REQUEST_SAVE_UPDATE_BATCHED = "Invalid Request: bulkRequestId, ruleId and status are mandatory fields";
  public static final String INVALID_REQUEST_ADD_FIELDS = "Invalid Request: Both ruleId and bulkRequestId cannot be blank";
  public static final String INVALID_FIELD_NAME = "Invalid Field Name: ";
  public static final String INVALID_REQUEST_MATERIAL_TYPE = "Invalid Request: Both materialId and materialName cannot be blank";
  public static final String NO_RECORD_FOUND = "record.not.found";
  public static final String FIELD_MISSING = "field.missing";
  public static final String INVALID_INPUT = "invalid.input";
  public static final String INTERNAL_SERVER_ERROR_PROPERTY = "internal.server.error";
  public static final String DATA_NOT_FOUND_FOR_FIELD = "field.data.not.found";
  public static final String QUERY_STRING_MISSING = "query.string.missing";
  public static final String INVALID_REQUEST_ROUTING_RULE = "Invalid Request: materialId, requestType and segmentIds are mandatory fields";
  public static final String INVALID_REQUEST_BUSINESS_SEGMENT = "Invalid Request: customerId and segmentId are mandatory fields";
  public static final String REQUEST_ID_MISSING = "Invalid Request: Request Id is Missing";
  public static final String REQUEST_TYPE_MISSING = "Invalid Request: request type is missing";
  public static final String MULT_ITEM_REQUEST_MISSING = "MultItemRequestHeaderId is mandatory in url";
  public static final String RECORD_DELETION_FAILED = "record.delete.failure";
  public static final String INVALID_SEARCH_TYPE = "invalid.search.type";
  public static final String EMPTY_SEARCH_TYPE = "empty.search.type";
  public static final String EMPTY_SEARCH_NAME = "empty.saved.search.name";
  public static final String EMPTY_USER_IDENTIFIER = "empty.saved.search.user.identifier";
  public static final String INVALID_USER_IDENTIFIER = "invalid.search.user.identifier";
  public static final String INVALID_SAVED_SEARCH_NAME = "invalid.saved.search.name";
  public static final String ILLEGAL_ARGUMENT_EXCEPTION = "illegal.argument.exception";
  public static final String INVALID_UNIQUE_IDENTIFIER = "invalid.unique.identifier";
  public static final String EMPTY_MESSAGE_IDENTIFIER = "empty.message.identifier";
  public static final String INVALID_TOPIC_NAME = "invalid.topic.name";
  public static final String EMPTY_ACTION_TYPE = "empty.action.type";
  public static final String EMPTY_TOPIC_NAME = "empty.topic.name";
  public static final String INVALID_DATE_RANGE_EXCEPTION = "invalid.date.range.exception";
  public static final String PARTICIPANT_NOT_FOUND_FOR_UUID = "participant.not.found.for.uuid";
  public static final String PARTICIPANT_NOT_FOUND = "participant.not.found";
  public static final String OVERLAPPING_EFFECTIVE_INTERVAL = "overlapping.effective.interval";
  public static final String INVALID_START_DATE = "invalid.start.date";
  public static final String OVERLAPPING_CRITERIA_INTERVAL = "overlapping.criteria.interval";
  public static final String UPDATING_CRITERIA_NOT_ALLOWED = "updating.criteria.not.allowed";
  public static final String CRITERIA_ALREADY_EXISTS = "criteria.already.exists";
  public static final String INACTIVE_ROUTING_RULE = "inactive.routing.rule";
  public static final String ILLEGAL_ROUTING_RULE_DELETE = "illegal.routing.rule.delete";
  public static final String RECORD_WITH_ID_EXISTS = "record.with.id.exists";
  public static final String RETIRED_ROUTING_RULE_NOT_EDITABLE = "retired.routing.rule.not.editable";
  public static final String CANNOT_UPDATE_ACTIVE_ROUTING_RULE = "cannot.update.active.routing.rule";
  public static final String STATUS_IS_MANDATORY = "status.is.mandatory";
  public static final String NO_ROUTING_RULE_EXISTS = "no.routing.rule.exists";
  public static final String ACTIVE_RETIRED_RECORD_CANNOT_BE_DELETED = "active.retired.record.cannot.be.deleted";
  public static final String INTERNAL_SERVER_ERROR_WHILE_DELETION = "internal.server.error.while.deleting";
  public static final String RECORD_ALREADY_PRESENT_FOR_GIVEN_TITLE = "record.already.present.for.given.title";
  public static final String RETIRED_RECORD_CANNOT_BE_EDITED = "retired.record.cannot.be.edited";
  public static final String ACTIVE_RECORD_START_DATE_NOT_EDITABLE = "active.record.start.date.cannot.be.edited";
  public static final String DEAD_LETTER_RECORD_CAN_EITHER_RESOLVE_OR_RESTART = "dead.letter.record.can.either.resolve.or.restart";
  public static final String DEAD_LETTER_RECORD_NOT_FOUND = "dead.letter.record.not.found";
  public static final String NOTE_DETAILS_MISSING = "note.details.missing";
  public static final String TOPIC_NAME_MISSING_FOR_UNIQUE_ID = "topic.name.missing";
  public static final String NUMBER_OF_ATTEMPTS_SHOULD_BE_NON_ZERO_WHILE_UPDATING = "number.of.attempts.should.be.greater.than.zero.for.updating";
  public static final String SERVER_DETAILS_WITH_UUID_NOT_FOUND = "server.details.with.uuid.not.found";
  public static final String FULFILLMENT_TRACKING_RECORD_NOT_FOUND_FOR_REQUEST_ID = "fulfillment.tracking.record.not.found.for.requestId";
  public static final String RECORD_ALREADY_PRESENT_FOR_UUID = "record.already.present.for.uuid";
  public static final String UUID_SHOULD_NOT_PRESENT_IN_REQUEST_WHILE_UPDATE = "uuid.should.not.present.in.request.while.update";
  public static final String OVERALL_STATUS_INVALID = "overall.status.for.file.availability.is.invalid";
  public static final String NO_RECORD_FOUND_SERVICES = "no.record.found";
  private static final String REST_CLIENT_EXCEPTION_THROWN_AT = "Rest Client Exception thrown at ";
  public static final String REST_EXCEPTION_DEADLETTER_TOPIC = REST_CLIENT_EXCEPTION_THROWN_AT
      + "Deadletter Service while updating document for requestId: {}";
  public static final String EXPIRED_FILES_DELETION_FAILED = "expired.files.deletion.failed";

  public static final String INVALID_HEADER_EXCEPTION = "invalid.header";
  public static final String REQUESTOR_CALLBACK_DETAILS_NOT_FOUND = "requestor.callback.details.not.found";
  public static final String RECORD_DELETION_FAILED_DUE_TO_INTERNAL_SERVER_ERROR = "record.deletion.failure.internal.server.error";
  public static final String START_DATE_SHOULD_BE_BEFORE_END_DATE = "start.date.should.be.before.end.date";
  public static final String ACTIVE_OR_RETIRED_RECORD_CANNOT_BE_UPDATED = "active.retired.record.cannot.be.updated";

  private ErrorMessages() {
  }

}
