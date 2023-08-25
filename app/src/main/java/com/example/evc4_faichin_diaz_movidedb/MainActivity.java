package com.example.evc4_faichin_diaz_movidedb;

import static com.example.evc4_faichin_diaz_movidedb.LoginActivity.SESSION_ACTIVATED;
import static com.example.evc4_faichin_diaz_movidedb.LoginActivity.SESSION_PREFERENCE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    private ActivityMainBinding binding;
    private SharedPreferences sharePreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharePreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);

        RetrofitHelper.getService().getListDogs().enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                if (response.isSuccessful()) {
                    showDogs(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {

            }
        });

        setSupportActionBar(binding.tbDogs);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dogs_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.search) {
            Log.i("search", "preciono Search");

            binding.svDogs.setVisibility(View.VISIBLE);

        } else if (item.getItemId() == R.id.favoritos) {
            Log.i("favorite", "preciono favorites");
        } else if (item.getItemId() == R.id.logout) {


            sharePreferences.edit().putBoolean(SESSION_ACTIVATED, false).apply();

            gotoLogin();

        } else {
            return false;
        }
        return false;
    }

        private void showDogs (List < String > message) {
            AdapterDogs adapter = new AdapterDogs(message);
            binding.rvDogs.setAdapter(adapter);
            LinearLayoutManager lnmanager = new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false);
            binding.rvDogs.setLayoutManager(lnmanager);
        }

        private void gotoLogin (){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

    }