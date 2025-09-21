package com.Flight_Reservation_App1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App1.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
