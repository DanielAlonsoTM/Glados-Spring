package com.smauraitech.spring_glados.services

import com.smauraitech.spring_glados.models.Device
import com.smauraitech.spring_glados.utils.BasicCrud
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
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Device> {
        TODO("Not yet implemented")
    }
}
