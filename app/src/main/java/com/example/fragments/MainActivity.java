package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button pegarFragmentRojo;
    private Button pegarFragmentverde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragmentRojo = findViewById(R.id.mainActivity_pegarFragmentRojo);
        pegarFragmentverde = findViewById(R.id.mainActivity_pegarFragmentVerde);
        pegarFragmentRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pegarFragment( new RojoFragment());
            }
        });
        pegarFragmentverde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pegarFragment(new VerdeFragment());
            }
        });
    }

    private void pegarFragment(Fragment unFragment) {
        FragmentManager unFragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = unFragmentManager.beginTransaction();
        unaTransaccion.add(R.id.mainActivity_contenedorDeFragment, unFragment);
        unaTransaccion.addToBackStack(null);
        unaTransaccion.commit();
    }
}
