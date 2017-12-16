package com.example.kotlinexample.service

import com.example.kotlinexample.domain.schedule.Schedule
import com.example.kotlinexample.domain.schedule.ScheduleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ScheduleService @Autowired constructor(private var repository: ScheduleRepository) {


    fun createSchedule(destination: String, salePrice: Long, seatCount: Int): Schedule {
        var schedule = Schedule(destination = destination, salePrice = salePrice, seatCount = seatCount)
        return repository.save(schedule)
    }
}