package com.example.takeyourmeds.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.takeyourmeds.R;

public class CreateMedicineActivity extends AppCompatActivity {
    private EditText editMedName, editHtu, editDrNote, editPNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_medicine);

        editMedName = (EditText) findViewById(R.id.editMedName);
        editHtu = (EditText) findViewById(R.id.editHtu);
        editDrNote = (EditText) findViewById(R.id.editDrNote);
        editPNote = (EditText) findViewById(R.id.editPNote);
    }

    public void onFinish(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("medName", editMedName.getText().toString());
        intent.putExtra("htu", editHtu.getText().toString());
        intent.putExtra("drNote", editDrNote.getText().toString());
        intent.putExtra("pNote", editPNote.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onCancel(View view) {
        finish();
    }
}