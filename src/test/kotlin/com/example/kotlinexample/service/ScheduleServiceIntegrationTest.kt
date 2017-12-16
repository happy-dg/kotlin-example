package com.example.kotlinexample.service

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@Transactional
@RunWith(SpringRunner::class)
@SpringBootTest
class ScheduleServiceIntegrationTest {

    @Autowired
    lateinit var service: ScheduleService

    @Test
    fun `일정 등록`() {

        var schedule = service.createSchedule("한라산", 20_000, 44)

        assertThat(schedule.id).isGreaterThan(0)
        assertThat(schedule.bus.id).isGreaterThan(0)
        assertThat(schedule.bus.seats.size).isEqualTo(44)
        schedule.bus.seats.forEach { seat ->
            assertThat(seat.id).isGreaterThan(0)
            assertThat(seat.bus).isEqualTo(schedule.bus)
            assertThat(seat.seatNo).isLessThan(45)
        }

    }
}