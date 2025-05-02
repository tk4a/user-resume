package ru.rocket.service.app.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import ru.rocket.service.app.entity.RocketUser

@Repository
interface ResumeRepository : ReactiveCrudRepository<RocketUser, String> {
    fun findByEmail(email: String): Mono<RocketUser?>
}