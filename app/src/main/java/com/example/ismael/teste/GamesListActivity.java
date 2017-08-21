package com.example.ismael.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GamesListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Games> data;
    private DataAdapter adapter;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);


        Alerta();
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // loadJSON();
    }
    private void loadJSON() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/1b7jlwii7jfvuh0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<BestGames> call = request.getJSON();
        call.enqueue(new Callback<BestGames>() {
            @Override
            public void onResponse(Call<BestGames> call, Response<BestGames> response) {

                BestGames listagames = response.body();

                data = new ArrayList<>(Arrays.asList(listagames.getBestGames()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<BestGames> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


    private void Alerta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BestGames");
        builder.setMessage("Carregando os dados");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(GamesListActivity.this, "Carregado", Toast.LENGTH_SHORT).show();
                loadJSON();
            }
        });

        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}
