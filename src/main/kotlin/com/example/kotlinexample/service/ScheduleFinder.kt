package com.example.kotlinexample.service

import com.example.kotlinexample.domain.schedule.Schedule
import com.example.kotlinexample.domain.schedule.ScheduleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class ScheduleFinder @Autowired constructor(private val repository: ScheduleRepository) {

    fun findById(scheduleId: Long): Schedule? {
        return repository.findOne(scheduleId)
    }
}