package dev.srjoeraj.pokedex.model;

import java.util.ArrayList;

public class PokemonTypes implements Comparable<PokemonTypes>{

    private int slot;
    private PokemonType type;

    @Override
    public int compareTo(PokemonTypes o) {
        return this.slot - o.slot;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }


}
