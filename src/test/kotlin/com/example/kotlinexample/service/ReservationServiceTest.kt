package com.example.kotlinexample.service

import com.example.kotlinexample.domain.reservation.ReservationRepository
import com.example.kotlinexample.domain.schedule.Schedule
import com.example.kotlinexample.domain.user.User
import com.example.kotlinexample.service.schedule.ScheduleFinder
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class ReservationServiceTest {

    lateinit var sut: ReservationService
    lateinit var mockScheduleFinder: ScheduleFinder
    lateinit var mockUserFinder: UserFinder
    lateinit var mockRepository: ReservationRepository

    @Before
    fun setUp() {

        mockScheduleFinder = mock()
        mockUserFinder = mock()
        mockRepository = mock()

        sut = ReservationService(mockScheduleFinder, mockUserFinder, mockRepository)

    }

    @Test(expected = RuntimeException::class)
    fun `예외 - 일정이 존재하지 않는다`() {

        sut.doReservation(1L, listOf(1, 2), 5)

        verify(mockUserFinder, never()).findById(any())
    }

    @Test(expected = RuntimeException::class)
    fun `예외 - 예약자가 존재하지 않는다`() {

        given(mockScheduleFinder.findById(any()))
                .willReturn(Schedule())

        sut.doReservation(1L, listOf(1, 2), 5)

    }

    @Test
    fun `예약 성공`() {
        val scheduleId = 1L
        val userId: Long = 5

        given(mockScheduleFinder.findById(eq(scheduleId)))
                .willReturn(Schedule())
        given(mockUserFinder.findById(eq(userId)))
                .willReturn(User())


        sut.doReservation(scheduleId, listOf(1, 2), userId)

//        verify(mockRepository).save()
    }
}