package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "bus_seats")
@Entity
data class BusSeat(
        @Id @GeneratedValue
        var id: Long? = -1,
        var seatNo: Int,
        @ManyToOne(fetch = FetchType.LAZY)
        var bus: Bus,
        @ManyToOne(fetch = FetchType.LAZY)
        var reservation: Reservation? = null) {

    init {
        bus.addSeat(this)
    }

    fun doReservation(reservation: Reservation) {
        this.reservation = reservation
    }
}

