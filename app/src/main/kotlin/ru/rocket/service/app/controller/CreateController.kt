package ru.rocket.service.app.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import ru.rocket.service.app.service.ResumeService
import ru.rocket.service.dto.UserResumeCreateRequestDto

/**
 * Controller for create resume
 */
@RestController
class CreateController(private val resumeService: ResumeService) {
    @PostMapping("/create")
    fun createResume(@RequestHeader("Authorization") token: String, @RequestBody request: UserResumeCreateRequestDto): String {
        request.token = token
        return resumeService.save(request)
    }
}