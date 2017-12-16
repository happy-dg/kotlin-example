package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation

data class Bus(
        var name: String,
        var schedule: Schedule) {

    var seats: MutableSet<BusSeat> = mutableSetOf()

    //secondary constructor를 보여주기위해서 억지로 만듬..
    constructor(name: String = "", schedule: Schedule, seatCount: Int = 45) : this(name, schedule) {
        IntRange(1, seatCount).map { seatNo ->
            BusSeat(seatNo = seatNo, bus = this)
        }
    }

    fun addSeat(busSeat: BusSeat) {
        seats.add(busSeat)
    }

    fun doReservation(seatNo: Int, reservation: Reservation) {
        seats.find { it.seatNo == seatNo }
                ?.doReservation(reservation) ?: throw RuntimeException("not found seat.")
    }

}