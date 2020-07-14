package com.samuraitech.spring_glados.controllers

import com.samuraitech.spring_glados.models.User
import com.samuraitech.spring_glados.services.UserService
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping("/insert")
    fun insert(@RequestBody user: User): User = userService.insert(user)
}

