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

    private TextView busNameText, busRoutText;
    private ListView listView;
    String busName;
    String[] bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_rout);
        getSupportActionBar().hide();

        listView = findViewById(R.id.bus_details_route);
        busNameText = findViewById(R.id.busNameId);
        busRoutText = findViewById(R.id.busRoutDestinationId);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            busName = extras.getString("key");
            busNameText.setText(busName);
            busRoutText.setText(busRoutDestination(busName));
        }

        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, R.layout.bus_details_list, R.id.rout_name_id, busRout(busName));
        listView.setAdapter(mHistory);


    }

    public List<String> busRout(String busName) {

        String[] Rojonigondha = getResources().getStringArray(R.array.Rojonigondha);
        String[] City_Link = getResources().getStringArray(R.array.City_Link);
        String[] Sadhin = getResources().getStringArray(R.array.Sadhin);
        String[] Torongo_plus = getResources().getStringArray(R.array.Torongo_plus);
        String[] Romjan = getResources().getStringArray(R.array.Romjan);
        String[] Projapati = getResources().getStringArray(R.array.Projapati);
        String[] Paristhan = getResources().getStringArray(R.array.Paristhan);

        List<String> rout = new ArrayList();
        if (busName.equalsIgnoreCase("Rojonigondha")) {
            bus = Rojonigondha;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("City Link")) {
            bus = City_Link;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("Sadhin")) {
            bus = Sadhin;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("Torongo plus")) {
            bus = Torongo_plus;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("Romjan")) {
            bus = Romjan;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("Projapati")) {
            bus = Projapati;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }
        if (busName.equalsIgnoreCase("Paristhan")) {
            bus = Paristhan;
            for (int i = 0; i < bus.length; i++) {
                rout.add(bus[i]);
            }
        }

        return rout;
    }


    public String busRoutDestination(String busName) {
        String from = null;
        String to = null;

        String[] Rojonigondha = getResources().getStringArray(R.array.Rojonigondha);
        String[] City_Link = getResources().getStringArray(R.array.City_Link);
        String[] Sadhin = getResources().getStringArray(R.array.Sadhin);
        String[] Torongo_plus = getResources().getStringArray(R.array.Torongo_plus);
        String[] Romjan = getResources().getStringArray(R.array.Romjan);
        String[] Projapati = getResources().getStringArray(R.array.Projapati);
        String[] Paristhan = getResources().getStringArray(R.array.Paristhan);

        if (busName.equalsIgnoreCase("Rojonigondha")) {
            bus = Rojonigondha;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("City Link")) {
            bus = City_Link;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("Sadhin")) {
            bus = Sadhin;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("Torongo plus")) {
            bus = Torongo_plus;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("Romjan")) {
            bus = Romjan;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("Projapati")) {
            bus = Projapati;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }
        if (busName.equalsIgnoreCase("Paristhan")) {
            bus = Paristhan;
            for (int i = 0; i < bus.length; i++) {
                from = bus[0];
                to = bus[bus.length - 1];
            }
        }

        return from + " - " + to;
    }
}