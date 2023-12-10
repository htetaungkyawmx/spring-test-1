package com.solt.unit.test.repository;

import com.solt.unit.test.ds.Reservation;
import com.solt.unit.test.ds.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, UUID> {

    Set<Reservation> findAllByReservationDate(LocalDate reservationDate);

    boolean existsByRoomAndReservationDate(Room room,LocalDate reservationDate);
}
