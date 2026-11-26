    package com.example.Bus.Controllers;

    import com.example.Bus.Entities.*;
    import com.example.Bus.Repositories.*;
    import com.example.Bus.Service.BookingService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.security.Principal;
    import java.time.LocalDate;
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

        @Autowired
        private UserRepo userRepo;

        @PostMapping("/book/seat/{tripid}/{seats}/{date}")
        public String seatBooked(@PathVariable Integer tripid, @PathVariable List<Integer> seats, @PathVariable LocalDate date,Principal principal){
          System.out.println("Trip "+tripid + " seats"+ seats);
            Trip trip = tripRepo.findById(tripid)
                    .orElseThrow(() -> new RuntimeException("Trip not found"));
            Booking booking = new Booking();
             Bus bus = trip.getBus(); // get BusId from Trip
            System.out.println("Bus Id " +bus.getBusId());

            if(trip.getTripDate().isEqual(date)) {
                 String user = principal.getName();

                booking.setTrip(trip);
                booking.setBookingDate(date);
                booking.setUser(userRepo.findByUserEmail(user));
                booking.setStatus(BookingStatus.CONFORMED);
                booking = bookingRepo.save(booking);

                List<Integer> seatList = seats;
                List<BookingSeat> bookingSeats = new ArrayList<>();

                for (Integer seat : seatList) {
                    BookingSeat bookingSeat = new BookingSeat();
                    System.out.println("Seats of Booking : " + seatRepo.findByBusBusIdAndSeatNumber(bus.getBusId(), seat));
                    bookingSeat.setSeat(seatRepo.findByBusBusIdAndSeatNumber(bus.getBusId(), seat));  // Here we check Both in Seat table " BusID and Seat Number "
                    bookingSeat.setBooking(booking);
                    bookingSeat.setTrip(trip);
                    bookingSeats.add(bookingSeatRepo.save(bookingSeat));

                }
                return " Booking Conformed";
            }else{
                return " No Trips on that Date";
            }

        }

    }
