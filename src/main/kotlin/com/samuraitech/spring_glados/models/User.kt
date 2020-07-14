package com.samuraitech.spring_glados.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        @Id
        var idDocument: String,
        val idUser: String,
        val name: String,
        val email: String
)
