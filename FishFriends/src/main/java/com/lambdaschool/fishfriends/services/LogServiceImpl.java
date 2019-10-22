package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Log;
import com.lambdaschool.fishfriends.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "logService")
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

    @Transactional
    @Override
    public Log save(Log log)
    {
        Log newLog = new Log();

        newLog.setLogid(log.getLogid());
        newLog.setTimespent(log.getTimespent());
        newLog.setBaittype(log.getBaittype());
        newLog.setFishnum(log.getFishnum());
        newLog.setFishtypes(log.getFishtypes());
        newLog.setUser(log.getUser());

        return logrepos.save(newLog);

    }
}
