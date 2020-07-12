package com.samuraitech.spring_glados.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("events")
data class Event(
        @Id
        val idDocument: String,
        val idEvent: String,
        val deviceId: String,
        val userId: String,
        val type: String,
        val title: String,
        val description: String,
        val date: String
)