package ru.rocket.service.app.service

import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.rocket.service.app.mapper.toDto
import ru.rocket.service.app.mapper.toEntity
import ru.rocket.service.app.repository.ResumeRepository
import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

@Service
class ResumeServiceImpl(private val resumeRepository: ResumeRepository) : ResumeService {
    private val logger = KotlinLogging.logger {}

    override fun getResumeByUsername(request: UserResumeGetRequestDto): UserResumeResponseDto {
        logger.info { "Get request for find resume with username: ${request.email}" }
        val userResumeResponseDto =
            resumeRepository.findByEmail(request.email)?.run { this.toDto() } ?: UserResumeResponseDto(
                "",
                "",
                ""
            )
        logger.info { "User after search $userResumeResponseDto" }
        return userResumeResponseDto
    }

    override fun save(request: UserResumeCreateRequestDto): String {
        logger.info { "Get request for create new resume: $request" }
        val savedResume = resumeRepository.save(request.toEntity())
        logger.info { "Resume was create successfully, resumeId: ${savedResume.userId}" }
        return savedResume.userId
    }
}