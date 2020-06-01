package com.smauraitech.spring_glados.models

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "routines")
data class Routine(
        var idRoutine: String,
        val deviceId: String,
        val name: String,
        val action: Int,
        val precision: Float,
        val timeInit: String,
        val active: Int,
        val roomId: Int
)