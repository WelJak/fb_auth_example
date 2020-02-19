package com.weljak.facebookloginpoc.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public Mono<String> index(@AuthenticationPrincipal Mono<OAuth2User> oauth2user){
        return oauth2user
                //.map(OAuth2User::getAttributes)
                .map(OAuth2User::getAttributes)
                .map(name -> String.format("Hi , %s", name.get("name")));
    }
}
