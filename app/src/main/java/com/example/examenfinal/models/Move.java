package com.example.examenfinal.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Move {
    private String accuracy;
    private String name;

    @SerializedName("learned_by_pokemon")
    private List<PokemonListItem> pokemons;

    public String getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public List<PokemonListItem> getPokemons() {
        return pokemons;
    }

    public Move(String accuracy, String name, List<PokemonListItem> pokemons) {
        this.accuracy = accuracy;
        this.name = name;
        this.pokemons = pokemons;
    }

    public String getPokemonsString() {
        if (pokemons == null || pokemons.isEmpty()) {
            return "No information available";
        }

        StringBuilder s = new StringBuilder();
        for (PokemonListItem pokemon : pokemons) {
            s.append(pokemon.getName()).append(" ");
        }
        return s.toString();
    }
}
