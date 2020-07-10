package com.samuraitech.spring_glados.services

import com.samuraitech.spring_glados.models.Room
import com.samuraitech.spring_glados.utils.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RoomService(val roomDAO: RoomDAO) : BasicCrud<String, Room> {
    override fun getAll(pageable: Pageable): Page<Room> = roomDAO.findAll(pageable)

    override fun getById(id: String): Optional<Room> = roomDAO.findById(id)

    override fun insert(obj: Room): Room = roomDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Room): Room {
        return if (roomDAO.existsById(obj.idDocument)) {
            roomDAO.save(obj)
        } else {
            throw object : Exception("Room not found") {}
        }
    }

    override fun deleteById(id: String): Optional<Room> {
        TODO("Not yet implemented")
    }
}
