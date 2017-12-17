package com.example.kotlinexample.service

import com.example.kotlinexample.domain.reservation.ReservationRepository
import com.example.kotlinexample.service.schedule.ScheduleFinder
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
                ?: throw RuntimeException("not found Schedule.")
        val user = userFinder.findById(userId)
                ?: throw RuntimeException("not found User.")
        repository.save(schedule.createReservation(user, seatNos))
    }
}

