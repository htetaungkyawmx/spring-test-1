package com.solt.unit.test.application;

import com.solt.unit.test.ds.BookingResult;
import com.solt.unit.test.ds.Guest;
import com.solt.unit.test.ds.Reservation;
import com.solt.unit.test.ds.Room;
import com.solt.unit.test.service.BookingService;
import com.solt.unit.test.service.GuestRegistrationService;
import org.aspectj.apache.bcel.classfile.LocalVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private GuestRegistrationService guestRegistrationService;
    @Autowired
    private BookingService bookingService;

    public BookingResult bookAnyRoomForNewGuest(String firstName, String lastName, LocalDate date) {
        Optional<Room> availableRoom = bookingService.findAvailableRoom(date);
        if (availableRoom.isPresent()) {
            Guest registeredGuest = guestRegistrationService.registerGuest(firstName, lastName);
            return BookingResult.createRoomBookResult(
                    bookingService.bookRoom(availableRoom.get(), registeredGuest, date).orElseThrow()
            );
        } else {
            return BookingResult.createNoRoomAvailableResult();
        }
    }

    private Guest registerGuest(String firstName, String lastName) {
        Guest guestToRegister = new Guest(firstName, lastName);
        return guestRegistrationService.registerGuest(guestToRegister);
    }

    public BookingResult bookAnyRoomForRegisteredGuest(Guest guest, LocalDate date) {
        Optional<Room> availableRoom = bookingService.findAvailableRoom(date);

        if (availableRoom.isPresent()) {
            return BookingResult.createRoomBookResult(bookingService.bookRoom(availableRoom.get(), guest, date).orElseThrow());
        } else
            return BookingResult.createNoRoomAvailableResult();
    }

    public BookingResult bookSpecificRoomForRegisteredGuest(Guest guest,String roomName,LocalDate date){
        Optional<Reservation> reservation=bookingService.bookRoom(roomName,guest,date);

        return reservation
                .map(BookingResult::createRoomBookResult)
                .orElseGet(BookingResult::createNoRoomAvailableResult);

    }
}
