package com.smauraitech.spring_glados.controllers

import com.smauraitech.spring_glados.models.Room
import com.smauraitech.spring_glados.services.RoomService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/rooms")
class RoomController(private val roomService: RoomService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Room> = roomService.getAll(pageable).content

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Room> = roomService.getById(id)

    @PostMapping
    fun insert(@RequestBody Room: Room): Room = roomService.insert(Room)

    @PutMapping
    fun update(@RequestBody Room: Room): Room = roomService.update(Room)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Room> = roomService.deleteById(id)
}
