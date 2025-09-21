package com.Flight_Reservation_App1.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_Reservation_App1.DTO.ReservationRequest;
import com.Flight_Reservation_App1.Entity.Flight;
import com.Flight_Reservation_App1.Entity.Passenger;
import com.Flight_Reservation_App1.Entity.Reservation;
import com.Flight_Reservation_App1.Repository.FlightRepository;
import com.Flight_Reservation_App1.Repository.PassengerRepository;
import com.Flight_Reservation_App1.Repository.ReservationRepository;
import com.Flight_Reservation_App1.util.EmailUtil;
import com.Flight_Reservation_App1.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
  @Autowired
  private PassengerRepository passengerRepo;
  
  @Autowired
  private FlightRepository flightRepo;
  
  @Autowired
  private ReservationRepository reservationRepo;
  
  @Autowired
  private PdfGenerator pdfGenerator;
  
  @Autowired
  private EmailUtil emailUtil;
   
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhoneNo(request.getPhoneNo());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath="D:\\STS Code\\Flight_Reservation_App1\\Tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		Date dateOfDeparture = reservation.getFlight().getDateOfDeparture();
		String date = dateOfDeparture.toString();
		
		Timestamp estimatedDepartureTime = reservation.getFlight().getEstimatedDepartureTime();
		String time = estimatedDepartureTime.toString();
		pdfGenerator.generateItinerary(reservation,filePath,date,time);
		emailUtil.sendItinerary(passenger.getEmail(),filePath );
		return reservation;
	}

}
