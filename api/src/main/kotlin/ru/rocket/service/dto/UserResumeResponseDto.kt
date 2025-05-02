package ru.rocket.service.dto

import ru.rocket.service.dto.link.LinkResponseDto

data class UserResumeResponseDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val position: String,
    val links: List<LinkResponseDto>
)
