package com.samuraitech.spring_glados.services

import com.samuraitech.spring_glados.models.Event
import com.samuraitech.spring_glados.utils.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class EventService(val eventDAO: EventDAO):BasicCrud<String, Event> {
    override fun getAll(pageable: Pageable): Page<Event>  = eventDAO.findAll(pageable)

    override fun getById(id: String): Optional<Event> = eventDAO.findById(id)

    override fun insert(obj: Event): Event = eventDAO.insert(obj)

    override fun update(obj: Event): Event {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<Event> {
        TODO("Not yet implemented")
    }

}
