package com.solt.unit.test;

import com.solt.unit.test.application.ApplicationService;
import com.solt.unit.test.configuration.ApplicationConfiguration;
import com.solt.unit.test.ds.BookingResult;
import com.solt.unit.test.ds.Guest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.Month;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        ApplicationService applicationService=context.getBean(ApplicationService.class);

        BookingResult bookingResult1=applicationService
                .bookAnyRoomForNewGuest("John","William", LocalDate.of(2023, Month.DECEMBER,10));
        System.out.println("Booking Result for John William at 10/12/2023 is "+ bookingResult1);

        Guest guest=applicationService.registerGuest("Milo","Steele");
        System.out.println("Milo Steele registered as "+ guest);
        BookingResult bookingResult2=applicationService
                .bookAnyRoomForRegisteredGuest(guest,LocalDate.of(2023,Month.DECEMBER,10));
        System.out.println("Booking Result for Milo Steele at 10/12/2023 is "+ bookingResult2);

        BookingResult bookingResult3=applicationService
                .bookSpecificRoomForRegisteredGuest(guest,"Yellow Room",LocalDate.of(2023,Month.DECEMBER,10));
        System.out.println("Booking Result for specific room for already registered guest Milo Steele at 10/12/2023 is "+ bookingResult3);
    }

}
