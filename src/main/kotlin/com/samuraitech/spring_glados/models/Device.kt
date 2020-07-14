package com.samuraitech.spring_glados.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "devices")
data class Device(
        @Id
        var idDocument: String,
        val idDevice: String,
        val roomId: Int,
        val userId: String,
        val name: String,
        val type: String
)
