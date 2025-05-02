package ru.rocket.service.app.service

import kotlinx.coroutines.reactive.awaitFirst
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.rocket.service.app.mapper.toAuthResponse
import ru.rocket.service.app.repository.ResumeRepository
import ru.rocket.service.dto.auth.AuthResponseDto

@Service
class UserServiceImpl(private val resumeRepository: ResumeRepository) : UserService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override suspend fun getUserByEmail(email: String): AuthResponseDto {
        logger.info("Get request for find user with email: $email")
        return resumeRepository.findByEmail(email).map { it?.toAuthResponse() ?: AuthResponseDto() }.awaitFirst()
    }
}