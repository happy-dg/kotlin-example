package com.example.kotlinexample.domain.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "users")
@Entity
data class User(
        @Id @GeneratedValue
        var id: Long? = null,
        var name: String = ""
) {
}