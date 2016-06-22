package com.gluo.webchat.maven.service;

import com.gluo.webchat.maven.model.ChatUser;
import com.gluo.webchat.maven.utilities.HibernateUtil;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

/**
 *
 * @author luoguanqi
 */
@Service
public class ChatUserDAOImpl implements ChatUserDAO{
    
    //private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Inject
    private SessionFactory sessionFactory;
    
    @Override
    public List<ChatUser> getUsers() {
        Session session = sessionFactory.openSession();
        try{
            Criteria criteria = session.createCriteria(ChatUser.class);
            return criteria.list();
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
        /*throw new UnsupportedOperationException("Not supported yet.");*/
    }

    @Override
    public ChatUser getUserById(int id) {
        Session session = sessionFactory.openSession();
        try{
            return (ChatUser)session.get(ChatUser.class, id);
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
        /*throw new UnsupportedOperationException("Not supported yet.");*/
    }

    @Override
    public ChatUser getUserByName(String name) {
        Session session = sessionFactory.openSession();
        try{
            Criteria criteria = session.createCriteria(ChatUser.class);
            return (ChatUser)criteria.add(Restrictions.eq("Username", name)).list().get(0);
        }catch(Throwable ex){
            throw ex;
        }
        finally{
            session.close();
        }
        /*throw new UnsupportedOperationException("Not supported yet.");*/
    }

    @Override
    public void addUser(String name, String password) {
        Session session = sessionFactory.openSession();
        //Transaction tx = null;
        try{
            //tx = session.beginTransaction();
            ChatUser entity = (ChatUser) getUserByName(name);
            if(entity == null){
                entity = new ChatUser(name, password);
                session.save(entity);
            }
            else
                throw new UnsupportedOperationException("User: " + name + " already exists");
            //tx.commit();
        }
        catch(HibernateException ex){
            //if (tx!=null){
                //tx.rollback();
            //}
            throw ex;
        }
        finally{
            session.close();
        }
        /*throw new UnsupportedOperationException("Not supported yet.");*/
    }

    @Override
    public void deleteUser(ChatUser user) {
        Session session = sessionFactory.openSession();
        //Transaction tx = null;
        try{
            //tx = session.beginTransaction();
            ChatUser entity = (ChatUser) session.get(ChatUser.class, user.getUserId());
            session.delete(entity);
            //tx.commit();
        }catch(Throwable ex){
            //if (tx!=null)
                //tx.rollback();
            throw ex;
        }
        finally{
            session.close();
        }
        /*throw new UnsupportedOperationException("Not supported yet.");*/
    }
    
}
