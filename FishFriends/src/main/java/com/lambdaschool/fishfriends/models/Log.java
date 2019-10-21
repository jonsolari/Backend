package com.lambdaschool.fishfriends.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "log")
public class Log extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long logid;


    private String timespent;
    private String baittype;
    private int fishnum;
    private String fishtypes;

    @OneToMany(mappedBy = "log",
    cascade = CascadeType.ALL)
    @JsonIgnoreProperties("log")
    private List<Fish> fishcaught = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userid",
                nullable = false)
    private User user;

    public Log()
    {
    }

    public Log(String timespent, String baittype, int fishnum, String fishtypes, List<Fish> fishcaught, User user)
    {
        this.timespent = timespent;
        this.baittype = baittype;
        this.fishnum = fishnum;
        this.fishtypes = fishtypes;
        this.fishcaught = fishcaught;
        this.user = user;
    }

    public long getLogid()
    {
        return logid;
    }

    public void setLogid(long logid)
    {
        this.logid = logid;
    }

    public String getTimespent()
    {
        return timespent;
    }

    public void setTimespent(String timespent)
    {
        this.timespent = timespent;
    }

    public String getBaittype()
    {
        return baittype;
    }

    public void setBaittype(String baittype)
    {
        this.baittype = baittype;
    }

    public int getFishnum()
    {
        return fishnum;
    }

    public void setFishnum(int fishnum)
    {
        this.fishnum = fishnum;
    }

    public String getFishtypes()
    {
        return fishtypes;
    }

    public void setFishtypes(String fishtypes)
    {
        this.fishtypes = fishtypes;
    }

    public List<Fish> getFishcaught()
    {
        return fishcaught;
    }

    public void setFishcaught(List<Fish> fishcaught)
    {
        this.fishcaught = fishcaught;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
