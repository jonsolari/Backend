package com.lambdaschool.fishfriends.controllers;

import com.lambdaschool.fishfriends.models.Location;
import com.lambdaschool.fishfriends.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/locations")
public class LocationController
{
    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> listAll()
    {
        List<Location> list = locationService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/add",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addLog(
            @Valid
            @RequestBody Location newLoc) throws URISyntaxException
    {
        newLoc = locationService.save(newLoc);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{locationid}")
                .buildAndExpand(newLoc.getLocationid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                HttpStatus.CREATED);
    }
}
