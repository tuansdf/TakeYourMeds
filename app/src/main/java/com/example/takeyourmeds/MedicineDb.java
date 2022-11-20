package com.example.takeyourmeds;

import java.util.ArrayList;
import java.util.Locale;

// a very poorly implemented database as a singleton
public class MedicineDb {
    private static MedicineDb instance;
    private final ArrayList<Medicine> medicines;
    private final ArrayList<DailyMedicine> dailyMedicines;

    private int medicineId = 0;

    private MedicineDb() {
        medicines = new ArrayList<>();
        dailyMedicines = new ArrayList<>();
    }

    public static MedicineDb getInstance() {
        if (instance == null) {
            instance = new MedicineDb();
        }
        return instance;
    }

    public ArrayList<Medicine> searchWiki(String name) {
        ArrayList<Medicine> result = new ArrayList<>();
        int length = medicines.size();

        for (int i = 0; i < length; i++) {
            Medicine m = medicines.get(i);
            if (m.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                result.add(m);
            }
        }

        return result;
    }

    public void insertMedicine() {

    }
    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }
    public ArrayList<DailyMedicine> getDailyMedicines() {
        return dailyMedicines;
    }
}
