package com.example.takeyourmeds;

import java.util.ArrayList;

// a very poorly implemented database
public class WikiMedicineDb {
    private static ArrayList<Medicine> instance;

    private WikiMedicineDb() {}

    public static ArrayList<Medicine> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Medicine>();
        }
        return instance;
    }
}
