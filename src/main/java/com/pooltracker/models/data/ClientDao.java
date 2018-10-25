package com.pooltracker.models.data;


import com.pooltracker.models.Client;

import com.pooltracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kevin Grier
 */

@Repository
@Transactional
public interface ClientDao extends CrudRepository<Client, Integer> {

    public List<Client> findByUser(User user);

}
