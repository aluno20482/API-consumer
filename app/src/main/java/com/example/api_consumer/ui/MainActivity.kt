package com.example.api_consumer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.api_consumer.Model.Note
import com.example.api_consumer.R
import com.example.api_consumer.retrofit.RtrofitInitializer
import com.example.api_consumer.ui.adapter.nodeListAdapter
import org.w3c.dom.NodeList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ask retrofit to read the API data(forçar a leitura)
        val call = RtrofitInitializer().noteSerivce().List()

        //use data readed  (avaliar os dados)
        call.enqueue(
            object : Callback<List<Note>?> {
                override fun onResponse(
                    call: Call<List<Note>?>?, response: Response<List<Note>?>
                ) {
                    response?.body()?.let {
                        val notes: List<Note> = it
                        //takes the data readed from API
                        configureList(notes)
                    }
                }

                override fun onFailure(
                    call: Call<List<Note>?>?, t: Throwable?
                ) {
                    t?.message?.let { Log.e("Something went wrong", it) }
                }
            }
        )
    }

    /**
     * configure each 'fragment to present data
     */
    fun configureList(notes: List<Note>) {

        val reciclerView = findViewById<RecyclerView>(R.id.nodeListRecicleView)


        reciclerView.adapter= nodeListAdapter(notes,this)

        var layoutManager= StaggeredGridLayoutManager(
            2,StaggeredGridLayoutManager.VERTICAL
        )

        reciclerView.layoutManager=layoutManager
    }


}