package ru.rocket.service.dto

import ru.rocket.service.dto.link.LinkRequestDto

data class UserResumeCreateRequestDto(
    val email: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val position: String = "",
    var token: String = "",
    val links: List<LinkRequestDto> = emptyList()
)
