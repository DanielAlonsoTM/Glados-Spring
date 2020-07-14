package com.samuraitech.spring_glados.services

import com.samuraitech.spring_glados.models.User
import com.samuraitech.spring_glados.utils.BasicCrud
import com.samuraitech.spring_glados.utils.MongoCustomOperations
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userDAO: UserDAO) : BasicCrud<String, User> {
    override fun getAll(pageable: Pageable): Page<User> {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun insert(obj: User): User {
        val existDocument = MongoCustomOperations().existUserById(obj.idUser)

        return if (!existDocument) {
            obj.idDocument = ObjectId.get().toHexString()
            userDAO.insert(obj)
        } else {
            throw object : Exception("User already exist") {}
        }
    }

    override fun update(obj: User): User {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Optional<User> {
        TODO("Not yet implemented")
    }
}
