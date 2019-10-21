package com.lambdaschool.fishfriends.controllers;

import com.lambdaschool.fishfriends.models.Log;
import com.lambdaschool.fishfriends.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
