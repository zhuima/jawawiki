package com.zhuima.jawawiki.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }


    @PostMapping("hello")
    public ResponseEntity<?> hello(@RequestBody String message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
