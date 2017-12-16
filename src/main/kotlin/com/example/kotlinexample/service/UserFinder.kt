package com.example.kotlinexample.service

import com.example.kotlinexample.domain.user.User
import com.example.kotlinexample.domain.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class UserFinder @Autowired constructor(private val repository: UserRepository) {

    fun findById(userId: Long): User? = repository.findOne(userId)
}