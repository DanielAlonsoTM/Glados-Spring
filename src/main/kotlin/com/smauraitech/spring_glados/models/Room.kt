package com.smauraitech.spring_glados.models

import org.springframework.data.mongodb.core.mapping.Document

@Document (collection = "rooms")
data class Room(
        val idRoom: Int,
        val name: String,
        val lastActivity: String,
        val temperatureCelsius: String,
        val kilowattsConsumed: String,
        val humidityPercent: String
)
