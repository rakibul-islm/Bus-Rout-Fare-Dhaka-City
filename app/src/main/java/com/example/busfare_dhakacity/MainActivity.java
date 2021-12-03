package com.example.busfare_dhakacity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AutoCompleteTextView fromautoCompleteTextView, toautoCompleteTextView;
    private TextInputLayout textInputLayout1, textInputLayout2;
    private TextView searchTextView, distanceView, busFareView;
    private ListView listView;
    private Button searchButton, allBusButton;
    String[] busDistanceName;
    String from, to;
    String[] bus;
    int routNo = 0;
    List<String> busList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        busDistanceName = getResources().getStringArray(R.array.distance_name);
        fromautoCompleteTextView = findViewById(R.id.fromAutoId);
        toautoCompleteTextView = findViewById(R.id.toAutoId);

        textInputLayout1 = findViewById(R.id.fromId);
        textInputLayout2 = findViewById(R.id.toId);
        searchTextView = findViewById(R.id.searchTextId);
        distanceView = findViewById(R.id.distanceId);
        busFareView = findViewById(R.id.busFareId);
        listView = findViewById(R.id.listViewId);

        searchButton = findViewById(R.id.buttonId);
        allBusButton = findViewById(R.id.allBusId);

        searchButton.setOnClickListener(this);
        allBusButton.setOnClickListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, busDistanceName);
        fromautoCompleteTextView.setThreshold(1);
        toautoCompleteTextView.setThreshold(1);

        fromautoCompleteTextView.setAdapter(adapter);
        toautoCompleteTextView.setAdapter(adapter);


        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, allBuses());
        listView.setAdapter(mHistory);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList = (String) (listView.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(), selectedFromList, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(view.getContext(), BusRoutActivity.class);
                intent.putExtra("key", selectedFromList);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonId) {

            from = textInputLayout1.getEditText().getText().toString();
            to = textInputLayout2.getEditText().getText().toString();
            String searchText = from + " - " + to;
            searchTextView.setText(searchText);

            busList = bus(from, to);
            for (int i = 0; i < busList.size(); i++) {
                if (busList.get(i).equalsIgnoreCase("Rojonigondha")) {
                    routNo = 1;
                }
                if (busList.get(i).equalsIgnoreCase("Sadhin")) {
                    routNo = 2;
                }
                if (busList.get(i).equalsIgnoreCase("Torongo_plus")) {
                    routNo = 3;
                }
                if (busList.get(i).equalsIgnoreCase("Projapati")) {
                    routNo = 4;
                }
            }

            String distance = dis(from, to);
            distanceView.setText("Distance: " + distance + " KM");

            int busFare = busRent(from, to);
            busFareView.setText("Bus Fare: " + busFare + " TK");


            ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, busList);
            listView.setAdapter(mHistory);


            try {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            } catch (Exception e) {
                // TODO: handle exception
            }

            Toast.makeText(getApplicationContext(), searchText, Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.allBusId) {
            ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, allBuses());
            listView.setAdapter(mHistory);
            searchTextView.setText("");
            distanceView.setText("");
            busFareView.setText("");
        }

    }


    public List<String> bus(String from, String to) {

        String[] Rojonigondha = getResources().getStringArray(R.array.Rojonigondha);
        String[] City_Link = getResources().getStringArray(R.array.City_Link);
        String[] Sadhin = getResources().getStringArray(R.array.Sadhin);
        String[] Torongo_plus = getResources().getStringArray(R.array.Torongo_plus);
        String[] Romjan = getResources().getStringArray(R.array.Romjan);
        String[] Projapati = getResources().getStringArray(R.array.Projapati);
        String[] Paristhan = getResources().getStringArray(R.array.Paristhan);

        String[] Achim_Paribahan = getResources().getStringArray(R.array.Achim_Paribahan);
        String[] Ajmi = getResources().getStringArray(R.array.Ajmi);
        String[] Akik = getResources().getStringArray(R.array.Akik);
        String[] Alif_Bus = getResources().getStringArray(R.array.Alif_Bus);
        String[] Arnob_Bus = getResources().getStringArray(R.array.Arnob_Bus);
        String[] Active_Paribahan = getResources().getStringArray(R.array.Active_Paribahan);
        String[] Agradut = getResources().getStringArray(R.array.Agradut);
        String[] Airport_Bangabandhu_Avenue = getResources().getStringArray(R.array.Airport_Bangabandhu_Avenue);
        String[] Akash = getResources().getStringArray(R.array.Akash);
        String[] Al_Madina_Plus = getResources().getStringArray(R.array.Al_Madina_Plus);
        String[] Al_Makka = getResources().getStringArray(R.array.Al_Makka);
        String[] Anabil_Super = getResources().getStringArray(R.array.Anabil_Super);
        String[] Ashirbad_Pahibahan = getResources().getStringArray(R.array.Ashirbad_Pahibahan);
        String[] Ashulia_Classic = getResources().getStringArray(R.array.Ashulia_Classic);
        String[] Asmani = getResources().getStringArray(R.array.Asmani);
        String[] Ayat = getResources().getStringArray(R.array.Ayat);
        String[] Azmeri_Glory = getResources().getStringArray(R.array.Azmeri_Glory);
        String[] Bahon = getResources().getStringArray(R.array.Bahon);
        String[] Baishakhi = getResources().getStringArray(R.array.Baishakhi);
        String[] Balaka = getResources().getStringArray(R.array.Balaka);
        String[] Basumati_Transport = getResources().getStringArray(R.array.Basumati_Transport);
        String[] Basumati = getResources().getStringArray(R.array.Basumati);

        List<String> elementList = new ArrayList();
        boolean fcheck;
        boolean tcheck;

        //bus
        fcheck = false;
        tcheck = false;
        bus = Rojonigondha;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Rojonigondha");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = City_Link;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("City Link");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = Sadhin;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Sadhin");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = Torongo_plus;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Torongo Plus");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = Romjan;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Romjan");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = Projapati;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Projapati");
        }

        //bus
        fcheck = false;
        tcheck = false;
        bus = Paristhan;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Paristhan");
        }


        //bus
        fcheck = false;
        tcheck = false;
        bus = Alif_Bus;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Alif");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Arnob_Bus;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Arnob");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Akik;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Akik");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Akash;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Akash");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Asmani;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Asmani");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Achim_Paribahan;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Achim Paribahan");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Active_Paribahan;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Active Paribahan");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Agradut;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Agradut");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Airport_Bangabandhu_Avenue;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Airport Bangabandhu Avenue");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Ajmi;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Ajmi");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Al_Madina_Plus;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Al Madina Plus");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Al_Makka;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Al Makka");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Anabil_Super;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Anabil Super");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Ashirbad_Pahibahan;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Ashirbad Pahibahan");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Ashulia_Classic;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Ashulia Classic");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Ayat;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Ayat");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Azmeri_Glory;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Azmeri Glory");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Bahon;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Bahon");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Baishakhi;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Baishakhi");
        }
        //bus
        fcheck = false;
        tcheck = false;
        bus = Balaka;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Balaka");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Basumati;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Basumati");
        }//bus
        fcheck = false;
        tcheck = false;
        bus = Basumati_Transport;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].equalsIgnoreCase(from)) {
                fcheck = true;
            } else if (bus[i].equalsIgnoreCase(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Basumati Transport");
        }


        return elementList;

    }








    // bus fare calculation

    public int busRent(String a, String b) {
        double from = 0.0;
        double to = 0.0;
        double distance;

        //busRoutNo1
        if (routNo == 1) {
            if ("Chittagong Road".equalsIgnoreCase(a)) {
                from = 0.0;
            }
            if ("Sign Board".equalsIgnoreCase(a)) {
                from = 2.9;
            }
            if ("Matuail".equalsIgnoreCase(a)) {
                from = 4.4;
            }
            if ("Rayerbag".equalsIgnoreCase(a)) {
                from = 5.5;
            }
            if ("Shonir Akhra".equalsIgnoreCase(a)) {
                from = 6.3;
            }
            if ("Jatrabari".equalsIgnoreCase(a)) {
                from = 8.1;
            }
            if ("Sayedabad".equalsIgnoreCase(a)) {
                from = 9.3;
            }
            if ("Gulistan".equalsIgnoreCase(a)) {
                from = 11.2;
            }
            if ("GPO".equalsIgnoreCase(a)) {
                from = 11.9;
            }
            if ("Paltan".equalsIgnoreCase(a)) {
                from = 12.2;
            }
            if ("Press Club".equalsIgnoreCase(a)) {
                from = 12.2;
            }
            if ("High Court".equalsIgnoreCase(a)) {
                from = 13.1;
            }
            if ("Shahbag".equalsIgnoreCase(a)) {
                from = 14.0;
            }
            if ("Bata Signal".equalsIgnoreCase(a)) {
                from = 14.6;
            }
            if ("Science Lab".equalsIgnoreCase(a)) {
                from = 15.2;
            }
            if ("City College".equalsIgnoreCase(a)) {
                from = 15.5;
            }
            if ("Jigatola".equalsIgnoreCase(a)) {
                from = 16.4;
            }
            if ("Dhanmondi 15".equalsIgnoreCase(a)) {
                from = 17.0;
            }
            if ("Star Kabab".equalsIgnoreCase(a)) {
                from = 17.4;
            }
            if ("Shankar".equalsIgnoreCase(a)) {
                from = 17.9;
            }
            if ("Mohammadpur".equalsIgnoreCase(a)) {
                from = 19.0;
            }
            if ("Bosila".equalsIgnoreCase(a)) {
                from = 21.7;
            }
            if ("Washpur".equalsIgnoreCase(a)) {
                from = 23.6;
            }
            if ("Arshinagar".equalsIgnoreCase(a)) {
                from = 24.1;
            }
            if ("Ghatar Char".equalsIgnoreCase(a)) {
                from = 26.0;
            }

            if ("Chittagong Road".equalsIgnoreCase(b)) {
                to = 0.0;
            }
            if ("Sign Board".equalsIgnoreCase(b)) {
                to = 2.9;
            }
            if ("Matuail".equalsIgnoreCase(b)) {
                to = 4.4;
            }
            if ("Rayerbag".equalsIgnoreCase(b)) {
                to = 5.5;
            }
            if ("Shonir Akhra".equalsIgnoreCase(b)) {
                to = 6.3;
            }
            if ("Jatrabari".equalsIgnoreCase(b)) {
                to = 8.1;
            }
            if ("Sayedabad".equalsIgnoreCase(b)) {
                to = 9.3;
            }
            if ("Gulistan".equalsIgnoreCase(b)) {
                to = 11.2;
            }
            if ("GPO".equalsIgnoreCase(b)) {
                to = 11.9;
            }
            if ("Paltan".equalsIgnoreCase(b)) {
                to = 12.2;
            }
            if ("Press Club".equalsIgnoreCase(b)) {
                to = 12.2;
            }
            if ("High Court".equalsIgnoreCase(b)) {
                to = 13.1;
            }
            if ("Shahbag".equalsIgnoreCase(b)) {
                to = 14.0;
            }
            if ("Bata Signal".equalsIgnoreCase(b)) {
                to = 14.6;
            }
            if ("Science Lab".equalsIgnoreCase(b)) {
                to = 15.2;
            }
            if ("City College".equalsIgnoreCase(b)) {
                to = 15.5;
            }
            if ("Jigatola".equalsIgnoreCase(b)) {
                to = 16.4;
            }
            if ("Dhanmondi 15".equalsIgnoreCase(b)) {
                to = 17.0;
            }
            if ("Star Kabab".equalsIgnoreCase(b)) {
                to = 17.4;
            }
            if ("Shankar".equalsIgnoreCase(b)) {
                to = 17.9;
            }
            if ("Mohammadpur".equalsIgnoreCase(b)) {
                to = 19.0;
            }
            if ("Bosila".equalsIgnoreCase(b)) {
                to = 21.7;
            }
            if ("Washpur".equalsIgnoreCase(b)) {
                to = 23.6;
            }
            if ("Arshinagar".equalsIgnoreCase(b)) {
                to = 24.1;
            }
            if ("Ghatar Char".equalsIgnoreCase(b)) {
                to = 26.0;
            }
        }

        //busRoutNo2
        if (routNo == 2) {
            if ("Chittagong Road".equalsIgnoreCase(a)) {
                from = 0.0;
            }


            if ("Chittagong Road".equalsIgnoreCase(b)) {
                to = 0.0;
            }

        }
        //busRoutNo3


        int rent;

        if (from > to) {
            distance = from - to;
        } else {
            distance = to - from;
        }

        rent = (int) Math.round(distance * 2.15);
        if (rent < 10) {
            rent = 10;
        }
        if (distance == 0.0) {
            rent = 0;
        }
        return rent;
    }

    public String dis(String a, String b) {
        double from = 0.0;
        double to = 0.0;
        double distance;
        //busRoutNo
        if (routNo == 1) {
            if ("Chittagong Road".equalsIgnoreCase(a)) {
                from = 0.0;
            }
            if ("Sign Board".equalsIgnoreCase(a)) {
                from = 2.9;
            }
            if ("Matuail".equalsIgnoreCase(a)) {
                from = 4.4;
            }
            if ("Rayerbag".equalsIgnoreCase(a)) {
                from = 5.5;
            }
            if ("Shonir Akhra".equalsIgnoreCase(a)) {
                from = 6.3;
            }
            if ("Jatrabari".equalsIgnoreCase(a)) {
                from = 8.1;
            }
            if ("Sayedabad".equalsIgnoreCase(a)) {
                from = 9.3;
            }
            if ("Gulistan".equalsIgnoreCase(a)) {
                from = 11.2;
            }
            if ("GPO".equalsIgnoreCase(a)) {
                from = 11.9;
            }
            if ("Paltan".equalsIgnoreCase(a)) {
                from = 12.2;
            }
            if ("Press Club".equalsIgnoreCase(a)) {
                from = 12.2;
            }
            if ("High Court".equalsIgnoreCase(a)) {
                from = 13.1;
            }
            if ("Shahbag".equalsIgnoreCase(a)) {
                from = 14.0;
            }
            if ("Bata Signal".equalsIgnoreCase(a)) {
                from = 14.6;
            }
            if ("Science Lab".equalsIgnoreCase(a)) {
                from = 15.2;
            }
            if ("City College".equalsIgnoreCase(a)) {
                from = 15.5;
            }
            if ("Jigatola".equalsIgnoreCase(a)) {
                from = 16.4;
            }
            if ("Dhanmondi 15".equalsIgnoreCase(a)) {
                from = 17.0;
            }
            if ("Star Kabab".equalsIgnoreCase(a)) {
                from = 17.4;
            }
            if ("Shankar".equalsIgnoreCase(a)) {
                from = 17.9;
            }
            if ("Mohammadpur".equalsIgnoreCase(a)) {
                from = 19.0;
            }
            if ("Bosila".equalsIgnoreCase(a)) {
                from = 21.7;
            }
            if ("Washpur".equalsIgnoreCase(a)) {
                from = 23.6;
            }
            if ("Arshinagar".equalsIgnoreCase(a)) {
                from = 24.1;
            }
            if ("Ghatar Char".equalsIgnoreCase(a)) {
                from = 26.0;
            }

            if ("Chittagong Road".equalsIgnoreCase(b)) {
                to = 0.0;
            }
            if ("Sign Board".equalsIgnoreCase(b)) {
                to = 2.9;
            }
            if ("Matuail".equalsIgnoreCase(b)) {
                to = 4.4;
            }
            if ("Rayerbag".equalsIgnoreCase(b)) {
                to = 5.5;
            }
            if ("Shonir Akhra".equalsIgnoreCase(b)) {
                to = 6.3;
            }
            if ("Jatrabari".equalsIgnoreCase(b)) {
                to = 8.1;
            }
            if ("Sayedabad".equalsIgnoreCase(b)) {
                to = 9.3;
            }
            if ("Gulistan".equalsIgnoreCase(b)) {
                to = 11.2;
            }
            if ("GPO".equalsIgnoreCase(b)) {
                to = 11.9;
            }
            if ("Paltan".equalsIgnoreCase(b)) {
                to = 12.2;
            }
            if ("Press Club".equalsIgnoreCase(b)) {
                to = 12.2;
            }
            if ("High Court".equalsIgnoreCase(b)) {
                to = 13.1;
            }
            if ("Shahbag".equalsIgnoreCase(b)) {
                to = 14.0;
            }
            if ("Bata Signal".equalsIgnoreCase(b)) {
                to = 14.6;
            }
            if ("Science Lab".equalsIgnoreCase(b)) {
                to = 15.2;
            }
            if ("City College".equalsIgnoreCase(b)) {
                to = 15.5;
            }
            if ("Jigatola".equalsIgnoreCase(b)) {
                to = 16.4;
            }
            if ("Dhanmondi 15".equalsIgnoreCase(b)) {
                to = 17.0;
            }
            if ("Star Kabab".equalsIgnoreCase(b)) {
                to = 17.4;
            }
            if ("Shankar".equalsIgnoreCase(b)) {
                to = 17.9;
            }
            if ("Mohammadpur".equalsIgnoreCase(b)) {
                to = 19.0;
            }
            if ("Bosila".equalsIgnoreCase(b)) {
                to = 21.7;
            }
            if ("Washpur".equalsIgnoreCase(b)) {
                to = 23.6;
            }
            if ("Arshinagar".equalsIgnoreCase(b)) {
                to = 24.1;
            }
            if ("Ghatar Char".equalsIgnoreCase(b)) {
                to = 26.0;
            }
        }
        //busRoutNo

        if (from > to) {
            distance = from - to;
        } else {
            distance = to - from;
        }

        String result = String.format("%.2f", distance);

        return result;
    }


    List<String> allBuses() {
        String[] allBus = getResources().getStringArray(R.array.all_bus);

        List<String> allBusList = new ArrayList();
        for (int i = 0; i < allBus.length; i++) {
            allBusList.add(allBus[i]);
        }

        return allBusList;

    }


}