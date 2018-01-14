package com.contaazul.robo.service;

import com.contaazul.robo.RoboApplicationTests;
import com.contaazul.robo.exception.InvalidCommandException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommandServiceTest extends RoboApplicationTests {

    @Autowired
    private CommandService commandService;

    @Test(expected = InvalidCommandException.class)
    public void splitCommandEmptyTest(){
        commandService.splitCommand("");
    }

    @Test(expected = InvalidCommandException.class)
    public void splitCommandNullTest(){
        commandService.splitCommand(null);
    }

    @Test(expected = InvalidCommandException.class)
    public void splitInvalidCommandTest(){
        commandService.splitCommand("C");
    }

    @Test(expected = InvalidCommandException.class)
    public void splitInvalidListCommandTest(){
        commandService.splitCommand("CML");
    }

    @Test(expected = InvalidCommandException.class)
    public void splitInvalidListCommandWithSpaceTest(){
        commandService.splitCommand("C M,L");
    }

    @Test
    public void splitCommandValidTest(){
        final List<String> commands = commandService.splitCommand("MML");
        assertNotNull(commands);
        assertEquals(3, commands.size());
        assertTrue(commands.contains("M"));
        assertTrue(commands.contains("L"));
    }
}
