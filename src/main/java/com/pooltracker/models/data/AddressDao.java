package com.pooltracker.models.data;

import com.pooltracker.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Kevin Grier
 */

@Repository
@Transactional
public interface AddressDao extends CrudRepository<Address,Integer> {

}
