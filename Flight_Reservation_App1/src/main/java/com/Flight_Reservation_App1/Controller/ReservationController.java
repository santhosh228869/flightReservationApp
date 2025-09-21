package com.Flight_Reservation_App1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Flight_Reservation_App1.DTO.ReservationRequest;
import com.Flight_Reservation_App1.Entity.Reservation;
import com.Flight_Reservation_App1.Service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	@RequestMapping("/ConfirmReservation")
public String completeReservation(ReservationRequest request,ModelMap modelmap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelmap.addAttribute("reservationId", reservationId.getId());
	return"ConfirmReservation";
}
}
