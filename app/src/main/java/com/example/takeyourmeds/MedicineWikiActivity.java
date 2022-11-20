package com.example.takeyourmeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MedicineWikiActivity extends AppCompatActivity {
    private RecyclerView medicineWikiRV;

    private MedicineWikiRVAdapter adapter;
    private MedicineWikiDb medicineWikiDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_wiki);

        medicineWikiRV = findViewById(R.id.medRV);

        medicineWikiDb = MedicineWikiDb.getInstance();
        adapter = new MedicineWikiRVAdapter(this);
        adapter.setMedicines(medicineWikiDb.getMedicines());

        medicineWikiRV.setAdapter(adapter);
        medicineWikiRV.setLayoutManager(new LinearLayoutManager(this));

        EditText editSearch = (EditText) findViewById(R.id.editSearch);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.setMedicines(medicineWikiDb.search(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}