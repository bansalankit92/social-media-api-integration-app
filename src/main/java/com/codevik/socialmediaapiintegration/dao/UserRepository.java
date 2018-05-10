package com.codevik.socialmediaapiintegration.dao;

import com.codevik.socialmediaapiintegration.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository
        extends ReactiveMongoRepository<User, String> {
    Mono<User> findByMobileNo(long mobileNo);
}

