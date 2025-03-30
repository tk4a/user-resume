package ru.rocket.service.app.service

import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

interface ResumeService {
    fun getResumeByUsername(request: UserResumeGetRequestDto): UserResumeResponseDto
    fun save(request: UserResumeCreateRequestDto): String
}