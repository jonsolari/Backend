package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Location;

import java.util.List;

public interface LocationService
{
    List<Location> findAll();

    Location save(Location location);
}
