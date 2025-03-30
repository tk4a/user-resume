package ru.rocket.service.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ru.rocket.service.app.service.ResumeService
import ru.rocket.service.dto.UserResumeGetRequestDto
import ru.rocket.service.dto.UserResumeResponseDto

/**
 * Controller for get resume
 */
@RestController
class GetController(
    private val resumeService: ResumeService
) {
    @GetMapping("/{username}")
    fun getResume(@RequestHeader("Authorization") token: String, @PathVariable username: String): UserResumeResponseDto = resumeService.getResumeByUsername(UserResumeGetRequestDto(username, token))
}