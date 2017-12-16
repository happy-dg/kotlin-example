package com.example.kotlinexample.domain.reservation

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

interface ReservationRepository : JpaRepository<Reservation, Long>, QueryDslPredicateExecutor<Reservation> {

}