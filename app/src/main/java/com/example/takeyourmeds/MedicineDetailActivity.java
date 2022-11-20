package com.example.takeyourmeds;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MedicineDetailActivity extends AppCompatActivity {

    private MedicineDb medicineDb;
    private Medicine medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail);

        medicineDb = MedicineDb.getInstance();

        Intent intent = getIntent();
        medicine = (Medicine) intent.getExtras().get("medicine");

        if (medicine != null) {
            TextView medName = findViewById(R.id.medName);
            TextView medHtu = findViewById(R.id.medHtu);
            TextView medDoctor = findViewById(R.id.medDoctor);
            TextView medPersonal = findViewById(R.id.medPersonal);

            medName.setText(medicine.getName());
            medHtu.setText(medicine.getHowToUse());
            medDoctor.setText(medicine.getDoctorNote());
            medPersonal.setText(medicine.getPersonalNote());
        }
    }

    public void onBack(View view) {
        finish();
    }

    public void onAddToDaily(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MedicineDetailActivity.this);

        alertDialogBuilder
                .setMessage("Add this medicine to the daily list?")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (medicine != null) {
                            medicineDb.getDailyMedicines().add(new DailyMedicine(medicine, false));
                            Toast.makeText(MedicineDetailActivity.this, medicine.getName() + " has been added to the daily list", Toast.LENGTH_SHORT).show();
                        }
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
}