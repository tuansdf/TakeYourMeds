package com.example.takeyourmeds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeyourmeds.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView dailyMedicineRV;

    private DailyMedicineRVAdapter adapter;
    private MedicineDb medicineWikiDb;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // initialize medicines
        medicineWikiDb = MedicineDb.getInstance();

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

        ArrayList<DailyMedicine> dailyMedicines = medicineWikiDb.getDailyMedicines();

        DailyMedicine dm1 = new DailyMedicine(m1, true);
        DailyMedicine dm2 = new DailyMedicine(m2, false);
        DailyMedicine dm3 = new DailyMedicine(nm3, false);
        DailyMedicine dm4 = new DailyMedicine(nm4, false);
        DailyMedicine dm5 = new DailyMedicine(m1, false);

        dailyMedicines.add(dm1);
        dailyMedicines.add(dm2);
        dailyMedicines.add(dm3);
        dailyMedicines.add(dm4);
        dailyMedicines.add(dm5);

        // default fragment when opening the app
        replaceFragment(new DailyMedicineFragment());

        // bind bottom navigation
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_daily:
                    replaceFragment(new DailyMedicineFragment());
                    break;
                case R.id.action_wiki:
                    replaceFragment(new MedicineWikiFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}