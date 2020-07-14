package com.samuraitech.spring_glados.controllers

import com.samuraitech.spring_glados.models.Routine
import com.samuraitech.spring_glados.services.RoutineService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/routines")
class RoutineController(private val routineService: RoutineService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Routine> = routineService.getAll(pageable).content

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Routine> = routineService.getById(id)

    @GetMapping("/byRoutineId/{idRoutine}")
    fun getByRoutineId(@PathVariable idRoutine: String): List<Routine> = routineService.routineDAO.findByIdRoutine(idRoutine)

    @PutMapping("/update")
    fun update(@RequestBody routine: Routine): Routine = routineService.update(routine)

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: String): Optional<Routine> = routineService.deleteById(id)
}
