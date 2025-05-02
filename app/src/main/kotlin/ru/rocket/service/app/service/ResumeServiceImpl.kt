package ru.rocket.service.app.service

import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactor.awaitSingle
import mu.KotlinLogging
import org.springframework.stereotype.Service
import ru.rocket.service.app.mapper.toDto
import ru.rocket.service.app.mapper.toEntity
import ru.rocket.service.app.repository.LinkRepository
import ru.rocket.service.app.repository.ResumeRepository
import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

@Service
class ResumeServiceImpl(
    val resumeRepository: ResumeRepository,
    val linkRepository: LinkRepository
    ) : ResumeService {
    private val logger = KotlinLogging.logger {}

    override suspend fun getResumeByEmail(request: UserResumeGetRequestDto): UserResumeResponseDto {
        logger.info { "Get request for find resume with username: ${request.email}" }
        val user = resumeRepository.findByEmail(request.email).awaitFirstOrNull()
        return user?.run { this.toDto() }
            ?: UserResumeResponseDto(
                "",
                "",
                "",
                "",
                emptyList()
            )
    }

    override suspend fun save(request: UserResumeCreateRequestDto): String {
        logger.info { "Get request for create new resume: $request" }
        val saved = resumeRepository.save(request.toEntity()).awaitSingle()
        logger.info { "Resume was create successfully, resumeId: ${saved.userId}" }
        return saved?.userId ?: ""
    }

    override suspend fun update(request: UserResumeCreateRequestDto): String {
        logger.info { "Get request for update resume: $request" }
        val user = resumeRepository.findByEmail(request.email).awaitFirstOrNull()
        val userId = user?.run { this.userId } ?: ""
        user?.let {
            linkRepository.deleteAllByUserId(it.userId ?: "").awaitFirstOrNull()
            val newLinks = request.links.map { it.toEntity(userId) }
            linkRepository.saveAll(newLinks).collectList().awaitFirstOrNull()
        }
        return "OK"
    }
}