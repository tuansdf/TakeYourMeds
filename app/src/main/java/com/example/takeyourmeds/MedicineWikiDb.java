package com.example.takeyourmeds;

import java.util.ArrayList;
import java.util.Locale;

// a very poorly implemented database as a singleton
public class MedicineWikiDb {
    private static MedicineWikiDb instance;
    private ArrayList<Medicine> medicines;

    private MedicineWikiDb() {
        medicines = new ArrayList<>();
    }

    public static MedicineWikiDb getInstance() {
        if (instance == null) {
            instance = new MedicineWikiDb();
        }
        return instance;
    }

    public ArrayList<Medicine> search(String name) {
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

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }
}
