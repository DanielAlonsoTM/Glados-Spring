package com.smauraitech.spring_glados.models

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "devices")
data class Device(
        val idDevice: String,
        val roomId: Int,
        val name: String,
        val type: String
)
