/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.utilities;

/**
 *
 * @author luoguanqi
 */
public class ResponseStatus {
    private String status;
    private String message;
    
    public ResponseStatus(String sta, String msg){
        status = sta;
        message = msg;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String sta){
        status = sta;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String msg){
        message = msg;
    }
}
