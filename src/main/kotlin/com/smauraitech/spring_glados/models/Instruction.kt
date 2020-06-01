package com.smauraitech.spring_glados.models

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "instructions")
data class Instruction(
        val idInstruction: String,
        val date: String,
        val contentInstruction: ContentInstruction
)

data class ContentInstruction(
        val deviceId: String,
        val roomId: Int,
        val action: String,
        val timeToExecute: Long
)
