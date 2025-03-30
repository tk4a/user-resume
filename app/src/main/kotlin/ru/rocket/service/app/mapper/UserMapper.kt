package ru.rocket.service.app.mapper

import ru.rocket.service.app.entity.RocketUser
import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeResponseDto
import java.util.UUID

fun RocketUser.toDto() =
    UserResumeResponseDto(
        this.firstName,
        this.lastName,
        this.email
    )

fun UserResumeCreateRequestDto.toEntity() =
    RocketUser(
        UUID.randomUUID().toString(),
        this.email,
        this.password,
        this.firstName,
        this.lastName,
        this.position
    )