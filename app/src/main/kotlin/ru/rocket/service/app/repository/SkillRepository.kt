package ru.rocket.service.app.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import ru.rocket.service.app.entity.Skill

@Repository
interface SkillRepository : ReactiveCrudRepository<Skill, String> {
    fun findAllByUserId(userId: String): Flux<Skill>
}