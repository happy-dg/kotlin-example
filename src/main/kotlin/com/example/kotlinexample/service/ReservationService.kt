package com.example.kotlinexample.service

import com.example.kotlinexample.domain.reservation.ReservationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ReservationService @Autowired constructor(
        private val scheduleFinder: ScheduleFinder,
        private val userFinder: UserFinder,
        private val repository: ReservationRepository

) {

    fun doReservation(scheduleId: Long, seatNos: List<Int>, userId: Long) {

        val schedule = scheduleFinder.findById(scheduleId)
        schedule?.let {
            val user = userFinder.findById(userId) ?: throw RuntimeException("not found User.")
            repository.save(it.createReservation(user, seatNos))
        } ?: throw RuntimeException("not found Schedule.")
    }
}