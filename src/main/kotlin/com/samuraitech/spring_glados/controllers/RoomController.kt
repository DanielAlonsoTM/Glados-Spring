package com.samuraitech.spring_glados.controllers

import com.samuraitech.spring_glados.models.Device
import com.samuraitech.spring_glados.models.Room
import com.samuraitech.spring_glados.services.RoomService
import org.bson.types.ObjectId
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.Optional
import javax.validation.Valid

@RestController
@RequestMapping("/api/rooms")
class RoomController(private val roomService: RoomService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Room> = roomService.getAll(pageable).content

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Room> = roomService.getById(id)

    @GetMapping("/byRoomId/{roomId}")
    fun getByRoomId(@PathVariable roomId: Int): List<Room> = roomService.roomDAO.findByIdRoom(roomId)

    @PostMapping("/insert")
    fun insert(@Valid @RequestBody room: Room): Room {
        room.idDocument = ObjectId.get().toHexString()
        return roomService.insert(room)
    }

    @PutMapping("/update")
    fun update(@RequestBody room: Room): Room = roomService.update(room)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Room> = roomService.deleteById(id)
}
