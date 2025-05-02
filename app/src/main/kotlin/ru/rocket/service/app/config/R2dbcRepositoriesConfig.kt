package ru.rocket.service.app.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories(basePackages = ["ru.rocket.service.app.repository"])
class R2dbcRepositoriesConfig