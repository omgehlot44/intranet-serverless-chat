package com.ofaul.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ofaul.business.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

//    @Query(value = "SELECT client_id FROM client")
//    Object[][] getClientReservationsCount();

}