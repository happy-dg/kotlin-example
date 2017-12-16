package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import com.example.kotlinexample.domain.reservation.ReservationSeat
import com.example.kotlinexample.domain.user.User
import java.util.*

data class Schedule(
        var destination: String = "",
        var salePrice: Long = 0,
        var seatCount: Int = 45) {

    var bus: Bus = Bus(name = UUID.randomUUID().toString(),
            schedule = this,
            seatCount = seatCount)

    fun createReservation(user: User, seatNos: List<Int>): Reservation {
        val reservation = Reservation(schedule = this, user = user, totalPrice = salePrice * seatNos.size)

        seatNos.map { seatNo ->
            bus.doReservation(seatNo, reservation)
            ReservationSeat(bus = bus, seatNo = seatNo).addToReservation(reservation)
        }

        return reservation
    }

}