/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.service;

import com.gluo.webchat.maven.Repository.DAO;
import com.gluo.webchat.maven.model.ChatUser;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author luoguanqi
 */
@RequestScoped
public class ChatUserDAOImpl implements ChatUserDAO{

    private DAO<ChatUser> dao;
    
    @Override
    public List<ChatUser> getUsers() {
        return dao.getEntities();
    }

    @Override
    public ChatUser getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChatUser getUserByName(String name) {
        
    }

    @Override
    public ChatUser addUser(String name, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChatUser deleteUser(ChatUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
