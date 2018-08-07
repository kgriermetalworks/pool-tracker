package com.pooltracker.models.data;


import com.pooltracker.models.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Kevin Grier
 */

@Repository
@Transactional
public interface ClientDao extends CrudRepository<Client, Integer> {
}
