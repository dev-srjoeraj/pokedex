package dev.srjoeraj.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pokemon implements Comparable<Pokemon>{
    ArrayList< Object > abilities = new ArrayList < Object > ();
    private float base_experience;
    ArrayList < Object > forms = new ArrayList < Object > ();
    ArrayList < Object > game_indices = new ArrayList < Object > ();
    private float height;
    ArrayList < Object > held_items = new ArrayList < Object > ();
    private int id;
    private boolean is_default;
    private String location_area_encounters;
    ArrayList < Object > moves = new ArrayList < Object > ();
    private String name;
    private float order;
    private Species SpeciesObject;
    @SerializedName("sprites")
    private Sprites SpritesObject;



    private ArrayList <PokemonTypes> types = new ArrayList <> ();


    public ArrayList<PokemonTypes> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<PokemonTypes> types) {
        this.types = types;
    }

    private float weight;


    // Getter Methods

    public float getBase_experience() {
        return base_experience;
    }

    public float getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public boolean getIs_default() {
        return is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public String getName() {
        return name;
    }

    public float getOrder() {
        return order;
    }

    public Species getSpecies() {
        return SpeciesObject;
    }

    public Sprites getSprites() {
        return SpritesObject;
    }

    public float getWeight() {
        return weight;
    }

    // Setter Methods

    public void setBase_experience(float base_experience) {
        this.base_experience = base_experience;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(float order) {
        this.order = order;
    }

    public void setSpecies(Species speciesObject) {
        this.SpeciesObject = speciesObject;
    }

    public void setSprites(Sprites spritesObject) {
        this.SpritesObject = spritesObject;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Pokemon o) {
        return this.id - o.id;
    }
}
