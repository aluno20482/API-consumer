package com.example.api_consumer.retrofit

import com.example.api_consumer.retrofit.service.noteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//*
// acess to API
// we must specify the URL/



class RtrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://adamastor.ipt.pt/DAM-API/api/notes") //"http://10.0.2.2/" ---> referent to an API that is on localhost
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun noteSerivce() =  retrofit.create(noteService::class.java)


}
