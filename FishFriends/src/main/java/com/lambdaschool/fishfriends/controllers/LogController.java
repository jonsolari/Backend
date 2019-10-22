package com.lambdaschool.fishfriends.controllers;

import com.lambdaschool.fishfriends.models.Log;
import com.lambdaschool.fishfriends.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogController
{
    @Autowired
    private LogService logService;

    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> listAll()
    {
        List<Log> list = logService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/add",
    consumes = {"application/json"},
    produces = {"application/json"})
    public ResponseEntity<?> addLog(
                                    @Valid
                                    @RequestBody Log newLog) throws URISyntaxException
    {
        newLog = logService.save(newLog);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{logid}")
                .buildAndExpand(newLog.getLogid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                HttpStatus.CREATED);
    }

}
