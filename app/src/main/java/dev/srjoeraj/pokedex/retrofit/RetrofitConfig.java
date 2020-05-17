package dev.srjoeraj.pokedex.retrofit;

import dev.srjoeraj.pokedex.service.IPokeApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    private String baseURL = "https://pokeapi.co/api/v2/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public IPokeApiService getPokeApiService() {
        return this.retrofit.create(IPokeApiService.class);
    }
}
