package com.codevik.socialmediaapiintegration.service;

import com.codevik.socialmediaapiintegration.dao.UserRepository;
import com.codevik.socialmediaapiintegration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
@Override
    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public Mono<User> findByMobileNo(long mobileNo) {
        return userRepository.findByMobileNo(mobileNo);
    }

}
