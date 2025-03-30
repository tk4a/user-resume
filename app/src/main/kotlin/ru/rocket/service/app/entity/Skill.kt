package ru.rocket.service.app.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "skill")
data class Skill(
    @Id
    val skillId: String,
    val groupName: String,
    @OneToMany(mappedBy = "skill", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val values: List<SkillName> = mutableListOf(),
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: RocketUser
) {
   constructor() : this(UUID.randomUUID().toString(), "", mutableListOf(), RocketUser())
}