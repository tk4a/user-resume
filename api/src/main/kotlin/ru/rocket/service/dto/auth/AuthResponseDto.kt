package ru.rocket.service.dto.auth

data class AuthResponseDto(
    val email: String,
    val password: String
) {
    constructor() : this("", "")
}