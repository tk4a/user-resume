package ru.rocket.service.app.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rocket.service.app.service.ResumeService
import ru.rocket.service.dto.UserResumeCreateRequestDto

/**
 * Controller for update resume
 */
@RestController
@CrossOrigin(origins = ["http://localhost:5173"])
class UpdateController(private val resumeService: ResumeService) {
    @PutMapping("/update/{email}")
    suspend fun update(
        @PathVariable email: String,
        @RequestBody request: UserResumeCreateRequestDto) = resumeService.update(request)
}