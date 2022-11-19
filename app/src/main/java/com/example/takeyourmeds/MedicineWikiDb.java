package com.example.takeyourmeds;

import java.util.ArrayList;

// a very poorly implemented database
public class MedicineWikiDb {
    private static ArrayList<Medicine> instance;

    private MedicineWikiDb() {}

    public static ArrayList<Medicine> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Medicine>();
        }
        return instance;
    }
}
