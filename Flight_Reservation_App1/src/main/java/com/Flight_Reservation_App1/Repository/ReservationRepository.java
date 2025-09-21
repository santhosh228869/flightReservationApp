package com.Flight_Reservation_App1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App1.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
