/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Inspiron I5558
 */
public class CoffxTest {

    /**
     * Test of os method, of class Coffx.
     */
    @Test
    public void testOs() {
        System.out.println("os");
        String expResult = "windows";
        String result = Coffx.os();
        assertEquals(expResult, result);
    }

    /**
     * Test of config method, of class Coffx.
     */
    @Test
    public void testConfig() {
        System.out.println("config");
        String expResult = "bd.user,root,bd.password,,bd.bd,test";
        String result = Coffx.config(
                "bd.user", "root",
                "bd.password", "",
                "bd.bd", "test"
        );
        assertEquals(expResult, result);
    }

    /**
     * Test of configByGroup method, of class Coffx.
     */
    @Test
    public void testConfigByGroup() {
        System.out.println("testConfigByGroup");
        Map<String, String> expResult = new HashMap();
        expResult.put("user", "root");
        expResult.put("password", "");
        expResult.put("bd", "test");
        Map<String, String> result = Coffx.configByGroup("bd");
        assertEquals(expResult, result);
    }

    /**
     * Test of start method, of class Coffx.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Coffx.start();
    }
    
}
