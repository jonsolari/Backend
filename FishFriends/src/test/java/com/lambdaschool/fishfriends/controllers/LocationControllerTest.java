package com.lambdaschool.fishfriends.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.fishfriends.models.Location;
import com.lambdaschool.fishfriends.services.LocationService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LocationController.class, secure = false)
public class LocationControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    private List<Location> locList;

    @Before
    public void setUp() throws Exception
    {
        locList = new ArrayList<>();
        Location l1 = new Location( "Grand View Lake", "http://tinyimg.io/i/pabHplC.jpg", "A placid body of water known for its plentiful carp.");
        Location l2 = new Location("Beaver Lake", "http://tinyimg.io/i/cqkZa7b.jpg", "Secluded lake for those in-the-know.");
        Location l3 = new Location("Lake Massabesic",  "http://tinyimg.io/i/XszFWHM.jpg", "A larger lake with many spoils for the patient angler.");
        Location l4 = new Location("Kancamagus River", "http://tinyimg.io/i/908Cwd6.jpg", "Long, winding river with many good spots.");
        Location l5 = new Location("Connecticut River", "http://tinyimg.io/i/GN38nuT.jpg", "A deep, wide river with legendary status.");

        locList.add(l1);
        locList.add(l2);
        locList.add(l3);
        locList.add(l4);
        locList.add(l5);
        l1.setLocationid(1);
        l2.setLocationid(2);
        l3.setLocationid(3);
        l4.setLocationid(4);
        l5.setLocationid(5);

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void listAllLocations() throws Exception
    {

        String apiUrl = "/locations/all";
        Mockito.when(locationService.findAll()).thenReturn(locList);

        RequestBuilder rb
                = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(locList);

        assertEquals("Rest API Returns List", er, tr);
    }
}
