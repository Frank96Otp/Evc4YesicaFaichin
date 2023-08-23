package com.example.evc4_faichin_diaz_movidedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.evc4_faichin_diaz_movidedb.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private SharedPreferences sharePreferences;

    public static  String SESSION_PREFERENCE = "SESION_PREFERENCE";

    public static  String SESSION_ACTIVATED = "SESION_ACTIVATED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sharePreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boolean isSessionActivated = sharePreferences.getBoolean(SESSION_ACTIVATED, false);

        if(isSessionActivated){
            goToMenu();
        }else{
            setView();
        }

    }

    private void setView() {

        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.btnLogin.setEnabled(validateEmailPassword(charSequence.toString(), binding.etPassword.getText().toString()));
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.btnLogin.setEnabled(validateEmailPassword(binding.etEmail.getText().toString(), charSequence.toString()));
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.btnLogin.setOnClickListener( v ->  {


              sharePreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();

                String email = binding.etEmail.getText().toString();
                String password = binding.etPassword.getText().toString();

                if(validation(email,password)){
                    goToMenu();
                }else{
                    Toast.makeText(binding.btnLogin.getContext(),"Clave o contraseña invalida",Toast.LENGTH_LONG).show();
                }


        });

    }

    private boolean validation(String id, String contra) {
        if(id.equalsIgnoreCase("ejemplo@idat.com.pe") && contra.equalsIgnoreCase("peru123")){
            System.out.println("mensaje verdadero");
            return true;
        }else{
            System.out.println("mensaje FASLSSOOO");
            return false;
        }
    }

    private void goToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validateEmailPassword(String email, String password) {
        boolean validateEmail = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean validatePassword = password.length() >= 6;

        return validateEmail && validatePassword;
    }


}