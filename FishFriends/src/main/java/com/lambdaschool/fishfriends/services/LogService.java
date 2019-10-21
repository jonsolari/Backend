package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Log;

import java.util.List;

public interface LogService
{
    List<Log> findAll();

    Log addLog(Log log);
}
