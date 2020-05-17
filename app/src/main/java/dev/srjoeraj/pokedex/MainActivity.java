package dev.srjoeraj.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import dev.srjoeraj.pokedex.adapter.CardSeperator;
import dev.srjoeraj.pokedex.adapter.PokemonAdapter;
import dev.srjoeraj.pokedex.model.Pokemon;
import dev.srjoeraj.pokedex.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements PokemonAdapter.OnCardListener {

    private static final String TAG = "MainActivity";

    private RetrofitConfig mRetrofitConfig;
    private Call<Pokemon> request;


    private RecyclerView mRecyclerView;
    private PokemonAdapter mPokemonAdapter;

    private ArrayList<Pokemon> mPokemons = new ArrayList<>();
    private boolean isScrolling = false;

    private GridLayoutManager mGridLayoutManager;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRetrofitConfig = new RetrofitConfig();
        mRecyclerView = findViewById(R.id.recyclerview);

        progressBar = findViewById(R.id.progressBar);

        initRecyclerView();
        getData(1,200);


    }


    private void initRecyclerView() {
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPokemonAdapter = new PokemonAdapter(this,this);
        mRecyclerView.addItemDecoration(new CardSeperator(8, 8));
        mRecyclerView.setAdapter(mPokemonAdapter);


    }


    private void getData(int start, int end) {

        for (int i = start; i <= end; i++) {

            request = mRetrofitConfig.getPokeApiService().getPokemon(i);
            request.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if (response.isSuccessful()) {
                        Pokemon pokemon = response.body();
                        Log.d(TAG, "onResponse: " + pokemon.getName());
                        Log.d(TAG, "onResponse: url = " + response.body().getSprites());
                        mPokemonAdapter.addPokemon(pokemon);

                    }

                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {

                }
            });
        }
    }


    @Override
    public void onCardClick(int position) {
        Intent intent = new Intent(MainActivity.this, Stats.class);
        intent.putExtra("id", position + 1);
        startActivity(intent);
    }


}

//87288645896