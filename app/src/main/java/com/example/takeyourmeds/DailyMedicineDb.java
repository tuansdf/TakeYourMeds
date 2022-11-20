package com.example.takeyourmeds;

import java.util.ArrayList;

// a very poorly implemented database
public class DailyMedicineDb {
    private static DailyMedicineDb instance;
    private ArrayList<DailyMedicine> dailyMedicines;

    private DailyMedicineDb() {
        dailyMedicines = new ArrayList<>();
    }

    public static DailyMedicineDb getInstance() {
        if (instance == null) {
            instance = new DailyMedicineDb();
        }
        return instance;
    }

    public ArrayList<DailyMedicine> getDailyMedicines() {
        return dailyMedicines;
    }
}
