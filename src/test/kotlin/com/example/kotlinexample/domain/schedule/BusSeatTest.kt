package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import com.example.kotlinexample.domain.user.User
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BusSeatTest {

    @Test
    fun `버스좌석 예약 하기`() {
        val reservation = Reservation(schedule = Schedule(), user = User())

        var sut = BusSeat( seatNo = 1, bus = Bus(schedule = Schedule()))

        sut.doReservation(reservation)

        assertThat(sut.reservation).isEqualTo(reservation)
    }
}