package ru.rocket.service.app.service

import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

interface ResumeService {
    suspend fun getResumeByEmail(request: UserResumeGetRequestDto): UserResumeResponseDto
    suspend fun save(request: UserResumeCreateRequestDto): String
    suspend fun update(request: UserResumeCreateRequestDto): String
}