package ru.rocket.service.app.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.rocket.service.app.service.ResumeService
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

/**
 * Controller for get resume
 */
@RestController
@CrossOrigin(origins = ["http://localhost:5173"])
class GetController(
    private val resumeService: ResumeService
) {
    @GetMapping("/{username}")
    suspend fun getResume(@PathVariable username: String): UserResumeResponseDto = resumeService.getResumeByEmail(UserResumeGetRequestDto(username))
}