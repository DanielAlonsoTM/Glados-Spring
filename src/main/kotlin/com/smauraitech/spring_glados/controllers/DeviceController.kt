package com.smauraitech.spring_glados.controllers

import com.smauraitech.spring_glados.models.Device
import com.smauraitech.spring_glados.services.DeviceService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/devices")
class DeviceController(private val deviceService: DeviceService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Device> = deviceService.getAll(pageable).content

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Device> = deviceService.getById(id)

    @GetMapping("/byRoomId/{roomId}")
    fun getByRoomId(@PathVariable roomId: Int): List<Device> = deviceService.deviceDAO.findByRoomId(roomId)

    @PostMapping
    fun insert(@RequestBody device: Device): Device = deviceService.insert(device)

    @PutMapping
    fun update(@RequestBody device: Device): Device = deviceService.update(device)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Device> = deviceService.deleteById(id)
}
