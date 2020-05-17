package dev.srjoeraj.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;


import dev.srjoeraj.pokedex.adapter.PokemonTypeAdapter;
import dev.srjoeraj.pokedex.model.Pokemon;
import dev.srjoeraj.pokedex.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Stats extends AppCompatActivity {

    private static final String TAG = "Stats";

    private RetrofitConfig mRetrofitConfig;
    private Call<Pokemon> request;

    private ImageView currentImage;
    private Chip height, weight, baseXp;
    private TextView pokeName;
    private Common sw;

    private PokemonTypeAdapter mPokemonTypeAdapter;
    private RecyclerView mTypeRecyclerView;
    private CardView cardView;

    private RelativeLayout relativeLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        mRetrofitConfig = new RetrofitConfig();
        currentImage = findViewById(R.id.pImage);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        baseXp = findViewById(R.id.base_xp);
        pokeName = findViewById(R.id.name);
        sw = new Common();
        cardView = findViewById(R.id.current_pcard);
        mTypeRecyclerView = findViewById(R.id.chip_rv);
        relativeLayout  = findViewById(R.id.relativeLayout);
        initRecyclerView();


        int id = getIntent().getIntExtra("id", -1);
        getData(id);

    }

    private void setContent(Pokemon pokemon) {
        Glide.with(this)
                .load(pokemon.getSprites().getFront_default())//enter the image url here .
                .into(currentImage);
        height.setText(pokemon.getHeight() + " dm");
        weight.setText(pokemon.getWeight() + " hg");
        pokeName.setText(sw.toTitleCase(pokemon.getName()));
        baseXp.setText(String.valueOf(pokemon.getBase_experience()));
        cardView.setVisibility(View.VISIBLE);

    }

    public void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mTypeRecyclerView.setLayoutManager(llm);
        mPokemonTypeAdapter = new PokemonTypeAdapter();
        mTypeRecyclerView.setAdapter(mPokemonTypeAdapter);

    }


    private void getData(int id) {


        request = mRetrofitConfig.getPokeApiService().getPokemon(id);
        request.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body();
                    mPokemonTypeAdapter.addPokemonTypes(pokemon.getTypes());

                    setContent(pokemon);
                }

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }
}


