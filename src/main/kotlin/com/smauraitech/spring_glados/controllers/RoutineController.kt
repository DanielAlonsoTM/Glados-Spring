package com.smauraitech.spring_glados.controllers

import com.smauraitech.spring_glados.models.Routine
import com.smauraitech.spring_glados.services.RoutineService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/routines")
class RoutineController (private val routineService: RoutineService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Routine> = routineService.getAll(pageable).content

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Routine> = routineService.getById(id)

    @PutMapping("/update")
    fun update(@RequestBody routine: Routine): Routine = routineService.update(routine)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Routine> = routineService.deleteById(id)
}
