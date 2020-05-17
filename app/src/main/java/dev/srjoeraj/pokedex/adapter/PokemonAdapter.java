package dev.srjoeraj.pokedex.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

import dev.srjoeraj.pokedex.R;
import dev.srjoeraj.pokedex.Common;
import dev.srjoeraj.pokedex.model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private static final String TAG = "PokemonAdapter";

    private ArrayList<Pokemon> mPokemons;
    private Context context;
    private OnCardListener mOnCardListener;
    private Common common;

    public PokemonAdapter(Context context, OnCardListener onCardListener) {
        this.mPokemons = new ArrayList<>();
        this.context = context;
        this.mOnCardListener = onCardListener;
        common = new Common();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pokemon_card, parent, false);
        return new ViewHolder(view, mOnCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.pokemonName.setText((common.toTitleCase(mPokemons.get(position).getName())));
        Glide.with(context)
                .load(mPokemons.get(position).getSprites().getFront_default())//enter the image url here .
                .into(holder.pokemon_Image);
    }


    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

    public void addPokemon(Pokemon pokemon) {


        mPokemons.add(pokemon);
        Collections.sort(mPokemons);
        notifyDataSetChanged();

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView pokemonName;
        private ImageView pokemon_Image;
        private OnCardListener onCardListener;


        public ViewHolder(@NonNull View itemView, OnCardListener onCardListener) {
            super(itemView);
            this.pokemonName = itemView.findViewById(R.id.pokemon_name);
            this.pokemon_Image = itemView.findViewById(R.id.pokemon_image);
            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCardListener.onCardClick(getAdapterPosition());
        }
    }

    public interface OnCardListener {
        void onCardClick(int position);

    }
}
