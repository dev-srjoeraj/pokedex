package dev.srjoeraj.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Evolution {
    private String baby_trigger_item;

    @SerializedName("chain")
    Chain ChainObject;
    private float id;


    // Getter Methods

    public String getBaby_trigger_item() {
        return baby_trigger_item;
    }

    public Chain getChain() {
        return ChainObject;
    }

    public float getId() {
        return id;
    }

    // Setter Methods

    public void setBaby_trigger_item(String baby_trigger_item) {
        this.baby_trigger_item = baby_trigger_item;
    }

    public void setChain(Chain chainObject) {
        this.ChainObject = chainObject;
    }

    public void setId(float id) {
        this.id = id;
    }
}
