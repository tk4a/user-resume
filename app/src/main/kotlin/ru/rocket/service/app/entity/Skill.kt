package ru.rocket.service.app.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table(name = "skill")
data class Skill(
    @Id
    val skillId: String? = null,
    val name: String,
    val userId: String
) {
   constructor() : this(UUID.randomUUID().toString(), "", "")
}