package com.grupo3.androiddsa.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupo3.androiddsa.R;
import com.grupo3.androiddsa.domain.Partida;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRanking extends RecyclerView.Adapter<AdapterRanking.ViewHolder> {

    private List<Partida> listPartidas;

    public interface OnItemClickListener{
        void onItemClick(Partida partida);
    }

    public AdapterRanking(List<Partida> listPartidas) {
        this.listPartidas = listPartidas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView email;
        private TextView date;
        private TextView points;
        private ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.description);
            points = itemView.findViewById(R.id.coins);
            avatar = itemView.findViewById(R.id.imagenAvatar);
        }

        void bindData(final Partida partida){
            email.setText(partida.getEmail());
            date.setText("Date: " + partida.getDate());
            points.setText("Points: " + partida.getPoints());
            Picasso.get().load(partida.getAvatar()).into(avatar);
        }

    }

    @NonNull
    @Override //Enlaza el adaptador con la actividad item_list
    public AdapterRanking.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);

        return new AdapterRanking.ViewHolder(view);
    }

    @Override //Hace la comunicación entre el adaptador y la clase ViewHolder
    public void onBindViewHolder(@NonNull AdapterRanking.ViewHolder holder, int position) {
        holder.bindData(listPartidas.get(position));
    }

    @Override
    public int getItemCount() {
        return listPartidas.size();
    }
}
