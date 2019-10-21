package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Log;
import com.lambdaschool.fishfriends.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LogServiceImpl implements LogService
{
    @Autowired
    private LogRepository logrepos;

    @Override
    public List<Log> findAll()
    {
        ArrayList<Log> list = new ArrayList<>();
        logrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Log addLog(Log log)
    {
        return null;
    }
}
