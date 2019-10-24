package com.lambdaschool.fishfriends.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.fishfriends.models.Log;
import com.lambdaschool.fishfriends.repository.LogRepository;
import com.lambdaschool.fishfriends.services.LogService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LogController.class, secure = false)
public class LogControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogService logService;

    private List<Log> logList;

    @Before
    public void setUp() throws Exception
    {
        logList = new ArrayList<>();
        Log l1 = new Log("5 hrs", "Live Bait", 4, "Haddock", "Connecticut River", "Jim Davis");
        Log l2 = new Log("2 hrs", "Worms", 5, "Carp", "Lake Massabesic", "Jim Davis");
        Log l3 = new Log("4 hrs", "Crawlers", 1, "Perch", "Beaver Lake", "Jim Davis");
        logList.add(l1);
        logList.add(l2);
        logList.add(l3);
        l1.setLogid(1);
        l2.setLogid(2);
        l3.setLogid(3);

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void listAllLogs() throws Exception
    {

        String apiUrl = "/logs/all";
        Mockito.when(logService.findAll()).thenReturn(logList);

        RequestBuilder rb
                = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(logList);

        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void addNewLog() throws Exception
    {
        String apiUrl = "/logs/add";

        Log l4 = new Log("14 hrs", "Sandwich", 1, "Grouper", "Bathtub", "Dave Beede");
        l4.setLogid(100);
        ObjectMapper mapper = new ObjectMapper();
        String restaurantString = mapper.writeValueAsString(l4);

        Mockito.when(logService.save(any(Log.class))).thenReturn(l4);


        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(restaurantString);
        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }
}
