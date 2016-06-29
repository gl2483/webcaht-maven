/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gluo.webchat.maven.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luoguanqi
 */
public class ChatUserTest {
    
    public ChatUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserId method, of class ChatUser.
     */
    @org.junit.Test
    public void testGetUserId() {
        System.out.println("getUserId");
        ChatUser instance = new ChatUser();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class ChatUser.
     */
    @org.junit.Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int id = 0;
        ChatUser instance = new ChatUser();
        instance.setUserId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class ChatUser.
     */
    @org.junit.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        ChatUser instance = new ChatUser();
        String expResult = null;
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class ChatUser.
     */
    @org.junit.Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String name = "";
        ChatUser instance = new ChatUser();
        instance.setUsername(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class ChatUser.
     */
    @org.junit.Test
    public void testGetPassword() {
        System.out.println("getPassword");
        ChatUser instance = new ChatUser();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class ChatUser.
     */
    @org.junit.Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String pwd = "data";
        ChatUser instance = new ChatUser();
        instance.setPassword(pwd);
        // TODO review the generated test code and remove the default call to fail.
        assertNotEquals(instance.getPassword(), null);
        assertEquals(instance.getPassword(), "data");
    }
    
    @org.junit.Test
    public void testResetPassword() {
        System.out.println("setPassword");
        String pwd = "data";
        ChatUser instance = new ChatUser();
        instance.resetPassword(pwd);
        // TODO review the generated test code and remove the default call to fail.
        assertNotEquals(instance.getPassword(), null);
        assertEquals(instance.getPassword(), "fnrBps5pFagcKU0s7q0EpQ==");
    }
    
}
