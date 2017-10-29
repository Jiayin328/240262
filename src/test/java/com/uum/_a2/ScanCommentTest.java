/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum._a2;

import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ScanCommentTest {
    
    public ScanCommentTest()throws FileNotFoundException, IOException {
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
     * Test of getSem method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetSem() throws FileNotFoundException, IOException{
        System.out.println("getSem");
        ScanComment instance = new ScanComment();
        String expResult = "A171";
        String result = instance.getSem();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetCourse() throws FileNotFoundException, IOException{
        System.out.println("getCourse");
        ScanComment instance = new ScanComment();
        String expResult = "STIW3054";
        String result = instance.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGroup method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetGroup() throws FileNotFoundException, IOException{
        System.out.println("getGroup");
        ScanComment instance = new ScanComment();
        String expResult = "A";
        String result = instance.getGroup();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTask method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetTask() throws FileNotFoundException, IOException{
        System.out.println("getTask");
        ScanComment instance = new ScanComment();
        String expResult = "Assignment1";
        String result = instance.getTask();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetName()throws FileNotFoundException, IOException {
        System.out.println("getName");
        ScanComment instance = new ScanComment();
        String expResult = "Lin Dan";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMatric method, of class scanComment.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetMatric() throws FileNotFoundException, IOException{
        System.out.println("getMatric");
        ScanComment instance = new ScanComment();
        String expResult = "898989";
        String result = instance.getMatric();
        assertEquals(expResult, result);
    }
    
}