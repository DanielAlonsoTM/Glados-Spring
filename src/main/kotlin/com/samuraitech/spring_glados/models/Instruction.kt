package com.samuraitech.spring_glados.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "instructions_capped")
data class Instruction(
        @Id
        var idDocument: String,
        val idInstruction: String,
        val date: String,
        val contentInstruction: ContentInstruction,
        val executed: Int
)

data class ContentInstruction(
        val deviceId: String,
        val roomId: Int,
        val action: String,
        val timeToExecute: Long
)
