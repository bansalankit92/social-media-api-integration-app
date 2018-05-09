package com.codevik.socialmediaapiintegration.config;

import com.codevik.socialmediaapiintegration.util.appconstants.MongoConfigConstants;
import com.codevik.socialmediaapiintegration.util.other.MongoUtils;
import com.mongodb.MongoClientURI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;


@Configuration
@RefreshScope
public class MongoConfig {

  @Value("${spring.data.mongodb.uri}")
  private String mongoURIStr;

  @Value("${decryption.uri}")
  private String decryptionUri;

  @Value("${mongodb.w.value}")
  private String w;

  @Value("${mongodb.w.timeout.ms}")
  private String wTimeoutMS;

  @Value("${mongodb.journal}")
  private String journal;

  @Value("${mongodb.max.pool.size}")
  private String maxPoolSize;

  @Value("${mongodb.min.pool.size}")
  private String minPoolSize;

  @Value("${mongodb.max.idle.time.ms}")
  private String maxIdleTimeMS;

  @Value("${mongodb.wait.queue.multiple}")
  private String waitQueueMultiple;

  @Value("${mongodb.wait.queue.timeout.ms}")
  private String waitQueueTimeoutMS;

  @Value("${mongodb.read.preference}")
  private String readPreference;

  @Value("${mongodb.read.concern}")
  private String readConcern;

  @Autowired
  private Environment environment;

  @Bean
  public MongoDbFactory mongoDbFactory() throws UnknownHostException {
    StringBuilder mongoURI;
    if (environment.getActiveProfiles().length > 0) {
      mongoURI = new StringBuilder(
          MongoUtils.buildMongoUri(mongoURIStr, decryptionUri))
          .append(getWriteConcern())
          .append(getConnectionPoolSettings()).append(getReadConcern()).append(getReadPreference());
    } else {
      mongoURI = new StringBuilder(mongoURIStr)
          .append(getWriteConcern())
          .append(getConnectionPoolSettings()).append(getReadConcern()).append(getReadPreference());
    }
    MongoClientURI mongoClientURI = new MongoClientURI(mongoURI.toString());
    return new SimpleMongoDbFactory(mongoClientURI);
  }

  private StringBuilder getWriteConcern() {
    StringBuilder stringBuilder = new StringBuilder();
    if (mongoURIStr.contains("replicaSet")) {
      stringBuilder.append("&" + MongoConfigConstants.W + "=" + w)
          .append(getRequestParam(MongoConfigConstants.W_TIMEOUT_MS, wTimeoutMS))
          .append(getRequestParam(MongoConfigConstants.JOURNAL, journal));
    } else {
      stringBuilder.append("?" + MongoConfigConstants.W + "=" + w)
          .append(getRequestParam(MongoConfigConstants.W_TIMEOUT_MS, wTimeoutMS))
          .append(getRequestParam(MongoConfigConstants.JOURNAL, journal));
    }
    return stringBuilder;
  }

  private StringBuilder getConnectionPoolSettings() {
    return new StringBuilder(getRequestParam(MongoConfigConstants.MAX_POOL_SIZE, maxPoolSize))
        .append(getRequestParam(MongoConfigConstants.MIN_POOL_SIZE, minPoolSize))
        .append(getRequestParam(MongoConfigConstants.MAX_IDEL_TIME_MS, maxIdleTimeMS))
        .append(getRequestParam(MongoConfigConstants.WAIT_QUEUE_MULTIPLE, waitQueueMultiple))
        .append(getRequestParam(MongoConfigConstants.WAIT_QUEUE_TIMOUT_MS, waitQueueTimeoutMS));
  }

  private StringBuilder getReadPreference() {
    return getRequestParam(MongoConfigConstants.READ_PREFERENCE, readPreference);
  }

  private StringBuilder getReadConcern() {
    return getRequestParam(MongoConfigConstants.READ_CONCERN_LEVEL, readConcern);
  }

  private StringBuilder getRequestParam(String key, String value) {
    return new StringBuilder("&" + key + "=" + value);
  }

  @Bean
  public MongoTemplate mongoTemplate() throws UnknownHostException {
    return new MongoTemplate(mongoDbFactory());
  }
}
