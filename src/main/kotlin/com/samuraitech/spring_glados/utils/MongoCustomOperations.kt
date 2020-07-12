package com.samuraitech.spring_glados.utils

import com.google.gson.Gson
import com.mongodb.MongoClient
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId

class MongoCustomOperations {
    private val db = MongoClient().getDatabase("glados_db")

    fun update(collectionName: String, obj: Any, filter: Bson) {
        val collection = db.getCollection(collectionName)

        val jsonObject = Gson().toJson(obj)

        val document = Document.parse(jsonObject)

        document["_id"] = ObjectId(document["idDocument"].toString())
        document.remove("idDocument")

        collection.replaceOne(filter, document)
    }
}