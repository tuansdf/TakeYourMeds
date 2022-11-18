package com.example.takeyourmeds;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView medRV;

    private MedRVAdapter adapter;
    private final ArrayList<Medicine> wikiMedicines = new ArrayList<>();
    private final ArrayList<Medicine> todayMedicines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize medicines
        wikiMedicines.add(new Medicine("med 1", "", "", ""));
        wikiMedicines.add(new Medicine("med 2", "", "", ""));
        wikiMedicines.add(new Medicine("med 3", "", "", ""));
        wikiMedicines.add(new Medicine("med 4", "", "", ""));

        todayMedicines.add(wikiMedicines.get(0));
        todayMedicines.add(wikiMedicines.get(1));
        todayMedicines.add(wikiMedicines.get(2));
        todayMedicines.add(wikiMedicines.get(3));

        // main
        medRV = findViewById(R.id.medRV);

        adapter = new MedRVAdapter(this);
        adapter.setMedicines(todayMedicines);

        medRV.setAdapter(adapter);
        medRV.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onCreateMedicine(View view) {
        Intent intent = new Intent(this, CreateMedActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                String name = (String) data.getExtras().get("medName");
                String htu = (String) data.getExtras().get("htu");
                String drNote = (String) data.getExtras().get("drNote");
                String pNote = (String) data.getExtras().get("pNote");
                todayMedicines.add(new Medicine(name, htu, drNote, pNote));
                adapter.setMedicines(todayMedicines);
            }
        }
    }
}