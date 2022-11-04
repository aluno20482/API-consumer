package com.example.api_consumer.retrofit.service


import com.example.api_consumer.Model.Note
import retrofit2.Call
import retrofit2.http.GET

//*
//
// specify the 'url' that we want to acess /

interface noteService {

    @GET("api/notes")
    fun List(): Call<List<Note>>

}