package com.example.examenfinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovesViewModel movesViewModel = new ViewModelProvider(this).get(MovesViewModel.class);
        movesViewModel.getMoveList();
    }
}