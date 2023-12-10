package com.solt.unit.test.repository;

import com.solt.unit.test.ds.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuestRepository extends CrudRepository<Guest, UUID> {

}
