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

}
