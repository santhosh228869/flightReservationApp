package com.Flight_Reservation_App1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Flight_Reservation_App1.DTO.ReservationUpdateRequest;
import com.Flight_Reservation_App1.Entity.Reservation;
import com.Flight_Reservation_App1.Repository.ReservationRepository;

@RestController//it convert JSoN object to java object ,java object to JSON object
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepo;
	//which tool did you use test your restfull services ?postman
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {//pathvariable it take id value from url and fethch it in the Long id
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}

	
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepo.save(reservation);
	}
	
	
	
}
