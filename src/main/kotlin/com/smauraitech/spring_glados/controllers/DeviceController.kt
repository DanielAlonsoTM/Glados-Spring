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

    @PostMapping
    fun insert(@RequestBody Device: Device): Device = deviceService.insert(Device)

    @PutMapping
    fun update(@RequestBody Device: Device): Device = deviceService.update(Device)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Device> = deviceService.deleteById(id)
}
