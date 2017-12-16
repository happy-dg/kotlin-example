package com.example.kotlinexample.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

interface UserRepository : JpaRepository<User, Long>, QueryDslPredicateExecutor<User>