package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.FishFriendsApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FishFriendsApp.class)
public class LogServiceImplTest
{

    @Autowired
    private LogService logService;

    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findAll()
    {

    }

    @Test
    public void save()
    {
    }
}