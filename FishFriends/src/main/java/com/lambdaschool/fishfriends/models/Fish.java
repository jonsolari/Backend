package com.lambdaschool.fishfriends.models;

import javax.persistence.*;

public class Fish
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fishid;

    @Column
    private String fishquantity;
    private String fishtype;

    @ManyToOne
    @JoinColumn(name = "logid",
                nullable = false)
    private Log log;

    public Fish()
    {
    }

    public Fish(String fishquantity, String fishtype, Log log)
    {
        this.fishquantity = fishquantity;
        this.fishtype = fishtype;
        this.log = log;
    }

    public long getFishid()
    {
        return fishid;
    }

    public void setFishid(long fishid)
    {
        this.fishid = fishid;
    }

    public String getFishquantity()
    {
        return fishquantity;
    }

    public void setFishquantity(String fishquantity)
    {
        this.fishquantity = fishquantity;
    }

    public String getFishtype()
    {
        return fishtype;
    }

    public void setFishtype(String fishtype)
    {
        this.fishtype = fishtype;
    }

    public Log getLog()
    {
        return log;
    }

    public void setLog(Log log)
    {
        this.log = log;
    }
}
