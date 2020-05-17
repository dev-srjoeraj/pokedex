package dev.srjoeraj.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Chain {
    ArrayList< Object > evolution_details = new ArrayList < Object > ();
    ArrayList < Object > evolves_to = new ArrayList < Object > ();
    private boolean is_baby;
    @SerializedName("species")
    Species SpeciesObject;


    // Getter Methods

    public boolean getIs_baby() {
        return is_baby;
    }

    public Species getSpecies() {
        return SpeciesObject;
    }

    // Setter Methods

    public void setIs_baby(boolean is_baby) {
        this.is_baby = is_baby;
    }

    public void setSpecies(Species speciesObject) {
        this.SpeciesObject = speciesObject;
    }
}
