package com.example.takeyourmeds;

import android.content.Context;
import android.content.Intent;
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
public class MedicineWikiRVAdapter extends RecyclerView.Adapter<MedicineWikiRVAdapter.ViewHolder> {
    private ArrayList<Medicine> medicines = new ArrayList<>();
    private Context context;

    public MedicineWikiRVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_medicine_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicine med = medicines.get(position);
        holder.textMedName.setText(med.getName());
        holder.textHtu.setText(med.getHowToUse());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MedicineDetailActivity.class);
                intent.putExtra("medicine", medicines.get(holder.getAdapterPosition()));
                context.startActivity(intent);
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
        private final TextView textMedName;
        private final TextView textHtu;
        private final LinearLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textMedName = itemView.findViewById(R.id.textMedName);
            textHtu = itemView.findViewById(R.id.textHtu);
            parent = itemView.findViewById(R.id.medParent);
        }
    }
}
