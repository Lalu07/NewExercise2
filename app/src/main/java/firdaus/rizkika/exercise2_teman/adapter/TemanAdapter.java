package firdaus.rizkika.exercise2_teman.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import firdaus.rizkika.exercise2_teman.R;
import firdaus.rizkika.exercise2_teman.database.Teman;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman>listdata;

    public TemanAdapter(ArrayList<Teman> listdata) {
        this.listdata = listdata;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm,tlp;

        nm = listdata.get(position).getNama();
        tlp = listdata.get(position).getTelpon();

        holder.namaText.setText(nm);
        holder.telponText.setText(tlp);
    }

    @Override
    public int getItemCount() {
        return(listdata != null)?listdata.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaText,telponText;

        public TemanViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.CV1);
            namaText = (TextView) view.findViewById(R.id.textNama);
            telponText = (TextView) view.findViewById(R.id.textTelpon);
        }
    }
}
