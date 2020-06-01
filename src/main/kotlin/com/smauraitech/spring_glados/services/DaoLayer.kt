package com.smauraitech.spring_glados.services

import com.smauraitech.spring_glados.models.Device
import com.smauraitech.spring_glados.models.Instruction
import com.smauraitech.spring_glados.models.Room
import org.springframework.data.mongodb.repository.MongoRepository

interface RoomDAO : MongoRepository<Room, String> {
    fun findByName(name: String): List<Room>
}

interface DeviceDAO : MongoRepository<Device, String> {
    fun findByRoomId(roomId: Int): List<Device>
}

interface InstructionDAO : MongoRepository<Instruction, String>
