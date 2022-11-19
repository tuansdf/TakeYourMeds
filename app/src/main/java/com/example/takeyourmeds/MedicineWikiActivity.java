package com.example.takeyourmeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MedicineWikiActivity extends AppCompatActivity {
    private RecyclerView medicineWikiRV;

    private MedicineWikiRVAdapter adapter;
    private ArrayList<Medicine> wikiMedicines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_wiki);

        medicineWikiRV = findViewById(R.id.medRV);

        wikiMedicines = MedicineWikiDb.getInstance();
        adapter = new MedicineWikiRVAdapter(this);
        adapter.setMedicines(wikiMedicines);

        medicineWikiRV.setAdapter(adapter);
        medicineWikiRV.setLayoutManager(new LinearLayoutManager(this));
    }
}