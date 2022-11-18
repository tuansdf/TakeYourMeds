package com.example.takeyourmeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView medRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize medicines
        ArrayList<Medicine> wikiMedicines = new ArrayList<>();
        wikiMedicines.add(new Medicine("med 1", "", "", ""));
        wikiMedicines.add(new Medicine("med 2", "", "", ""));
        wikiMedicines.add(new Medicine("med 3", "", "", ""));
        wikiMedicines.add(new Medicine("med 4", "", "", ""));

        ArrayList<Medicine> todayMedicines  = new ArrayList<>();
        todayMedicines.add(wikiMedicines.get(0));
        todayMedicines.add(wikiMedicines.get(1));
        todayMedicines.add(wikiMedicines.get(2));
        todayMedicines.add(wikiMedicines.get(3));

        // main
        medRV = findViewById(R.id.medRV);

        MedRVAdapter adapter = new MedRVAdapter(this);
        adapter.setMedicines(todayMedicines);

        medRV.setAdapter(adapter);
        medRV.setLayoutManager(new LinearLayoutManager(this));
    }
}