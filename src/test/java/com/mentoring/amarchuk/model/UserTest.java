package com.mentoring.amarchuk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User user=new User(1,"Stacy","stacy@gmail.com");

    @Test
    public void testGetNameUser(){
        assertEquals("Stacy",user.getName());
    }
    @Test
    public void testGetIdUser(){
        assertEquals(1,user.getId());
    }
    @Test
    public void testGetEmailUser(){
        assertEquals("stacy@gmail.com",user.getEmail());
    }


}