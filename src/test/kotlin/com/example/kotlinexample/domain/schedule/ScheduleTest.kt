package com.example.kotlinexample.domain.schedule

import com.example.kotlinexample.domain.reservation.Reservation
import com.example.kotlinexample.domain.user.User
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ScheduleTest {

    @Test
    fun `일정 생성 - 버스와 버스의 좌석들도 생성되야 한다`() {

        assertCreateSchedule(destination = "목적지", salePrice = 30_000L, seatCount = 44)
        assertCreateSchedule(destination = "목적지1", salePrice = 30_000L, seatCount = 45)

    }

    private fun assertCreateSchedule(destination: String, salePrice: Long, seatCount: Int = 45) {
        //when
        var sut = Schedule(destination = destination, salePrice = salePrice, seatCount = seatCount)

        //then
        assertThat(sut.destination).isEqualTo(destination)
        assertThat(sut.salePrice).isEqualTo(salePrice)
        assertThat(sut.bus).isNotNull()
        assertThat(sut.bus.seats.size).isEqualTo(seatCount)
    }

    @Test
    fun `예약 - 버스좌석`() {

        var givenUser = User()
        val givenSeatNos = listOf(3, 4)

        var sut = Schedule(salePrice = 10_000)

        var reservation:Reservation = sut.createReservation(user = givenUser, seatNos = givenSeatNos)

        assertThat(reservation.schedule).isEqualTo(sut)
        assertThat(reservation.user).isEqualTo(givenUser)
        assertThat(reservation.totalPrice).isEqualTo(sut.salePrice * givenSeatNos.size)
        assertThat(reservation.seats.size).isEqualTo(givenSeatNos.size)
        reservation.seats.forEach {
            assertThat(it.bus).isEqualTo(sut.bus)
            assertThat(givenSeatNos).contains(it.seatNo)
        }
    }
}