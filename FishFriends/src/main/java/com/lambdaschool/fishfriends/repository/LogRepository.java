package com.lambdaschool.fishfriends.repository;

import com.lambdaschool.fishfriends.models.Log;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogRepository extends PagingAndSortingRepository<Log, Long>
{

}
