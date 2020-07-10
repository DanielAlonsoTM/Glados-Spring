package com.samuraitech.spring_glados.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document (collection = "rooms")
data class Room(
        @Id
        var idDocument: String,
        val idRoom: Int,
        val name: String,
        val lastActivity: String,
        val temperatureCelsius: String,
        val kilowattsConsumed: String,
        val humidityPercent: String
)
