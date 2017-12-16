package com.example.kotlinexample.domain.reservation

import com.example.kotlinexample.domain.schedule.Bus

data class ReservationSeat(var bus: Bus, var seatNo: Int) {

    fun addToReservation(reservation: Reservation) {
        reservation.addSeat(this)
    }

}