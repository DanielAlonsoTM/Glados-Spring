package com.samuraitech.spring_glados.utils

import com.google.gson.Gson
import com.mongodb.MongoClient
import com.mongodb.MongoException
import com.mongodb.client.FindIterable
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId

class MongoCustomOperations {
    private val client = MongoClient()
    private val db = client.getDatabase("glados_db")

    fun update(collectionName: String, obj: Any, filter: Bson) {
        try {
            val collection = db.getCollection(collectionName)

            val jsonObject = Gson().toJson(obj)

            val document = Document.parse(jsonObject)

            document["_id"] = ObjectId(document["idDocument"].toString())
            document.remove("idDocument")

            collection.replaceOne(filter, document)

        } catch (e: MongoException) {
            e.printStackTrace()
        } finally {
            client.close()
        }
    }

    fun existUserById(idUser: String): Boolean {
        return try {
            val iterable: FindIterable<Document> = db.getCollection("users").find(Document("idUser", idUser))
            return iterable.first() != null
        } catch (e: MongoException) {
            e.printStackTrace()
            false
        } finally {
            client.close()
        }
    }
}