package com.solt.unit.test.service;

import com.google.common.collect.Sets;
import com.solt.unit.test.ds.Guest;
import com.solt.unit.test.ds.Reservation;
import com.solt.unit.test.ds.Room;
import com.solt.unit.test.repository.ReservationRepository;
import com.solt.unit.test.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository romRoomRepository;

    public Optional<Room> findAvailableRoom(LocalDate date) {
        Set<Room> roomRepository;
        Set<Room> allRooms=romRoomRepository.findAll();
        Set<Reservation> reservationOnDate= reservationRepository.findAllByReservationDate(date);

        Set<Room> roomsReservedAtDate = reservationOnDate.stream()
                .map(Reservation::getRoom)
                .collect(Collectors.toSet());

        Set<Room> roomsAvailableAtDate = Sets.difference(allRooms, roomsReservedAtDate).immutableCopy();

        return roomsAvailableAtDate.stream().findAny();
    }

    public Optional<Reservation> bookRoom(String roomName, Guest guest, LocalDate date) {
        return bookRoom(romRoomRepository.findByName(roomName).orElseThrow(),guest,date);
    }

    public Optional<Reservation> bookRoom(Room room, Guest guest,LocalDate date) {
        if (isRoomAvailableAtDate(room,date)){
            return Optional.of(reservationRepository.save(new Reservation(room,guest,date)));
        }
        else{
            return Optional.empty();
        }
    }

    private boolean isRoomAvailableAtDate(Room room, LocalDate date){
        return reservationRepository.existsByRoomAndReservationDate(room,date);
    }
}