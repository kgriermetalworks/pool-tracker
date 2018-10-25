package com.pooltracker.models.data;


import com.pooltracker.models.Client;
import com.pooltracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    public List<User> findByEmail(String email);

}
