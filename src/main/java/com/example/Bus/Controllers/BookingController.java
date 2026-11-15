    package com.example.Bus.Controllers;

    import com.example.Bus.Entities.*;
    import com.example.Bus.Repositories.BookingRepo;
    import com.example.Bus.Repositories.BookingSeatRepo;
    import com.example.Bus.Repositories.SeatRepo;
    import com.example.Bus.Repositories.TripRepo;
    import com.example.Bus.Service.BookingService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.time.LocalDateTime;
    import java.util.Optional;

    @CrossOrigin(origins = "http://localhost:5173")
    @RestController
    public class BookingController {

        @Autowired
        private BookingRepo bookingRepo;

        @Autowired
        private BookingService bookingService;

        @Autowired
        private BookingSeatRepo bookingSeatRepo;

        @Autowired
        private TripRepo tripRepo;

        @Autowired
        private SeatRepo seatRepo;

        @PostMapping("/book/seat/{tripid}/{seats}")
        public Booking seatBooked(@PathVariable Integer tripid, @PathVariable List<Integer> seats){
          System.out.println("Trip "+tripid + " seats"+ seats);
            Trip trip = tripRepo.findById(tripid)
                    .orElseThrow(() -> new RuntimeException("Trip not found"));
             Booking booking= new Booking();

             booking.setTrip(trip);
             booking.setBookingDate(LocalDateTime.now());
             booking.setStatus(BookingStatus.CONFORMED);
             booking=bookingRepo.save(booking);

            List<Seat> seatList = seatRepo.findAllById(seats);
            List<BookingSeat> bookingSeats=new ArrayList<>();

            for(Seat seat : seatList){
                BookingSeat bookingSeat= new BookingSeat();
                bookingSeat.setSeat(seat);
                bookingSeat.setBooking(booking);
               bookingSeats.add(bookingSeatRepo.save(bookingSeat));
            }


        return booking;
        }

    }
