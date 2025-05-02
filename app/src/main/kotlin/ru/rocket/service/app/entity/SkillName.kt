package ru.rocket.service.app.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "skill_name")
data class SkillName(
    @Id
    val skillNameId: String? = null,
    val name: String,
) {
      constructor() : this(UUID.randomUUID().toString(), "")
}