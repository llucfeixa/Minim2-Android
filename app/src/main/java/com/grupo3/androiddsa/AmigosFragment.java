package com.grupo3.androiddsa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.grupo3.androiddsa.adapters.AdapterRanking;
import com.grupo3.androiddsa.domain.Partida;
import com.grupo3.androiddsa.retrofit.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmigosFragment extends Fragment {
    public List<Partida> listPartida;
    private RecyclerView recycler;
    private AdapterRanking adapterRanking;
    private ProgressBar progressBarStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_amigos, container, false);
        recycler=(RecyclerView) rootView.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        progressBarStore = rootView.findViewById(R.id.progressBarStore);
        getListPartidaByPoints();
        return rootView;
    }
    private void getListPartidaByPoints(){
        progressBarStore.setVisibility(View.VISIBLE);
        Api service = Api.retrofit.create(Api.class);
        Call<List<Partida>> call=service.getPartidasByPoints();
        call.enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                progressBarStore.setVisibility(View.GONE);
                listPartida=response.body();
                adapterRanking=new AdapterRanking(listPartida);
                recycler.setAdapter(adapterRanking);
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_LONG).show();
                progressBarStore.setVisibility(View.GONE);
            }
        });
    }
}