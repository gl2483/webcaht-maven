/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.websocket;

import java.util.logging.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.Session;

/**
 *
 * @author luoguanqi
 */
@ApplicationScoped
@ServerEndpoint("/webchat")
public class ChatEndpoint {
    
    @Inject
    private SessionHandler handler;
    
    @OnOpen
    public void onopen(Session s){
        handler.add(s);
    }
    
    @OnClose
    public void onclose(Session s){
        handler.remove(s);
        java.util.logging.Logger.getLogger(ChatEndpoint.class.getName()).log(Level.SEVERE, null, "Socket Closedd");
    }
    
    @OnMessage
    public void onmessage(Session s, String msg){
        handler.sendToSession(s, msg + " echoed");
    }
    
    @OnError
    public void onerror(Throwable ex){
        java.util.logging.Logger.getLogger(ChatEndpoint.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}
