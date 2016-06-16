/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.utilities;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author luoguanqi
 */
public class HibernateUtil {
    
    private static final SessionFactory factory = initFactory();
    
    private static SessionFactory initFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
         }catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            return null;
      }
    }
    
    public static SessionFactory getSessionFactory(){
        return factory;
    }
    
    public static void shutdown(){
        factory.close();
    }
    
    /*public static List<Object> getEntitiesByField(Class entityClass, String fieldname, String fieldvalue){
        Session session = factory.openSession();
        try{
            Criteria criteria = session.createCriteria(entityClass);
            return criteria.add(Restrictions.eq(fieldname, fieldvalue)).list();
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
    }
    
    public static List<Object> getEntities(Class entityClass){
        Session session = factory.openSession();
        try{
            Criteria criteria = session.createCriteria(entityClass);
            return criteria.list();
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
    }*/
}
