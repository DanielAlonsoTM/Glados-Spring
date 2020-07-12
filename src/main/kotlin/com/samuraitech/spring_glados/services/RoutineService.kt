package com.samuraitech.spring_glados.services

import com.mongodb.client.model.Filters
import com.samuraitech.spring_glados.models.Routine
import com.samuraitech.spring_glados.utils.BasicCrud
import com.samuraitech.spring_glados.utils.MongoCustomOperations
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoutineService(val routineDAO: RoutineDAO) : BasicCrud<String, Routine> {
    override fun getAll(pageable: Pageable): Page<Routine> = routineDAO.findAll(pageable)

    override fun getById(id: String): Optional<Routine> = routineDAO.findById(id)

    override fun insert(obj: Routine): Routine {
        TODO("Not yet implemented")
    }

    @Throws(Exception::class)
    override fun update(obj: Routine): Routine {
        return if (routineDAO.existsById(obj.idDocument)) {
//            routineDAO.save(obj)
            val filter: Bson = Filters.eq("_id", ObjectId(obj.idDocument))
            MongoCustomOperations().update("routines", obj, filter)
            obj
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
