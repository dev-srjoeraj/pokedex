package dev.srjoeraj.pokedex.service;

import dev.srjoeraj.pokedex.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IPokeApiService {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
