package com.samuraitech.spring_glados.controllers

import com.samuraitech.spring_glados.models.Event
import com.samuraitech.spring_glados.services.EventService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/events")
class EventController(private val eventService: EventService) {
    @GetMapping("/getall")
    fun getAll(pageable: Pageable): MutableList<Event> = eventService.getAll(pageable).content
}
