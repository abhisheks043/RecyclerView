package com.example.abhishek.app_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import io.reactivex.Observable
import java.util.ArrayList
import java.util.Arrays
import java.util.concurrent.Callable

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: Cntrs_Adapter? = null
    private var data: ArrayList<Countries>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById<View>(R.id.rView) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        loadJSON()


    }


    private fun loadJSON() {

        val retrofit = Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create<Api>(Api::class.java)

        val call = api.json


        //expensive method
        call.enqueue(object : Callback<JSONResponse> {
            override fun onResponse(call: Call<JSONResponse>, response: Response<JSONResponse>) {
                val jsonResponse = response.body()

                data = ArrayList(Arrays.asList(*jsonResponse!!.countries))
                Observable.just(data!!)

                //                Observable.fromCallable(new Callable<ArrayList<Countries>>() {
                //
                //                    @Override
                //                    public ArrayList<Countries> call() throws Exception {
                //                        return new ArrayList<>(Arrays.asList(jsonResponse.getCountries()));
                //                    }
                //                })
                //                        .subscribeOn(Schedulers.io())
                //                        .observeOn(AndroidSchedulers.mainThread())
                //                        .subscribe(data);


                adapter = Cntrs_Adapter(data!!, applicationContext)
                recyclerView!!.adapter = adapter
            }

            override fun onFailure(call: Call<JSONResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }


}
