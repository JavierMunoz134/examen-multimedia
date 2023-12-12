package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveList;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.models.PokemonListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class MovesViewModel extends AndroidViewModel {
    MutableLiveData<Move> selectedMoveMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<MoveListItem>> listElementosMutableLiveData = new MutableLiveData<>();
    MoveListItem selected;

    public MovesViewModel(@NonNull Application application) {
        super(application);
        getMoveList();  // Llama al método getMoveList al instanciar el ViewModel
    }

    MutableLiveData<List<MoveListItem>> getAll() {
        return listElementosMutableLiveData;
    }

    public void select(MoveListItem moveListItem) {
        selected = moveListItem;
    }

    public MutableLiveData<Move> getSelected() {
        MutableLiveData<Move> moveLiveData = new MutableLiveData<>();
        if (selected != null) {
            PokeAPI.getMove(selected.getName(), moveLiveData);
        }
        return moveLiveData;
    }

    // Método para obtener la lista de movimientos
    public void getMoveList() {
        PokeAPI.getMoveList(listElementosMutableLiveData);
    }
}
