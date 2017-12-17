package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import com.example.kotlinexample.domain.user.User
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Transient

@Table(name = "schedules")
@Entity
data class Schedule(
        @Id @GeneratedValue
        var id: Long? = -1,
        var destination: String = "",
        var salePrice: Long = 0,
        @Transient
        var seatCount: Int = 45) {

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var bus = Bus(name = UUID.randomUUID().toString(), schedule = this, seatCount = seatCount)

    fun createReservation(user: User, seatNos: List<Int>): Reservation {
        val reservation = Reservation(schedule = this, user = user, totalPrice = calculate(seatNos.size))

        seatNos.map { seatNo ->
            bus.doReservation(seatNo, reservation)
            ReservationSeat(busId = bus.id!!, seatNo = seatNo).addToReservation(reservation)
        }

        val reservation = Reservation(schedule = this, user = user, totalPrice = salePrice * seatNos.size)
        bus.doReservation(seatNos, reservation)
        return reservation
    }

    private fun calculate(reservationCount: Int) = salePrice * reservationCount

}