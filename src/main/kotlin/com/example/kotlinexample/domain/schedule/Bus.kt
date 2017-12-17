package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import com.example.kotlinexample.domain.reservation.ReservationSeat

@Table(name = "buses")
@Entity
data class Bus(
        @Id @GeneratedValue
        var id: Long? = -1,
        var name: String,
        @OneToOne(fetch = FetchType.LAZY)
        var schedule: Schedule
) {
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var seats: MutableSet<BusSeat> = mutableSetOf()

    //secondary constructor를 보여주기위해서 억지로 만듬..
    constructor(name: String = "", schedule: Schedule, seatCount: Int = 45) : this(-1, name, schedule) {
        IntRange(1, seatCount).map { seatNo ->
            BusSeat(seatNo = seatNo, bus = this)
        }
    }

    fun addSeat(busSeat: BusSeat) {
        seats.add(busSeat)
    }

    fun doReservation(seatNos: List<Int>, reservation: Reservation) {
        seatNos.map { seatNo ->
            seats.find { it.seatNo == seatNo }
                    ?.doReservation(reservation) ?: throw RuntimeException("not found seat.")
            ReservationSeat(busId = this.id, seatNo = seatNo).addToReservation(reservation)
        }

    }

}