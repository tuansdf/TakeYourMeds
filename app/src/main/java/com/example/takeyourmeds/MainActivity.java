package com.example.takeyourmeds;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView dailyMedicineRV;

    private DailyMedicineRVAdapter adapter;
    private MedicineWikiDb medicineWikiDb;
    private DailyMedicineDb dailyMedicineDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize medicines
        medicineWikiDb = MedicineWikiDb.getInstance();
        ArrayList<Medicine> medicines = medicineWikiDb.getMedicines();

        Medicine m1 = new Medicine("Medicine 1", "Take with a cup of water", "", "");
        Medicine m2 = new Medicine("Medicine 2", "Take with a cup of salt", "", "");
        Medicine m3 = new Medicine("Medicine 3", "Take with a cup of honey", "", "");
        Medicine m4 = new Medicine("Medicine 4", "Take with a cup of sugar", "", "");
        Medicine nm1 = new Medicine("Not a Medicine 1", "Take with a cup of sugar", "", "");
        Medicine nm2 = new Medicine("Not a Medicine 2", "Take with a cup of sugar", "", "");
        Medicine nm3 = new Medicine("Not a Medicine 3", "Take with a cup of sugar", "", "");
        Medicine nm4 = new Medicine("Not a Medicine 4", "Take with a cup of sugar", "", "");

        medicines.add(m1);
        medicines.add(m2);
        medicines.add(m3);
        medicines.add(m4);
        medicines.add(nm1);
        medicines.add(nm2);
        medicines.add(nm3);
        medicines.add(nm4);

        dailyMedicineDb = DailyMedicineDb.getInstance();
        ArrayList<DailyMedicine> dailyMedicines = dailyMedicineDb.getDailyMedicines();

        DailyMedicine dm1 = new DailyMedicine(m1, true);
        DailyMedicine dm2 = new DailyMedicine(m2, false);
        DailyMedicine dm3 = new DailyMedicine(nm3, false);
        DailyMedicine dm4 = new DailyMedicine(nm4, false);

        dailyMedicines.add(dm1);
        dailyMedicines.add(dm2);
        dailyMedicines.add(dm3);
        dailyMedicines.add(dm4);

        // main
        dailyMedicineRV = findViewById(R.id.medRV);

        adapter = new DailyMedicineRVAdapter(this);
        adapter.setDailyMedicines(dailyMedicines);

        dailyMedicineRV.setAdapter(adapter);
        dailyMedicineRV.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onCreateMedicine(View view) {
        Intent intent = new Intent(this, MedicineWikiActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<DailyMedicine> dailyMedicines = dailyMedicineDb.getDailyMedicines();
                String name = (String) data.getExtras().get("medName");
                String htu = (String) data.getExtras().get("htu");
                String drNote = (String) data.getExtras().get("drNote");
                String pNote = (String) data.getExtras().get("pNote");
                Medicine m = new Medicine(name, htu, drNote, pNote);
                dailyMedicines.add(new DailyMedicine(m, false));
                adapter.setDailyMedicines(dailyMedicines);
            }
        }
    }
}