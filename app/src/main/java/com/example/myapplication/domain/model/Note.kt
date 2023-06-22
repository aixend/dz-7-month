package com.example.myapplication.domain.model

import java.io.Serializable

class Note (
    val id: Int = DEFAULT_ID,
    var title: String,
    var description: String
) : Serializable




{
    companion object{
        const val DEFAULT_ID = 0
    }
}