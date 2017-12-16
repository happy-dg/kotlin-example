package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation

data class BusSeat(
        var seatNo: Int,
        var bus: Bus,
        var reservation: Reservation? = null) {

    init {
        bus.addSeat(this)
    }

    fun doReservation(reservation: Reservation) {
        this.reservation = reservation
    }
}