package com.lambdaschool.fishfriends.repository;

import com.lambdaschool.fishfriends.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRespository extends PagingAndSortingRepository<Location, Long>
{

}
