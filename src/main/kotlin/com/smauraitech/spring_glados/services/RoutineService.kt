package com.smauraitech.spring_glados.services

import com.smauraitech.spring_glados.models.Routine
import com.smauraitech.spring_glados.utils.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RoutineService(val routineDAO: RoutineDAO) : BasicCrud<String, Routine> {
    override fun getAll(pageable: Pageable): Page<Routine> = routineDAO.findAll(pageable)

    override fun getById(id: String): Optional<Routine> = routineDAO.findById(id)

    override fun insert(obj: Routine): Routine {
        TODO("Not yet implemented")
    }

    @Throws(Exception::class)
    override fun update(obj: Routine): Routine {
        return if (routineDAO.existsById(obj.idRoutine)) {
            routineDAO.save(obj.apply {
                this.idRoutine = routineDAO.findById(obj.idRoutine).get().idRoutine
            })
        } else {
            throw object : Exception("Routine not found") {}
        }
    }

    override fun deleteById(id: String): Optional<Routine> {
        return routineDAO.findById(id).apply {
            this.ifPresent {
                routineDAO.delete(it)
            }
        }
    }
}
