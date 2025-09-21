package com.Flight_Reservation_App1.Service;

import com.Flight_Reservation_App1.DTO.ReservationRequest;
import com.Flight_Reservation_App1.Entity.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
