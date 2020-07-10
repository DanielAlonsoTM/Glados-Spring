package com.samuraitech.spring_glados.utils

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional

interface BasicCrud<in K, T> {
    fun getAll(pageable: Pageable): Page<T>
    fun getById(id: K): Optional<T>
    fun insert(obj: T): T
    fun update(obj: T): T
    fun deleteById(id: K): Optional<T>
}
