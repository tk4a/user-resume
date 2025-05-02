package ru.rocket.service.app.mapper

import ru.rocket.service.app.entity.Link
import ru.rocket.service.app.entity.RocketUser
import ru.rocket.service.dto.link.LinkRequestDto
import ru.rocket.service.dto.link.LinkResponseDto
import ru.rocket.service.dto.UserResumeCreateRequestDto
import ru.rocket.service.dto.UserResumeResponseDto
import ru.rocket.service.dto.auth.AuthResponseDto

fun RocketUser.toDto() =
    UserResumeResponseDto(
        this.firstName,
        this.lastName,
        this.email,
        this.position,
        emptyList()
    )

fun UserResumeCreateRequestDto.toEntity() =
    RocketUser(
        null,
        this.email,
        this.password,
        this.firstName,
        this.lastName,
        this.position
    )

fun LinkRequestDto.toEntity(userId: String) =
    Link(
        null,
        this.type,
        this.value,
        userId
    )

fun Link.toDto() =
    LinkResponseDto(
        this.type,
        this.value
    )

fun RocketUser.toAuthResponse() =
    AuthResponseDto(
        this.email,
        this.password
    )