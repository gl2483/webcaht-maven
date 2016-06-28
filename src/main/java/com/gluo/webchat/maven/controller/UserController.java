/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.controller;

import com.gluo.webchat.maven.model.ChatUser;
import com.gluo.webchat.maven.service.ChatUserDAO;
import com.gluo.webchat.maven.utilities.AES;
import com.gluo.webchat.maven.utilities.ResponseStatus;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author luoguanqi
 */
@Controller
@RequestMapping("/user/*")
@RequestScoped
public class UserController{
    
    @Autowired
    private ChatUserDAO userDao;
    
    @RequestMapping(value="CreateAccount", method=RequestMethod.POST)
    @ResponseBody
    public ResponseStatus CreateAccount(@RequestParam("username") String usrname, @RequestParam("password") String password){
        try{
            userDao.addUser(usrname, password);
            return new ResponseStatus("success", usrname + " created account successfully");
        }
        catch(Throwable ex){
            return new ResponseStatus("failed", "Error: " + ex.getMessage());
        }
    }
    
    @RequestMapping(value="Login", method=RequestMethod.POST)
    @ResponseBody
    public ResponseStatus Login(HttpSession session, @RequestParam("username") String usrname, @RequestParam("password") String password){
        try{
            ChatUser user = userDao.getUserByName(usrname);
            if(user == null)
                return new ResponseStatus("failed", "User does not exist.");
            else{
                String encrypt = AES.encrypt(password);
                if(user.getPassword().equals(encrypt)){
                    session.setAttribute("currentLogin", user.getUsername());
                    return new ResponseStatus("success", "");
                }
                else
                    return new ResponseStatus("failed", "Username and password does not match.");
            }
        }catch(Throwable ex){
            return new ResponseStatus("failed", "Error: " + ex.getMessage());
        }
    }
}
