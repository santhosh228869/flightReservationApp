package com.Flight_Reservation_App1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App1.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);



}
