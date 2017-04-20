/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.Datasource;

import com.mundosica.coffx.Coffx;
import com.mundosica.coffx.Datasource.BD;
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
public class BDTest {
    
    @BeforeClass
    public static void setUpClass() {
        /*String result = Coffx.config(
                "bd.user", "root",
                "bd.password", "",
                "bd.bd", "test"
        );
        Coffx.start();*/
    }
    
    @AfterClass
    public static void tearDownClass() {
        BD.end();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of config method, of class BD.
     */
    @Test
    public void testConfig() {
        System.out.println("Config");
        BD.config(
            "bd"   , "test",
            "user" , "root",
            "password" , ""
       );
        assertEquals("test", BD.config("bd"));
        assertEquals("root", BD.config("user"));
        assertEquals("", BD.config("password"));
    }

    /**
     * Test of initBD method, of class BD.
     */
    @Test
    public void testInitBD() {
        System.out.println("initBD");
        boolean expResult = true;
        boolean result = BD.initBD();
        assertEquals(expResult, result);
    }

    /**
     * Test of url method, of class BD.
     */
    @Ignore
    public void testUrl() {
        System.out.println("url");
        String result = BD.url();
        System.out.println(result);
    }

    /**
     * Test of status method, of class BD.
     */
    @Ignore
    public void testStatus() {
        System.out.println("status");
        System.out.println(BD.status());
    }

    /**
     * Test of end method, of class BD.
     */
    @Ignore
    public void testEnd() {
        System.out.println("end");
        BD.end();
    }
    
}
