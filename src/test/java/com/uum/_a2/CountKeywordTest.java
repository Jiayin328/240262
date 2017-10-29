/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum._a2;

import java.util.Map;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carynne
 */
public class CountKeywordTest {
    
    public CountKeywordTest() {
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
     * Test of countKeywords method, of class CountKeyword.
     */
    @Test
    public void testCountKeywords() throws Exception {
        System.out.println("countKeywords");
        CountKeyword instance = new CountKeyword();
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("class", 1);
        expResult.put("extends", 1);
        expResult.put("new", 1);
        expResult.put("package", 1);
        expResult.put("public", 2);
        expResult.put("static", 1);
        expResult.put("void", 2);
        Map<String, Integer> result = instance.countKeywords();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of noKeywords method, of class CountKeyword.
     */
    @Test
    public void testNoKeywords() {
        System.out.println("noKeywords");
        CountKeyword instance = new CountKeyword();
        int expResult = 0;
        int result = instance.noKeywords();
        assertEquals(expResult, result);
    }
    
}
