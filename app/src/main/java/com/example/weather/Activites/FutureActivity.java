package com.example.weather.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Adapters.FutureAdapters;
import com.example.weather.Domains.FutureDomain;
import com.example.weather.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterTommorow;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
       
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ImageView backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FutureActivity.this, MainActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","Storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","Cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","Windy",29,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloudy_Sunny",22,13));
        items.add(new FutureDomain("Wed","sunny","Sunny",28,11));
        items.add(new FutureDomain("Thu","rainy","Rainy",23,12));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new FutureAdapters(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}