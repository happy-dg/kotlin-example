package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import com.example.kotlinexample.domain.user.User
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BusTest {

    @Test
    fun `버스 생성 - 좌석도 생성되어야 함`() {
        //given
        var schedule = Schedule()
        val name = "첫번째 버스"
        val seatCount = 45

        //when
        var sut = Bus(name = name, schedule = schedule, seatCount = seatCount)

        //then
        assertThat(sut.name).isEqualTo(name)
        assertThat(sut.seats.size).isEqualTo(seatCount)
        sut.seats.forEach { seat ->
            assertThat(seat.bus).isEqualTo(sut)
        }
    }

    @Test(expected = RuntimeException::class)
    fun `예약 예외 - 존재하지 않은 버스 좌석`() {

        val schedule = Schedule()
        val reservation = Reservation(schedule = schedule, user = User())

        var sut = Bus(schedule = schedule, seatCount = 10)

        sut.doReservation(11, reservation)

    }

    @Test
    fun `예약하기`() {

        val schedule = Schedule()
        val reservation = Reservation(schedule = schedule, user = User())

        var sut = Bus(schedule = schedule, seatCount = 1)

        sut.doReservation(1, reservation)

        assertThat(sut.seats.first().reservation).isEqualTo(reservation)
    }
}