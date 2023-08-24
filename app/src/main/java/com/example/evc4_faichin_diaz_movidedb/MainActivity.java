package com.example.evc4_faichin_diaz_movidedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.example.evc4_faichin_diaz_movidedb.Model.Response.DogResponse;
import com.example.evc4_faichin_diaz_movidedb.Model.Retrofit.RetrofitHelper;
import com.example.evc4_faichin_diaz_movidedb.databinding.ActivityLoginBinding;
import com.example.evc4_faichin_diaz_movidedb.databinding.ActivityMainBinding;
import com.example.evc4_faichin_diaz_movidedb.recyclerView.AdapterDogs;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






        RetrofitHelper.getService().getListDogs().enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                    if(response.isSuccessful()){
                        showDogs(response.body().getMessage());
                    }
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {

            }
        });



    }

    private void showDogs(List<String> message) {
        AdapterDogs adapter  = new AdapterDogs(message);
        binding.rvDogs.setAdapter(adapter);
        LinearLayoutManager lnmanager = new LinearLayoutManager(binding.getRoot().getContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvDogs.setLayoutManager(lnmanager);
    }


}