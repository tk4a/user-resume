package ru.rocket.service.app.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "skill_name")
data class SkillName(
    @Id
    val skillNameId: String,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    val skill: Skill
) {
      constructor() : this(UUID.randomUUID().toString(), "", Skill())
}