package ru.rocket.service.app.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table(name = "link")
data class Link(
    @Id
    val linkId: String? = null,
    val type: String,
    val value: String,
    val userId: String
) {
    constructor() : this(UUID.randomUUID().toString(), "", "", "")
}