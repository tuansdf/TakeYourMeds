package com.example.takeyourmeds;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// pill recycler view adapter
public class MedRVAdapter extends RecyclerView.Adapter<MedRVAdapter.ViewHolder> {
    private ArrayList<Medicine> medicines = new ArrayList<>();
    private Context context;

    public MedRVAdapter(Context context) {
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
        String txt = medicines.get(position).getName();
        holder.medName.setText(txt);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView tick = (ImageView) view.findViewById(R.id.tickIcon);

                if (tick.getVisibility() == View.VISIBLE) {
                    tick.setVisibility(View.INVISIBLE);
                } else {
                    tick.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView medName;
        private LinearLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medName = itemView.findViewById(R.id.medName);
            parent = itemView.findViewById(R.id.medParent);
        }
    }


}
