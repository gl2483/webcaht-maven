/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gluo.webchat.maven.model.ChatUser;

/**
 *
 * @author luoguanqi
 */
@Controller
@RequestMapping("/user/*")
public class UserController{
    
    
    @RequestMapping(value="CreateAccount", method=RequestMethod.POST)
    @ResponseBody
    public String CreateAccount(@RequestParam("username") String usrname, @RequestParam("password") String password){
        if(ChatUser.createUser(usrname, password) == null){
            return "failed";
        }
        else{
            return "success";
        }
    }
}
