package com.example.busfare_dhakacity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class BusRoutActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_rout);
        getSupportActionBar().hide();

        listView = findViewById(R.id.bus_details_route);
        String[] busRoutRojonigondha = {

                "Chittagong Road",
                "Sign Board",
                "Matuail",
                "Rayerbag",
                "Shonir Akhra",
                "Jatrabari",
                "Sayedabad",
                "Gulistan",
                "GPO",
                "Paltan",
                "Press Club",
                "High Court",
                "Shahbag",
                "Bata Signal",
                "Science Lab",
                "City College",
                "Jigatola",
                "Dhanmondi 15",
                "Star Kabab",
                "Shankar",
                "Mohammadpur",
                "Bosila",
                "Washpur",
                "Arshinagar",
                "Ghatar Char",

        };




        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, R.layout.bus_details_list,R.id.rout_name_id, busRoutRojonigondha);
        listView.setAdapter(mHistory);



    }
}