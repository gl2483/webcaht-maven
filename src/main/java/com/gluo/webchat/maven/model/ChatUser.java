/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.gluo.webchat.maven.utilities.AES;
import com.gluo.webchat.maven.utilities.HibernateUtil;

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
        Password = pwd;
    }
    
    public ChatUser(String name, String pwd){
        Username = name;
        Password = pwd;
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
        try{
            Password = AES.encrypt(pwd);
        }
        catch(Exception ex){
            Logger.getLogger(ChatUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Integer createUser(String name, String pass){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer ret = null;
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
        }/**/
        return ret;
    }
    
    
    
}
