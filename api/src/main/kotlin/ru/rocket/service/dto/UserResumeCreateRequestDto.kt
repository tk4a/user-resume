package ru.rocket.service.dto

data class UserResumeCreateRequestDto(
    val email: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val position: String = "",
    var token: String = ""
)
