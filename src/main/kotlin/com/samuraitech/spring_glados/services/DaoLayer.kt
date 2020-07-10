package com.samuraitech.spring_glados.services

import com.samuraitech.spring_glados.models.Device
import com.samuraitech.spring_glados.models.Instruction
import com.samuraitech.spring_glados.models.Room
import com.samuraitech.spring_glados.models.Routine
import org.springframework.data.mongodb.repository.MongoRepository

interface RoomDAO : MongoRepository<Room, String> {
    fun findByIdRoom(roomId: Int): List<Room>
}

interface DeviceDAO : MongoRepository<Device, String> {
    fun findByRoomId(roomId: Int): List<Device>
}

interface InstructionDAO : MongoRepository<Instruction, String>

interface RoutineDAO : MongoRepository<Routine, String> {
    fun findByIdRoutine(idRoutine: String): List<Routine>
}