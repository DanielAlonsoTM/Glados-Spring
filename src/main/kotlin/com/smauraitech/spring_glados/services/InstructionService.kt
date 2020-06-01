package com.smauraitech.spring_glados.services

import com.smauraitech.spring_glados.models.Instruction
import com.smauraitech.spring_glados.utils.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.Optional

@Service
class InstructionService (val instructionDAO: InstructionDAO) : BasicCrud<String, Instruction> {
    override fun getAll(pageable: Pageable): Page<Instruction> = instructionDAO.findAll(pageable)

    override fun getById(id: String): Optional<Instruction> = instructionDAO.findById(id)

    override fun insert(obj: Instruction): Instruction = instructionDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Instruction): Instruction {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Instruction> {
        TODO("Not yet implemented")
    }
}
