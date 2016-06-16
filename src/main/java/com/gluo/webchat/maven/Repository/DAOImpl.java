/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.Repository;

import com.gluo.webchat.maven.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luoguanqi
 */

@Repository
public class DAOImpl<E> implements DAO<E>{
    
    private final Class<E> type;
    
    public DAOImpl(){
        type = null;
    }
    
    public DAOImpl(Class<E> type){
        this.type = type;
    }
    
    @Override
    public boolean delete(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            E entity = (E) session.get(type, id);
            session.delete(entity);
            tx.commit();
            return true;
        }catch(Throwable ex){
            if (tx!=null)
                tx.rollback();
            throw ex;
        }
        finally{
            session.close();
        }
    }
    
    @Override
    public List<E> getEntities(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try{
            Criteria criteria = session.createCriteria(type);
            return criteria.list();
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
    }

    @Override
    public boolean add(E entity) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        boolean ret = false;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //ChatUser newuser = new ChatUser(name, pass);
            //ret = (Integer)session.save(newuser);
            ret = true;
            tx.commit();
        }
        catch(HibernateException ex){
            if (tx!=null){
                tx.rollback();
            }
        }
        finally{
            session.close();
        }
        
        return ret;
    }
}
