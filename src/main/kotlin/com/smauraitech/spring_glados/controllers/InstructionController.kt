package com.smauraitech.spring_glados.controllers

import com.smauraitech.spring_glados.models.Instruction
import com.smauraitech.spring_glados.services.InstructionService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/instructions")
class InstructionController(private val instructionService: InstructionService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Instruction> = instructionService.getAll(pageable).content

    @PostMapping("/insert")
    fun insert(@RequestBody instruction: Instruction): Instruction = instructionService.insert(instruction)
}
