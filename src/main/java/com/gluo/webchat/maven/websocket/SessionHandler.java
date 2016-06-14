/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author luoguanqi
 */
@ApplicationScoped
public class SessionHandler {
    
    private final HashSet<Session> sessions = new HashSet<>();
    
    public void add(Session s){
        sessions.add(s);
    }
    
    public void remove(Session s){
        sessions.remove(s);
    }
    
    public void sendToAll(String msg){
        for(Session s : sessions){
            sendToSession(s, msg);
        }
    }
    
    public void sendToSession(Session s, String msg){
        try {
            s.getBasicRemote().sendText(msg);
        } catch (IOException ex) {
            Logger.getLogger(SessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
