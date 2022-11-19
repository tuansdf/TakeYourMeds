package com.example.takeyourmeds;

import java.util.ArrayList;

// a very poorly implemented database
public class DailyMedicineDb {
    private static ArrayList<DailyMedicine> instance;

    private DailyMedicineDb() {}

    public static ArrayList<DailyMedicine> getInstance() {
        if (instance == null) {
            instance = new ArrayList<>();
        }
        return instance;
    }
}
