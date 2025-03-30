package ru.rocket.service.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rocket.service.app.entity.RocketUser

@Repository
interface ResumeRepository : JpaRepository<RocketUser, String> {
    fun findByEmail(email: String): RocketUser?
}