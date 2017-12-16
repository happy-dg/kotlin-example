package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

interface ScheduleRepository : JpaRepository<Schedule, Long>, QueryDslPredicateExecutor<Reservation> {

}