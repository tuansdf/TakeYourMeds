package com.example.takeyourmeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MedicineWikiFragment extends Fragment {

    private Context context;
    private MedicineWikiRVAdapter adapter;
    private MedicineDb medicineWikiDb;

    public MedicineWikiFragment() {
        // Required empty public constructor
    }

    public static MedicineWikiFragment newInstance() {
        MedicineWikiFragment fragment = new MedicineWikiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_medicine_wiki, container, false);
        context = v.getContext();

        // prepare adapter
        RecyclerView medicineWikiRV = v.findViewById(R.id.medRV);
        medicineWikiDb = MedicineDb.getInstance();

        adapter = new MedicineWikiRVAdapter(context);
        adapter.setMedicines(medicineWikiDb.getMedicines());

        medicineWikiRV.setAdapter(adapter);
        medicineWikiRV.setLayoutManager(new LinearLayoutManager(context));

        // main
        EditText editSearch = v.findViewById(R.id.editSearch);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.setMedicines(medicineWikiDb.searchWiki(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        Button createButton = v.findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CreateMedicineActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<Medicine> medicines = medicineWikiDb.getMedicines();

                assert data != null;
                String name = (String) data.getExtras().get("medName");
                String htu = (String) data.getExtras().get("htu");
                String drNote = (String) data.getExtras().get("drNote");
                String pNote = (String) data.getExtras().get("pNote");

                Medicine m = new Medicine(name, htu, drNote, pNote);
                medicines.add(m);

                adapter.setMedicines(medicines);
            }
        }
    }
}