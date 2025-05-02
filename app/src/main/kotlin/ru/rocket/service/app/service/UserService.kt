package ru.rocket.service.app.service

import ru.rocket.service.dto.auth.AuthResponseDto

interface UserService {
    suspend fun getUserByEmail(email: String): AuthResponseDto
}