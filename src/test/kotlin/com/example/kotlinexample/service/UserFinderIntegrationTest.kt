package com.example.kotlinexample.service

import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional


@Transactional
@RunWith(SpringRunner::class)
@SpringBootTest
class UserFinderIntegrationTest {
    @Autowired
    lateinit var sut: UserFinder

    @Test
    fun `verify findById`() {

        val user = sut.findById(1L)

        user ?: fail("User must not be null")
    }
}