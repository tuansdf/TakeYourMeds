package com.example.takeyourmeds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeyourmeds.databinding.ActivityMainBinding;

import java.util.ArrayList;

// Acknowledgement: Medicine information taken from https://www.webmd.com/

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

        Medicine m1 = new Medicine("Acetaminophen", "Take this product by mouth as directed.", "If you are giving acetaminophen to a child, be sure you use a product that is meant for children. Use your child's weight to find the right dose on the product package. If you don't know your child's weight, you can use their age.", "Nothing");
        Medicine m2 = new Medicine("Atenolol", "Take this medication by mouth with or without food as directed by your doctor, usually 1 to 2 times daily.", "Apple juice and orange juice may prevent your body from fully absorbing atenolol. It is best to avoid drinking apple/orange juice within 4 hours of taking atenolol, unless your doctor or pharmacist tells you otherwise.", "Nothing");
        Medicine m3 = new Medicine("Contin", "Take this drug with or without food as directed by your doctor, usually every 8 hours or 12 hours. Swallow the tablets whole. Do not break, crush, chew, or dissolve the tablet. Doing so can release all of the drug at once, increasing the risk of morphine overdose.", "Do not increase your dose or use this drug more often or for longer than prescribed, because your risk of side effects may increase.", "Nothing");
        Medicine m4 = new Medicine("Atenolol", " You may take this drug with or without food.", "If you are using a liquid form of this medication, use a medication measuring device to carefully measure the prescribed dose. Do not use a household spoon because you may not get the correct dose.", "Nothing");
        Medicine m5 = new Medicine("Oxycodone-Acetaminophen", "You may take this drug with or without food.", "Avoid eating grapefruit or drinking grapefruit juice while using this medication unless your doctor or pharmacist says you may do so safely. Grapefruit can increase the chance of side effects with this medicine. Ask your doctor or pharmacist for more details.", "Nothing");
        Medicine m6 = new Medicine("Hydrocodone-Acetaminophen", "Take this medication by mouth as directed by your doctor. You may take this drug with or without food.", "If you are using a liquid form of this medication, use a medication measuring device to carefully measure the prescribed dose. Do not use a household spoon because you may not get the correct dose.", "Nothing");
        Medicine m7 = new Medicine("Cetirizine", "If you are using the chewable tablets, chew each tablet well and swallow. If you are using the rapidly-dissolving tablet, allow the tablet to dissolve on the tongue and then swallow, with or without water. If you are using the liquid form of this medication, measure the dose carefully using a special measuring device/spoon. Do not use a household spoon because you may not get the correct dose.", "The dosage is based on your age, medical condition, and response to treatment. Do not increase your dose or take this medication more often than directed.", "Nothing");
        Medicine m8 = new Medicine("Ibuprofen", "Take this medication by mouth, usually every 4 to 6 hours with a full glass of water (8 ounces/240 milliliters) unless your doctor directs you otherwise.", "Do not lie down for at least 10 minutes after taking this drug. If you have stomach upset while taking this medication, take it with food, milk, or an antacid.", "Nothing");

        medicines.add(m1);
        medicines.add(m2);
        medicines.add(m3);
        medicines.add(m4);
        medicines.add(m5);
        medicines.add(m6);
        medicines.add(m7);
        medicines.add(m8);

        ArrayList<DailyMedicine> dailyMedicines = medicineWikiDb.getDailyMedicines();

        DailyMedicine dm1 = new DailyMedicine(m1, false);
        DailyMedicine dm2 = new DailyMedicine(m2, false);
        DailyMedicine dm3 = new DailyMedicine(m5, false);
        DailyMedicine dm4 = new DailyMedicine(m7, false);
        DailyMedicine dm5 = new DailyMedicine(m8, false);

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