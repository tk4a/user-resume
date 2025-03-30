package ru.rocket.service.app.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "experience")
data class Experience(
    @Id
    val experienceId: String,
    val name: String,
    val description: String,
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: RocketUser
) {
    constructor() : this(UUID.randomUUID().toString(), "", "", RocketUser())
}