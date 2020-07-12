package com.samuraitech.spring_glados.services

import com.mongodb.client.model.Filters
import com.samuraitech.spring_glados.models.Device
import com.samuraitech.spring_glados.utils.BasicCrud
import com.samuraitech.spring_glados.utils.MongoCustomOperations
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class DeviceService(val deviceDAO: DeviceDAO) : BasicCrud<String, Device> {
    override fun getAll(pageable: Pageable): Page<Device> = deviceDAO.findAll(pageable)

    override fun getById(id: String): Optional<Device> = deviceDAO.findById(id)

    override fun insert(obj: Device): Device = deviceDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Device): Device {
        return if (deviceDAO.existsById(obj.idDocument)) {
//            deviceDAO.save(obj)
            val filter: Bson = Filters.eq("_id", ObjectId(obj.idDocument))
            MongoCustomOperations().update("devices", obj, filter)

            obj
        } else {
            throw object : Exception("Device not found"){}
        }
    }

    override fun deleteById(id: String): Optional<Device> {
        TODO("Not yet implemented")
    }
}
