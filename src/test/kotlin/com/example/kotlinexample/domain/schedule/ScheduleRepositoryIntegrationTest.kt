package com.example.kotlinexample.domain.schedule

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@DataJpaTest
class ScheduleRepositoryIntegrationTest {

    @Autowired
    lateinit var repository: ScheduleRepository

    @Test
    fun `일정 생성`() {

        var saved = repository.save(
                Schedule(destination = "목적지1", salePrice = 10_000, seatCount = 45))

        assertThat(saved.id).isGreaterThan(0)
        assertThat(saved.bus.id).isGreaterThan(0)
        assertThat(saved.bus.seats.size).isEqualTo(45)
        saved.bus.seats.forEach { seat ->
            assertThat(seat.id).isGreaterThan(0)
            assertThat(seat.bus).isEqualTo(saved.bus)
            assertThat(seat.seatNo).isLessThan(46)
        }
    }
}