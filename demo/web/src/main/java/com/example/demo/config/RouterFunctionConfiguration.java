package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;*/

import java.util.Collection;

@Configuration
public class RouterFunctionConfiguration {
   /* @Bean
    @Autowired*/
/*public RouterFunction<ServerResponse> personFindAll(UserRepository userRespository){
    return  RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
            request ->{
                Collection<User> users = userRespository.findAll();
                Mono<ServerResponse> response = null;
                Flux<User> userFlux = Flux.fromIterable(users);
                return ServerResponse.ok().body(userFlux,User.class);
            });
    }*/
}
