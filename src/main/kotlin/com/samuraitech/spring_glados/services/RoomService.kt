package com.samuraitech.spring_glados.services

import com.mongodb.client.model.Filters
import com.samuraitech.spring_glados.models.Room
import com.samuraitech.spring_glados.utils.BasicCrud
import com.samuraitech.spring_glados.utils.MongoCustomOperations
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RoomService(val roomDAO: RoomDAO) : BasicCrud<String, Room> {
    override fun getAll(pageable: Pageable): Page<Room> = roomDAO.findAll(pageable)

    override fun getById(id: String): Optional<Room> = roomDAO.findById(id)

    override fun insert(obj: Room): Room {
        obj.idDocument = ObjectId.get().toHexString()
        return roomDAO.insert(obj)
    }

    @Throws(Exception::class)
    override fun update(obj: Room): Room {
        return if (roomDAO.existsById(obj.idDocument)) {
//            roomDAO.save(obj)
            val filter: Bson = Filters.eq("_id", ObjectId(obj.idDocument))
            MongoCustomOperations().update("rooms", obj, filter)

            obj
        } else {
            throw object : Exception("Room not found") {}
        }
    }

    override fun deleteById(id: String): Optional<Room> {
        return roomDAO.findById(id).apply {
            this.ifPresent { roomDAO.delete(it) }
        }
    }
}
