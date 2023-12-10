package com.solt.unit.test.configuration;

import com.solt.unit.test.ds.Room;
import com.solt.unit.test.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultDataConfiguration {

    public static final String GREEN_ROOM = "Green Room";
    public static final String YELLOW_ROOM = "Yellow Room";
    public static final String BLUE_ROOM = "Blue Room";

//    @Autowired
//    private RoomRepository roomRepository;

    @PostConstruct
    public void registerHotelRooms() {
//       registerRoom(new Room(GREEN_ROOM,"A01"));
//       registerRoom(new Room(YELLOW_ROOM,"A02"));
//       registerRoom(new Room(BLUE_ROOM,"B01"));
//    }

//    private void registerRoom(Room room) {
//        roomRepository.save(room);
//    }
    }
}
