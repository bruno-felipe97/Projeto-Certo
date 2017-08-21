package com.example.ismael.teste;

/**
 * Created by Bruno on 17/08/17.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
   private ArrayList<Games> android;


    public DataAdapter(ArrayList<Games> android) {
        this.android = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.id_game.setText(android.get(i).getId());
        viewHolder.game_name.setText(android.get(i).getName());
        viewHolder.date_game.setText(android.get(i).getRelease_date());
        viewHolder.plataformas_game.setText(String.valueOf(android.get(i).getPlatforms()));
        viewHolder.imagem_games.setText(String.valueOf(android.get(i).getImage()));
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView game_name,id_game,date_game, plataformas_game, imagem_games;
        public ViewHolder(View view) {
            super(view);

            game_name= (TextView)view.findViewById(R.id.game_name);
            id_game = (TextView)view.findViewById(R.id.id_game);
            date_game = (TextView)view.findViewById(R.id.date_game);
            plataformas_game = (TextView)view.findViewById(R.id.plataformas_games);
            imagem_games = (TextView)view.findViewById(R.id.image_games);


        }
    }

}