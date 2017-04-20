/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mundosica.coffx.utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.mundosica.coffx.utility.Util.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Ignore;
/**
 *
 * @author Inspiron I5558
 */
public class UtilTest {
    
    public UtilTest() {
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
     * Test of under_score2 method, of class Util.
     */
    @Test
    public void testUnder_scores() {
        String str = "HolaMundoEsteEsUnEjemploDelUnderScore";
        String expResult = "hola_mundo_este_es_un_ejemplo_del_under_score";
        String result = under_score2(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of empty method, of class Util.
     */
    @Test
    public void testEmpty_ObjectArr() {
        
    }

    /**
     * Test of empty method, of class Util.
     */
    @Test
    public void testEmpty_Collection() {
    }

    /**
     * Test of empty method, of class Util.
     */
    @Test
    public void testEmpty_String() {
    }

    /**
     * Test of join method, of class Util.
     */
    @Test
    public void testJoin_StringArr_String() {
    }

    /**
     * Test of join method, of class Util.
     */
    @Test
    public void testJoin_Collection_String() {
    }

    /**
     * Test of join method, of class Util.
     */
    @Test
    public void testJoin_Map_String() {
    }

    /**
     * Test of repeat method, of class Util.
     */
    @Test
    public void testRepeat() {
    }

    /**
     * Test of repeatInArray method, of class Util.
     */
    @Test
    public void testRepeatInArray() {
    }

    /**
     * Test of joinAndRepeat method, of class Util.
     */
    @Ignore
    public void testJoinAndRepeat() {
        System.out.println("joinAndRepeat");
        String str = "";
        String delimiter = "";
        int count = 0;
        String expResult = "";
        String result = Util.joinAndRepeat(str, delimiter, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of args method, of class Util.
     */
    @Ignore
    public void testArgs() {
        System.out.println("args");
        String[] input = null;
        Map<String, String> expResult = null;
        Map<String, String> result = Util.args(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of echo method, of class Util.
     */
    @Ignore
    public void testEcho_Map() {
        System.out.println("echo");
        Map map = null;
        Util.echo(map);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of echo method, of class Util.
     */
    @Ignore
    public void testEcho_Collection() {
        System.out.println("echo");
        Collection collection = null;
        Util.echo(collection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of echo method, of class Util.
     */
    @Ignore
    public void testEcho_String() {
        System.out.println("echo");
        String str = "";
        Util.echo(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of echo method, of class Util.
     */
    @Ignore
    public void testEcho_Object() {
        System.out.println("echo");
        Object o = null;
        Util.echo(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of camel method, of class Util.
     */
    @Test
    public void testCamel() {
        System.out.println("camel");
        String expResult = "HolaMundo";
        String result = Util.camel("hola mundo");
        assertEquals(expResult, result);
    }

    /**
     * Test of under_score method, of class Util.
     */
    @Ignore
    public void testUnder_score() {
        System.out.println("under_score");
        String str = "";
        String expResult = "";
        String result = Util.under_score(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of under_score2 method, of class Util.
     */
    @Ignore
    public void testUnder_score2() {
        System.out.println("under_score2");
        String str = "";
        String expResult = "";
        String result = Util.under_score2(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Util.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
        String[] arg = null;
        Util.main(arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
