package com.majimo.dev.starwarsinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.majimo.dev.starwarsinfo.repository.PlanetRepository
import com.majimo.dev.starwarsinfo.service.PlanetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PlanetService::class.java)

        service.retrieveRepositories(1)
            .enqueue(object : Callback<PlanetRepository> {
                override fun onFailure(call: Call<PlanetRepository>, t: Throwable) {
                    Log.wtf("XXX", t.message)
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<PlanetRepository>,
                    response: Response<PlanetRepository>
                ) {
                    Log.wtf("XXX", "Planete : " + response.body())
                }

            })
    }
}
