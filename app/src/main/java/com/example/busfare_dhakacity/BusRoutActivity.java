package com.example.busfare_dhakacity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusRoutActivity extends AppCompatActivity {

    private TextView busNameText;
    private ListView listView;
    String busName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_rout);
        getSupportActionBar().hide();

        listView = findViewById(R.id.bus_details_route);
        busNameText = findViewById(R.id.busNameId);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            busName = extras.getString("key");
            busNameText.setText(busName);
        }

        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, R.layout.bus_details_list, R.id.rout_name_id, busRout(busName));
        listView.setAdapter(mHistory);


    }

    public static List<String> busRout(String busName) {

        String[] Rojonigondha = {
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
                "Ghatar Char"
        };

        String[] City_Link = {
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
                "Ghatar Char"
        };

        String[] Sadhin = {"z", "m", "x", "n", "d"};
        String[] Torongo_plus = {"a", "b", "c", "d"};
        String[] Romjan = {"n", "b", "y", "x", "a"};

        List<String> rout = new ArrayList();
        if (busName.equalsIgnoreCase("Rojonigondha")) {
            for (int i = 0; i < Rojonigondha.length; i++) {
                rout.add(Rojonigondha[i]);
            }
        }
        if (busName.equalsIgnoreCase("City Link")) {
            for (int i = 0; i < City_Link.length; i++) {
                rout.add(City_Link[i]);
            }
        }
        if (busName.equalsIgnoreCase("Sadhin")) {
            for (int i = 0; i < Sadhin.length; i++) {
                rout.add(Sadhin[i]);
            }
        }

        return rout;
    }
}