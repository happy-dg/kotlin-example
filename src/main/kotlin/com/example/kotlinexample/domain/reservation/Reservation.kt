package com.example.kotlinexample.domain.reservation

import com.example.kotlinexample.domain.schedule.Schedule
import com.example.kotlinexample.domain.user.User

data class Reservation(
        var schedule: Schedule,
        var user: User,
        var totalPrice: Long = 0,
        var seats: MutableSet<ReservationSeat> = mutableSetOf()
) {

    fun addSeat(seat: ReservationSeat) {
        seats.add(seat)
    }
}