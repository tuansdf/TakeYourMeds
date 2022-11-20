package com.example.takeyourmeds.Activities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.takeyourmeds.Models.DailyMedicine;
import com.example.takeyourmeds.Adapters.DailyMedicineRVAdapter;
import com.example.takeyourmeds.Database.MedicineDb;
import com.example.takeyourmeds.R;

import java.util.ArrayList;

public class DailyMedicineFragment extends Fragment {

    private DailyMedicineRVAdapter adapter;
    private MedicineDb medicineWikiDb;

    public DailyMedicineFragment() {
        // Required empty public constructor
    }

    public static DailyMedicineFragment newInstance() {
        DailyMedicineFragment fragment = new DailyMedicineFragment();
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
        View v = inflater.inflate(R.layout.fragment_daily_medicine, container, false);

        medicineWikiDb = MedicineDb.getInstance();
        ArrayList<DailyMedicine> dailyMedicines = medicineWikiDb.getDailyMedicines();

        RecyclerView dailyMedicineRV = v.findViewById(R.id.medRV);

        adapter = new DailyMedicineRVAdapter(v.getContext());
        adapter.setDailyMedicines(dailyMedicines);

        dailyMedicineRV.setAdapter(adapter);
        dailyMedicineRV.setLayoutManager(new LinearLayoutManager(v.getContext()));

        return v;
    }
}