package edu.upc.dsa;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectTest {
    //Log
    final static Logger log = Logger.getLogger(Test.class.getName());
    static TracksManager tm;

    //Before
    @BeforeClass
    public static void setUp() {

    }

    //After
    @AfterClass
    public static void tearDown(){
        tm=null;
    }

    //Tests
    //Test método de test para realizar un pedido

}
