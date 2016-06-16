/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.service;

import com.gluo.webchat.maven.model.ChatUser;
import java.util.List;

/**
 *
 * @author luoguanqi
 */
public interface ChatUserDAO {
    List<ChatUser> getUsers();
    ChatUser getUserById(int id);
    ChatUser getUserByName(String name);
    ChatUser addUser(String name, String password);
    ChatUser deleteUser(ChatUser user);
}
