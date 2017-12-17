package com.example.kotlinexample.domain.reservation

import javax.persistence.Embeddable

@Embeddable
data class ReservationSeat(var busId: Long, var seatNo: Int) {

    fun addToReservation(reservation: Reservation) {
        reservation.addSeat(this)
    }

}
