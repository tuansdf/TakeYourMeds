package com.example.takeyourmeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// medicine recycler view adapter
public class DailyMedicineRVAdapter extends RecyclerView.Adapter<DailyMedicineRVAdapter.ViewHolder> {
    private ArrayList<DailyMedicine> medicines = new ArrayList<>();
    private Context context;

    public DailyMedicineRVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyMedicine dm = medicines.get(position);
        String txt = dm.getMedicine().getName();
        holder.medName.setText(txt);

        ImageView tick = holder.tick;
        tick.setVisibility(dm.isDone() ? View.VISIBLE : View.INVISIBLE);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dm.isDone()) {
                    tick.setVisibility(View.INVISIBLE);
                    dm.setDone(false);
                } else {
                    tick.setVisibility(View.VISIBLE);
                    dm.setDone(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setDailyMedicines(ArrayList<DailyMedicine> dailyMedicines) {
        this.medicines = dailyMedicines;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView medName;
        private final LinearLayout parent;
        private final ImageView tick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medName = itemView.findViewById(R.id.medName);
            parent = itemView.findViewById(R.id.medParent);
            tick = itemView.findViewById((R.id.tickIcon));
        }
    }
}
