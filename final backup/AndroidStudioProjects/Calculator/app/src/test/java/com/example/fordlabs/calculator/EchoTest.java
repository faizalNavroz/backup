package com.example.fordlabs.calculator;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



public class EchoTest {

    EchoService echoService = new EchoService();

    //case 1
    @Test
    public void testPing(){
        String message ="starfish";
        assertEquals("Echo:starfish",echoService.ping(message));
    }

    //case 2
    @Test
    public void testPingNotNull(){
        String message  = null;
        assertEquals("There is nothing to echo",echoService.ping(message));
    }

    //case 3
    @Test
    public void testPingForUpperCase(){
        String message="SHARK";
        assertEquals("WARNING:SHARK",echoService.ping(message));
    }

    @Test
    public void testPinging()

}
