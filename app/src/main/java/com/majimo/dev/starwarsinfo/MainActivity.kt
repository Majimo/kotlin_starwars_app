package com.majimo.dev.starwarsinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.majimo.dev.starwarsinfo.repository.PlanetRepository
import com.majimo.dev.starwarsinfo.service.PlanetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var planet: PlanetRepository
    private lateinit var planetName: TextView
    private lateinit var planetClimate: TextView
    private lateinit var planetTerrain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        planetName = findViewById(R.id.tv_planet_name)
        planetClimate = findViewById(R.id.tv_planet_climate2)
        planetTerrain = findViewById(R.id.tv_planet_terrain2)

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
                    if (response.body() != null) run {
                        planet = response.body()!!

                        if (planet != null) {
                            planetName.setText(planet.name)
                            planetClimate.setText(planet.climate)
                            planetTerrain.setText(planet.terrain)
                        }
                    }
                }
            })
    }
}
