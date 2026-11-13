    package com.example.Bus.Controllers;

    import com.example.Bus.Entities.*;
    import com.example.Bus.Repositories.BookingRepo;
    import com.example.Bus.Repositories.BookingSeatRepo;
    import com.example.Bus.Service.BookingService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;
    import java.util.Date;
    import java.util.List;
    import java.time.LocalDateTime;

    @RestController
    public class BookingController {

        @Autowired
        private BookingRepo bookingRepo;

        @Autowired
        private BookingService bookingService;

        @Autowired
        private BookingSeatRepo bookingSeatRepo;

        @PostMapping("/book/seat/{tripid}/{seats}")
        public Booking seatBooked(@PathVariable("tripid") Trip tripId, @PathVariable("seats") List<Seat> seats){
          System.out.println("Trip "+tripId + " seats"+ seats);
             Booking booking= new Booking();
             booking.setTrip(tripId);
             booking.setBookingDate(LocalDateTime.now());
             booking.setStatus(BookingStatus.CONFORMED);

             booking=bookingRepo.save(booking);

            for(Seat seat : seats){
                BookingSeat bookingSeat= new BookingSeat();
                bookingSeat.setSeat(seat);
                bookingSeat.setBooking(booking);
                bookingSeatRepo.save(bookingSeat);
            }

        return booking;
        }

    }
