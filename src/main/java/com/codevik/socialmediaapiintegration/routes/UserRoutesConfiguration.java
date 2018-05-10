package com.codevik.socialmediaapiintegration.routes;

import com.codevik.socialmediaapiintegration.model.User;
import com.codevik.socialmediaapiintegration.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.EntityResponse.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class UserRoutesConfiguration {

//    @Bean
//    RouterFunction<?> routes(UserService userService) {
//        return nest(path("/userroute")

//                route(RequestPredicates.GET("/{mobileNo}"),
//                        request -> ok().body(userService.findByMobileNo(Long.valueOf(request.pathVariable("mobileNo"))), User.class))

//                        .andRoute(method(HttpMethod.POST),
//                                request -> {
//                                    personRespository.insert(request.bodyToMono(Person.class)).subscribe();
//                                    return ok().build();
//                                })
  //      );
 //   }

}
