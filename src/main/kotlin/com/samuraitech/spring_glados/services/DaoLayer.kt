package com.samuraitech.spring_glados.services

import com.samuraitech.spring_glados.models.*
import org.springframework.data.mongodb.repository.MongoRepository

interface EventDAO : MongoRepository<Event, String>

interface InstructionDAO : MongoRepository<Instruction, String>

interface UserDAO : MongoRepository<User, String> {
//    fun existByIdUser(idUser:String): Boolean
}

interface RoomDAO : MongoRepository<Room, String> {
    fun findByIdRoom(roomId: Int): List<Room>
}

interface DeviceDAO : MongoRepository<Device, String> {
    fun findByRoomId(roomId: Int): List<Device>
}

interface RoutineDAO : MongoRepository<Routine, String> {
    fun findByIdRoutine(idRoutine: String): List<Routine>
}
