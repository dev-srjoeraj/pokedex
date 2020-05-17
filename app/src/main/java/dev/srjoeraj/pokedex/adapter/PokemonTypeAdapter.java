package dev.srjoeraj.pokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Collections;

import dev.srjoeraj.pokedex.R;
import dev.srjoeraj.pokedex.Common;
import dev.srjoeraj.pokedex.model.PokemonTypes;

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.PokemonTypeViewHolder> {

    private ArrayList<PokemonTypes> pTypes;
    private Common sw = new Common();


    public PokemonTypeAdapter() {
        this.pTypes = new ArrayList<>();

    }

    @NonNull
    @Override
    public PokemonTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chip_item, parent, false);
        return new PokemonTypeViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PokemonTypeViewHolder holder, int position) {

        String type = sw.toTitleCase(pTypes.get(position).getType().getName());
        holder.chip.setText(type); // i really dont think this is right....

    }

    @Override
    public int getItemCount() {
        return pTypes.size();
    }

    class PokemonTypeViewHolder extends RecyclerView.ViewHolder {

        Chip chip;

        public PokemonTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            chip = itemView.findViewById(R.id.chip);


        }
    }

    public void addPokemonTypes(ArrayList<PokemonTypes> pokemonTypes) {

        pTypes.addAll(pokemonTypes);
        Collections.sort(pTypes);
        notifyDataSetChanged();

    }




}
