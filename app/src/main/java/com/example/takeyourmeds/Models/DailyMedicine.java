package com.example.takeyourmeds.Models;

import com.example.takeyourmeds.Models.Medicine;

public class DailyMedicine {
    private Medicine medicine;
    private boolean done;

    public DailyMedicine(Medicine medicine, boolean done) {
        this.medicine = medicine;
        this.done = done;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "DailyMedicine{" +
                "medicine=" + medicine +
                ", done=" + done +
                '}';
    }
}
