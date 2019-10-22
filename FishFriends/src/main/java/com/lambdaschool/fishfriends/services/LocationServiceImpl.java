package com.lambdaschool.fishfriends.services;

import com.lambdaschool.fishfriends.models.Location;
import com.lambdaschool.fishfriends.repository.LocationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "locationService")
public class LocationServiceImpl implements LocationService
{
    @Autowired
    private LocationRespository locrepos;

    @Override
    public List<Location> findAll()
    {
        ArrayList<Location> list = new ArrayList<>();
        locrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Location save(Location location)
    {
        Location newLoc = new Location();

        newLoc.setLocationid(location.getLocationid());
        newLoc.setLocationname(location.getLocationname());
        newLoc.setLocationpicurl(location.getLocationpicurl());
        newLoc.setLocationdesc(location.getLocationdesc());

        return locrepos.save(newLoc);

    }
}
