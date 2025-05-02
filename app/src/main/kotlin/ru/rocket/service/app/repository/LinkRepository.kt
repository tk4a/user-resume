package ru.rocket.service.app.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.rocket.service.app.entity.Link

@Repository
interface LinkRepository : ReactiveCrudRepository<Link, String> {
    fun findAllByUserId(userId: String): Flux<Link>
    fun deleteAllByUserId(userId: String): Mono<Void>
}