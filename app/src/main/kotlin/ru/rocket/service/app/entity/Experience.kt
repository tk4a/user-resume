package ru.rocket.service.app.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "experience")
data class Experience(
    @Id
    val experienceId: String? = null,
    val name: String,
    val description: String,
    val userId: String
) {
    constructor() : this(UUID.randomUUID().toString(), "", "", "")
}