package com.solt.unit.test.ds;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Getter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"room_id","reservationDate"})})
@EqualsAndHashCode
@ToString
public class Reservation {
    @Id
    @GeneratedValue
    UUID id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    private Guest guest;
    private LocalDate reservationDate;

    public Reservation(){

    }

    public Reservation(Room room, Guest guest, LocalDate reservationDate) {
        this.room = room;
        this.guest = guest;
        this.reservationDate = reservationDate;
    }

}
