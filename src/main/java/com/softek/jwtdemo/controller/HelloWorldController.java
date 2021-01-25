/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softek.jwtdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris
 */
@RestController
public class HelloWorldController {
    
    @RequestMapping("hello")
    public String helloWorld(@RequestParam(value="name", defaultValue="World")String name){
        return "Hello" + name + "!!";
    }
}
