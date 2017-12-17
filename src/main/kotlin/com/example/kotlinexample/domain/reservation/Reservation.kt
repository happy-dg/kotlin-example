package com.example.kotlinexample.domain.reservation

import com.example.kotlinexample.domain.schedule.Schedule
import com.example.kotlinexample.domain.user.User
import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "reservations")
@Entity
data class Reservation(
        @Id @GeneratedValue
        var id: Long? = -1,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        var schedule: Schedule,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        var user: User,
        var totalPrice: Long = 0,
        @CollectionTable(name = "reservation_seats")
        @ElementCollection(fetch = FetchType.EAGER)
        var seats: MutableSet<ReservationSeat> = mutableSetOf()
) {

    fun addSeat(seat: ReservationSeat) {
        seats.add(seat)
    }
}

