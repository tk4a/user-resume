package ru.rocket.service.app.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {
    @Bean
    fun dataSource(): DataSource {
        val dataSource = HikariDataSource()
        dataSource.jdbcUrl = "jdbc:postgresql://localhost:5432/rocketservice"
        dataSource.username = "postgres"
        dataSource.password = "rocketpass"
        dataSource.driverClassName = "org.postgresql.Driver"
        return dataSource
    }
}