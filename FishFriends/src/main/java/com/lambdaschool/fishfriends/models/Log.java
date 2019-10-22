package com.lambdaschool.fishfriends.models;

import javax.persistence.*;


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

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Log()
    {
    }

    public Log(String timespent,
               String baittype,
               int fishnum,
               String fishtypes,
               User user)
    {
        this.timespent = timespent;
        this.baittype = baittype;
        this.fishnum = fishnum;
        this.fishtypes = fishtypes;
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Log{" +
                "logid=" + logid +
                ", timespent='" + timespent + '\'' +
                ", baittype='" + baittype + '\'' +
                ", fishnum=" + fishnum +
                ", fishtypes='" + fishtypes + '\'' +
                ", user=" + user +
                '}';
    }
}
