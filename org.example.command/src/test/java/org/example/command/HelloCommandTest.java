package org.example.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloCommandTest {

    @Test
    public void test() {
    	HelloCommand cmd = new HelloCommand();
    	assertEquals("Hello, Donald", cmd.sayHello("Donald"));
    }

}
