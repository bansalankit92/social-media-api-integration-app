package com.codevik.socialmediaapiintegration.service;

import com.codevik.socialmediaapiintegration.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> findAll();
    Mono<User> findByMobileNo(long mobileNo);
}
