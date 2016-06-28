/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.gluo.webchat.maven.utilities.AES;

/**
 *
 * @author KK
 */
public class ChatUser {
    private int UserId;
    private String Username;
    private String Password;
   
    
    public ChatUser(){}
    public ChatUser(int userid, String name, String pwd){
        UserId = userid;
        Username = name;
        try {
            AES.encrypt(pwd);
        } catch (Exception ex) {
            Logger.getLogger(ChatUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ChatUser(String name, String pwd){
        Username = name;
        try {
            AES.encrypt(pwd);
        } catch (Exception ex) {
            Logger.getLogger(ChatUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getUserId(){
        return UserId;
    }
    
    public void setUserId(int id){
        UserId = id;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public void setUsername(String name){
        Username = name;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String pwd){
        Password = pwd;
    }
    
    /*private void encryptPassword(String pwd){
        try{
            Password = AES.encrypt(pwd);
        }
        catch(Exception ex){
            Logger.getLogger(ChatUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Integer createUser(String name, String pass){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Integer ret = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //ChatUser newuser = new ChatUser(name, pass);
            //ret = (Integer)session.save(newuser);
            tx.commit();
        }
        catch(HibernateException ex){
            if (tx!=null){
                tx.rollback();
                ret = null;
            }
        }
        finally{
            session.close();
        }
        
        return ret;
    }
    
    public static ChatUser getUser(String name){
        ChatUser ret = null;
        try{
            ret = (ChatUser) HibernateUtil.getEntitiesByField(ChatUser.class, "Username", name).get(0);
        }
        catch(HibernateException ex){
            System.err.println("Error getting entity." + ex);
            ret = null;
        }
        return ret;
    }*/
    
    
    
}
