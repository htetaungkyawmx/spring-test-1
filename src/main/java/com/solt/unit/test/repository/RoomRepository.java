package com.solt.unit.test.repository;

import com.solt.unit.test.ds.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface RoomRepository extends CrudRepository<Room, UUID> {
    Set<Room> findAll();


    Optional<Room> findByName(String name);
}
