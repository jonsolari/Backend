package com.lambdaschool.fishfriends.repository;

import com.lambdaschool.fishfriends.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String name,
                                                  Pageable pageable);
}
