package com.solt.unit.test.ds;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Optional;

@EqualsAndHashCode
@ToString
public class BookingResult {
    private BookingState bookingState;
    private Reservation reservation;


    private BookingResult(BookingState bookingState, Reservation reservation) {
        this.bookingState = bookingState;
        this.reservation = reservation;
    }

    public static BookingResult createRoomBookResult(Reservation reservation) {
        return new BookingResult(BookingState.ROOM_BOOKED,reservation);
    }

    public static BookingResult createNoRoomAvailableResult(){
        return new BookingResult(BookingState.NO_ROOM_AVAILABLE,null);
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public Optional<Reservation> getReservation(){
        return Optional.ofNullable(reservation);
    }

    public enum BookingState{
        ROOM_BOOKED,
        NO_ROOM_AVAILABLE
    }
}
