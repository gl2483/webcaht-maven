/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author luoguanqi
 */
public class HibernateUtil {
    
    private static SessionFactory factory = initFactory();
    
    private static SessionFactory initFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
         }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
      }
    }
    
    public static SessionFactory getSessionFactory(){
        return factory;
    }
    
    public static void shutdown(){
        factory.close();
    }
}
