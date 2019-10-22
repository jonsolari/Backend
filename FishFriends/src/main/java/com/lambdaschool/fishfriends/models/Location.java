package com.lambdaschool.fishfriends.models;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationid;

    @Column(unique = true,
            nullable = false)
    private String locationname;
    private String locationpicurl;
    private String locationdesc;

    public Location()
    {
    }

    public Location(String locationname, String locationpicurl, String locationdesc)
    {
        this.locationname = locationname;
        this.locationpicurl = locationpicurl;
        this.locationdesc = locationdesc;
    }

    public long getLocationid()
    {
        return locationid;
    }

    public void setLocationid(long locationid)
    {
        this.locationid = locationid;
    }

    public String getLocationname()
    {
        return locationname;
    }

    public void setLocationname(String locationname)
    {
        this.locationname = locationname;
    }

    public String getLocationpicurl()
    {
        return locationpicurl;
    }

    public void setLocationpicurl(String locationpicurl)
    {
        this.locationpicurl = locationpicurl;
    }

    public String getLocationdesc()
    {
        return locationdesc;
    }

    public void setLocationdesc(String locationdesc)
    {
        this.locationdesc = locationdesc;
    }
}
