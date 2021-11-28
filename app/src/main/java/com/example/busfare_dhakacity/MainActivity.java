package com.example.busfare_dhakacity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private Button searchButton;
    private String[] busDistanceName;
    String from, to;


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

        searchButton.setOnClickListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, busDistanceName);
        fromautoCompleteTextView.setThreshold(1);
        toautoCompleteTextView.setThreshold(1);

        fromautoCompleteTextView.setAdapter(adapter);
        toautoCompleteTextView.setAdapter(adapter);



        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allBuses());
        listView.setAdapter(mHistory);
    }


    @Override
    public void onClick(View v) {

        from = textInputLayout1.getEditText().getText().toString();
        to = textInputLayout2.getEditText().getText().toString();
        String searchText = from + " - " + to;
        searchTextView.setText(searchText);

        String distance = dis(from, to);
        distanceView.setText("Distance: " + distance + " KM");

        int busFare = busRent(from, to);
        busFareView.setText("Bus Fare: " + busFare + " TK");


        List<String> busList = bus(from, to);
        ArrayAdapter<String> mHistory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, busList);
        listView.setAdapter(mHistory);


        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }

        Toast.makeText(getApplicationContext(), searchText, Toast.LENGTH_SHORT).show();

    }


    public static List<String> bus(String from, String to) {

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

        List<String> elementList = new ArrayList();
        boolean fcheck;
        boolean tcheck;

        //bus
        fcheck = false;
        tcheck = false;
        for (int i = 0; i < Rojonigondha.length; i++) {

            if (Rojonigondha[i].equals(from)) {
                fcheck = true;
            } else if (Rojonigondha[i].equals(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Rojonigondha");
        }

        //bus
        fcheck = false;
        tcheck = false;
        for (int i = 0; i < City_Link.length; i++) {
            if (City_Link[i].equals(from)) {
                fcheck = true;
            } else if (City_Link[i].equals(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("City Link");
        }

        //bus
        fcheck = false;
        tcheck = false;
        for (int i = 0; i < Sadhin.length; i++) {
            if (Sadhin[i].equals(from)) {
                fcheck = true;
            } else if (Sadhin[i].equals(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Sadhin");
        }

        //bus
        fcheck = false;
        tcheck = false;
        for (int i = 0; i < Torongo_plus.length; i++) {
            if (Torongo_plus[i].equals(from)) {
                fcheck = true;
            } else if (Torongo_plus[i].equals(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Torongo Plus");
        }

        //bus
        fcheck = false;
        tcheck = false;
        for (int i = 0; i < Romjan.length; i++) {
            if (Romjan[i].equals(from)) {
                fcheck = true;
            } else if (Romjan[i].equals(to)) {
                tcheck = true;
            }
        }
        if (fcheck && tcheck) {
            elementList.add("Romjan");
        }

        return elementList;

    }

    public static int busRent(String a, String b) {
        double from = 0.0;
        double to = 0.0;
        double distance;
        if ("Chittagong Road".equals(a)) {
            from = 0.0;
        }
        if ("Sign Board".equals(a)) {
            from = 2.9;
        }
        if ("Matuail".equals(a)) {
            from = 4.4;
        }
        if ("Rayerbag".equals(a)) {
            from = 5.5;
        }
        if ("Shonir Akhra".equals(a)) {
            from = 6.3;
        }
        if ("Jatrabari".equals(a)) {
            from = 8.1;
        }
        if ("Sayedabad".equals(a)) {
            from = 9.3;
        }
        if ("Gulistan".equals(a)) {
            from = 11.2;
        }
        if ("GPO".equals(a)) {
            from = 11.9;
        }
        if ("Paltan".equals(a)) {
            from = 12.2;
        }
        if ("Press Club".equals(a)) {
            from = 12.2;
        }
        if ("High Court".equals(a)) {
            from = 13.1;
        }
        if ("Shahbag".equals(a)) {
            from = 14.0;
        }
        if ("Bata Signal".equals(a)) {
            from = 14.6;
        }
        if ("Science Lab".equals(a)) {
            from = 15.2;
        }
        if ("City College".equals(a)) {
            from = 15.5;
        }
        if ("Jigatola".equals(a)) {
            from = 16.4;
        }
        if ("Dhanmondi 15".equals(a)) {
            from = 17.0;
        }
        if ("Star Kabab".equals(a)) {
            from = 17.4;
        }
        if ("Shankar".equals(a)) {
            from = 17.9;
        }
        if ("Mohammadpur".equals(a)) {
            from = 19.0;
        }
        if ("Bosila".equals(a)) {
            from = 21.7;
        }
        if ("Washpur".equals(a)) {
            from = 23.6;
        }
        if ("Arshinagar".equals(a)) {
            from = 24.1;
        }
        if ("Ghatar Char".equals(a)) {
            from = 26.0;
        }

        if ("Chittagong Road".equals(b)) {
            to = 0.0;
        }
        if ("Sign Board".equals(b)) {
            to = 2.9;
        }
        if ("Matuail".equals(b)) {
            to = 4.4;
        }
        if ("Rayerbag".equals(b)) {
            to = 5.5;
        }
        if ("Shonir Akhra".equals(b)) {
            to = 6.3;
        }
        if ("Jatrabari".equals(b)) {
            to = 8.1;
        }
        if ("Sayedabad".equals(b)) {
            to = 9.3;
        }
        if ("Gulistan".equals(b)) {
            to = 11.2;
        }
        if ("GPO".equals(b)) {
            to = 11.9;
        }
        if ("Paltan".equals(b)) {
            to = 12.2;
        }
        if ("Press Club".equals(b)) {
            to = 12.2;
        }
        if ("High Court".equals(b)) {
            to = 13.1;
        }
        if ("Shahbag".equals(b)) {
            to = 14.0;
        }
        if ("Bata Signal".equals(b)) {
            to = 14.6;
        }
        if ("Science Lab".equals(b)) {
            to = 15.2;
        }
        if ("City College".equals(b)) {
            to = 15.5;
        }
        if ("Jigatola".equals(b)) {
            to = 16.4;
        }
        if ("Dhanmondi 15".equals(b)) {
            to = 17.0;
        }
        if ("Star Kabab".equals(b)) {
            to = 17.4;
        }
        if ("Shankar".equals(b)) {
            to = 17.9;
        }
        if ("Mohammadpur".equals(b)) {
            to = 19.0;
        }
        if ("Bosila".equals(b)) {
            to = 21.7;
        }
        if ("Washpur".equals(b)) {
            to = 23.6;
        }
        if ("Arshinagar".equals(b)) {
            to = 24.1;
        }
        if ("Ghatar Char".equals(b)) {
            to = 26.0;
        }

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
        return rent;
    }

    public static String dis(String a, String b) {
        double from = 0.0;
        double to = 0.0;
        double distance;
        if ("Chittagong Road".equals(a)) {
            from = 0.0;
        }
        if ("Sign Board".equals(a)) {
            from = 2.9;
        }
        if ("Matuail".equals(a)) {
            from = 4.4;
        }
        if ("Rayerbag".equals(a)) {
            from = 5.5;
        }
        if ("Shonir Akhra".equals(a)) {
            from = 6.3;
        }
        if ("Jatrabari".equals(a)) {
            from = 8.1;
        }
        if ("Sayedabad".equals(a)) {
            from = 9.3;
        }
        if ("Gulistan".equals(a)) {
            from = 11.2;
        }
        if ("GPO".equals(a)) {
            from = 11.9;
        }
        if ("Paltan".equals(a)) {
            from = 12.2;
        }
        if ("Press Club".equals(a)) {
            from = 12.2;
        }
        if ("High Court".equals(a)) {
            from = 13.1;
        }
        if ("Shahbag".equals(a)) {
            from = 14.0;
        }
        if ("Bata Signal".equals(a)) {
            from = 14.6;
        }
        if ("Science Lab".equals(a)) {
            from = 15.2;
        }
        if ("City College".equals(a)) {
            from = 15.5;
        }
        if ("Jigatola".equals(a)) {
            from = 16.4;
        }
        if ("Dhanmondi 15".equals(a)) {
            from = 17.0;
        }
        if ("Star Kabab".equals(a)) {
            from = 17.4;
        }
        if ("Shankar".equals(a)) {
            from = 17.9;
        }
        if ("Mohammadpur".equals(a)) {
            from = 19.0;
        }
        if ("Bosila".equals(a)) {
            from = 21.7;
        }
        if ("Washpur".equals(a)) {
            from = 23.6;
        }
        if ("Arshinagar".equals(a)) {
            from = 24.1;
        }
        if ("Ghatar Char".equals(a)) {
            from = 26.0;
        }

        if ("Chittagong Road".equals(b)) {
            to = 0.0;
        }
        if ("Sign Board".equals(b)) {
            to = 2.9;
        }
        if ("Matuail".equals(b)) {
            to = 4.4;
        }
        if ("Rayerbag".equals(b)) {
            to = 5.5;
        }
        if ("Shonir Akhra".equals(b)) {
            to = 6.3;
        }
        if ("Jatrabari".equals(b)) {
            to = 8.1;
        }
        if ("Sayedabad".equals(b)) {
            to = 9.3;
        }
        if ("Gulistan".equals(b)) {
            to = 11.2;
        }
        if ("GPO".equals(b)) {
            to = 11.9;
        }
        if ("Paltan".equals(b)) {
            to = 12.2;
        }
        if ("Press Club".equals(b)) {
            to = 12.2;
        }
        if ("High Court".equals(b)) {
            to = 13.1;
        }
        if ("Shahbag".equals(b)) {
            to = 14.0;
        }
        if ("Bata Signal".equals(b)) {
            to = 14.6;
        }
        if ("Science Lab".equals(b)) {
            to = 15.2;
        }
        if ("City College".equals(b)) {
            to = 15.5;
        }
        if ("Jigatola".equals(b)) {
            to = 16.4;
        }
        if ("Dhanmondi 15".equals(b)) {
            to = 17.0;
        }
        if ("Star Kabab".equals(b)) {
            to = 17.4;
        }
        if ("Shankar".equals(b)) {
            to = 17.9;
        }
        if ("Mohammadpur".equals(b)) {
            to = 19.0;
        }
        if ("Bosila".equals(b)) {
            to = 21.7;
        }
        if ("Washpur".equals(b)) {
            to = 23.6;
        }
        if ("Arshinagar".equals(b)) {
            to = 24.1;
        }
        if ("Ghatar Char".equals(b)) {
            to = 26.0;
        }

        if (from > to) {
            distance = from - to;
        } else {
            distance = to - from;
        }

        String result = String.format("%.2f", distance);

        return result;
    }


    List<String> allBuses() {
        String[] allBus = {
                "Achim Paribahan",
                "Active Paribahan",
                "Agradut",
                "Airport Bangabandhu Avenue",
                "Azmeri Glory",
                "Ajmi",
                "Akash",
                "Akik",
                "Al Makka",
                "Al Madina Plus One",
                "Alif",
                "Anabil Super",
                "Arnob",
                "Ashirbad Pahibahan",
                "Ashulia Classic",
                "Asmani",
                "Ayat",
                "Bahon",
                "Baishakhi",
                "Balaka",
                "Basumati",
                "Basumati Transport",
                "Best Satabdi AC",
                "Best Transport",
                "Bhuiyan Paribahan",
                "Bihanga",
                "Bikalpa",
                "Bikalpa",
                "Bikash",
                "Bikash Paribahan",
                "Bondhu Paribahan",
                "Borak",
                "Bashumoti",
                "Brihottor Mirpur",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "BRTC",
                "Cantonment",
                "Cantonment Mini Service",
                "Champion",
                "City Link",
                "D Link",
                "D One Transport",
                "Deepan",
                "Desh Bangla",
                "Dewan",
                "Dhakar Chaka",
                "Dhakar Chaka",
                "Dhaka Metro Service",
                "Dhaka Paribahan",
                "Dipon",
                "Dip Paribahan",
                "Dishari",
                "Elite",
                "ETC",
                "ETC Transport",
                "Everest Paribahan",
                "Falgun Art Transport",
                "First Ten",
                "Gazipur Paribahan",
                "Grameen",
                "Grameen Suveccha",
                "Green Anabil",
                "Green Dhaka",
                "Gulshan Chaka",
                "Hazi Transport",
                "Himachal",
                "Himachal Suveccha",
                "Himalay",
                "Itihash",
                "J M Super Paribahan",
                "Kamal Plus Paribahan",
                "kanak",
                "Khajababa",
                "Kironmala Paribahan",
                "Labbayek",
                "Lal Sabuj (AC)",
                "Lams Paribahan",
                "Malancha",
                "Manjil Express",
                "Meghla Transport",
                "Meshkat",
                "Midline",
                "Mirpur Metro Services",
                "Mirpur Link",
                "Mirpur Mission",
                "Mirpur Transport",
                "Mirpur United Service",
                "MM Lovely",
                "Modhumita",
                "Mohona",
                "Moitri",
                "Moumita",
                "Nur E Makka",
                "Nabakali",
                "New Vision",
                "Nilachol",
                "Nishorgo",
                "Omama International",
                "One Transport",
                "Pallabi Local Service",
                "Pallabi Super",
                "Paristhan",
                "Power Paribahan",
                "Prattay",
                "Prochesta",
                "Projapati",
                "Provati Banasree",
                "Purbachol Logistics and Transport",
                "Raida",
                "Raja City",
                "Rajanigandha",
                "Rajdhani Super",
                "Ramjan",
                "Robrob",
                "Rois",
                "Rongdhonu Express",
                "Runway Express",
                "Rupa Paribahan",
                "Rupkotha",
                "Safety Druti",
                "Sakalpa Transport",
                "Salsabil",
                "Savar Paribahan",
                "Shadhin",
                "Shadhin Express",
                "Shahria Enterprise",
                "Shatabdi",
                "Shikhor Paribahan",
                "Suveccha",
                "Suvojatri",
                "Siam Transport",
                "Skyline",
                "Somota Paribahan",
                "Somoy",
                "Somoy Niyantran",
                "Super",
                "Supravat",
                "Swajan Paribahan",
                "Talukdar",
                "Tanjil Paribahan",
                "Taranga Plus",
                "Tetulia",
                "Thikana",
                "Thikana Express",
                "Titas",
                "Transilva",
                "Trust Transport",
                "Turag",
                "Victor Classic",
                "Victor Paribahan",
                "VIP 27",
                "Welcome",
                "Winner",
                "13 No.",
                "4 No.",
                "6 No.",
                "6 No.",
                "7 No.",
                "8 No.",
                "9 No."
        };

        List<String> allBusList = new ArrayList();
        for (int i = 0; i < allBus.length; i++) {
            allBusList.add(allBus[i]);
        }

        return allBusList;

    }


}